package com.example.moattravel4.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.moattravel4.entity.MeetingRoom;
import com.example.moattravel4.form.MeetingRoomEditForm;
import com.example.moattravel4.form.MeetingRoomRegisterForm;
import com.example.moattravel4.repository.MeetingRoomRepository;
import com.example.moattravel4.service.MeetingRoomService;

@Controller
@RequestMapping("/admin/meeting_rooms")
public class AdminMeetingRoomController {

	private final MeetingRoomRepository meetingRoomRepository;
	private final MeetingRoomService meetingRoomService;

	public AdminMeetingRoomController(MeetingRoomRepository meetingRoomRepository,
			MeetingRoomService meetingRoomService) {
		this.meetingRoomRepository = meetingRoomRepository;
		this.meetingRoomService = meetingRoomService;
	}

	// 一覧ページ
	@GetMapping
	public String index(Model model,
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable,
			@RequestParam(name = "keyword", required = false) String keyword) {

		Page<MeetingRoom> meetingRoomsPage;

		if (keyword != null && !keyword.isEmpty()) {
			meetingRoomsPage = meetingRoomRepository.findByNameLike("%" + keyword + "%", pageable);
		} else {
			meetingRoomsPage = meetingRoomRepository.findAll(pageable);
		}

		model.addAttribute("meetingRoomsPage", meetingRoomsPage);
		model.addAttribute("keyword", keyword);

		return "admin/meeting_rooms/index";
	}

	// 詳細ページ
	@GetMapping("/{id}")
	public String show(@PathVariable(name = "id") Integer id, Model model) {
		MeetingRoom meetingRoom = meetingRoomRepository.getReferenceById(id);

		model.addAttribute("meetingRoom", meetingRoom);

		return "admin/meeting_rooms/show";
	}

	// 登録ページ表示
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("meetingRoomRegisterForm", new MeetingRoomRegisterForm());
		return "admin/meeting_rooms/register";
	}

	// 登録処理
	@PostMapping("/create")
	public String create(@ModelAttribute @Validated MeetingRoomRegisterForm meetingRoomRegisterForm,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			return "admin/meeting_rooms/register";
		}

		meetingRoomService.create(meetingRoomRegisterForm);
		redirectAttributes.addFlashAttribute("successMessage", "会議室を登録しました。");

		return "redirect:/admin/meeting_rooms";
	}

	// 編集ページ表示
	@GetMapping("/{id}/edit")
	public String edit(@PathVariable(name = "id") Integer id, Model model) {
		MeetingRoom meetingRoom = meetingRoomRepository.getReferenceById(id);
		String imageName = meetingRoom.getImageName();

		MeetingRoomEditForm meetingRoomEditForm = new MeetingRoomEditForm(
				meetingRoom.getId(),
				meetingRoom.getName(),
				null,
				meetingRoom.getDescription(),
				meetingRoom.getPrice(),
				meetingRoom.getCapacity(),
				meetingRoom.getPostalCode(),
				meetingRoom.getAddress(),
				meetingRoom.getPhoneNumber());

		model.addAttribute("imageName", imageName);
		model.addAttribute("meetingRoomEditForm", meetingRoomEditForm);

		return "admin/meeting_rooms/edit";
	}

	// 更新処理
	@PostMapping("/{id}/update")
	public String update(@ModelAttribute @Validated MeetingRoomEditForm meetingRoomEditForm,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			return "admin/meeting_rooms/edit";
		}

		meetingRoomService.update(meetingRoomEditForm);
		redirectAttributes.addFlashAttribute("successMessage", "会議室情報を編集しました。");

		return "redirect:/admin/meeting_rooms";
	}

	// 削除処理
	@PostMapping("/{id}/delete")
	public String delete(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes) {
		meetingRoomService.delete(id);
		redirectAttributes.addFlashAttribute("successMessage", "会議室を削除しました。");

		return "redirect:/admin/meeting_rooms";
	}
}