package com.example.moattravel4.controller;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.moattravel4.entity.MeetingRoom;
import com.example.moattravel4.entity.Reservation;
import com.example.moattravel4.entity.User;
import com.example.moattravel4.form.ReservationInputForm;
import com.example.moattravel4.form.ReservationRegisterForm;
import com.example.moattravel4.repository.MeetingRoomRepository;
import com.example.moattravel4.repository.ReservationRepository;
import com.example.moattravel4.security.UserDetailsImpl;
import com.example.moattravel4.service.ReservationService;

@Controller
public class ReservationController {
	private final ReservationRepository reservationRepository;
	private final MeetingRoomRepository meetingRoomRepository;
	private final ReservationService reservationService;

	public ReservationController(ReservationRepository reservationRepository,
			MeetingRoomRepository meetingRoomRepository, ReservationService reservationService) {
		this.reservationRepository = reservationRepository;
		this.meetingRoomRepository = meetingRoomRepository;
		this.reservationService = reservationService;
	}

	// 予約一覧ページ
	@GetMapping("/reservations")
	public String index(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable,
			Model model) {
		User user = userDetailsImpl.getUser();
		Page<Reservation> reservationPage = reservationRepository.findByUserOrderByCreatedAtDesc(user, pageable);

		model.addAttribute("reservationPage", reservationPage);

		return "reservations/index";
	}

	// 予約入力のチェックと確認画面へのリダイレクト
	@GetMapping("/meeting_rooms/{id}/reservations/input")
	public String input(@PathVariable(name = "id") Integer id,
			@ModelAttribute @Validated ReservationInputForm reservationInputForm,
			BindingResult bindingResult,
			RedirectAttributes redirectAttributes,
			Model model) {
		MeetingRoom meetingRoom = meetingRoomRepository.getReferenceById(id);
		Integer numberOfPeople = reservationInputForm.getNumberOfPeople();
		Integer capacity = meetingRoom.getCapacity();

		if (numberOfPeople != null) {
			if (!reservationService.isWithinCapacity(numberOfPeople, capacity)) {
				FieldError fieldError = new FieldError(bindingResult.getObjectName(), "numberOfPeople",
						"利用人数が定員を超えています。");
				bindingResult.addError(fieldError);
			}
		}

		if (bindingResult.hasErrors()) {
			model.addAttribute("meetingRoom", meetingRoom); // show.htmlで使う変数名に合わせてください
			model.addAttribute("errorMessage", "予約内容に不備があります。");
			return "meeting_rooms/show";
		}

		redirectAttributes.addFlashAttribute("reservationInputForm", reservationInputForm);

		return "redirect:/meeting_rooms/{id}/reservations/confirm";
	}

	// 予約確認画面の表示
	@GetMapping("/meeting_rooms/{id}/reservations/confirm")
	public String confirm(@PathVariable(name = "id") Integer id,
			@ModelAttribute ReservationInputForm reservationInputForm,
			@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
			Model model) {
		MeetingRoom meetingRoom = meetingRoomRepository.getReferenceById(id);
		User user = userDetailsImpl.getUser();

		// チェックイン日とチェックアウト日を取得する
		LocalDate checkinDate = reservationInputForm.getCheckinDate();
		LocalDate checkoutDate = reservationInputForm.getCheckoutDate();

		// 料金を計算する
		Integer price = meetingRoom.getPrice();
		Integer amount = reservationService.calculateAmount(checkinDate, checkoutDate, price);

		ReservationRegisterForm reservationRegisterForm = new ReservationRegisterForm(meetingRoom.getId(), user.getId(),
				checkinDate.toString(), checkoutDate.toString(), reservationInputForm.getNumberOfPeople(), amount);

		model.addAttribute("meetingRoom", meetingRoom);
		model.addAttribute("reservationRegisterForm", reservationRegisterForm);

		return "reservations/confirm";
	}

	// 予約確定処理
	@PostMapping("/meeting_rooms/{id}/reservations/create")
	public String create(@ModelAttribute ReservationRegisterForm reservationRegisterForm) {
		reservationService.create(reservationRegisterForm);

		return "redirect:/reservations?reserved";
	}
}