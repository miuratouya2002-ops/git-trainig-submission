package com.example.moattravel4.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.moattravel4.entity.MeetingRoom;
import com.example.moattravel4.form.ReservationInputForm;
import com.example.moattravel4.repository.MeetingRoomRepository;

@Controller
@RequestMapping("/meeting_rooms")
public class MeetingRoomController {
	private final MeetingRoomRepository meetingRoomRepository;

	public MeetingRoomController(MeetingRoomRepository meetingRoomRepository) {
		this.meetingRoomRepository = meetingRoomRepository;
	}

	@GetMapping
	public String index(@RequestParam(name = "keyword", required = false) String keyword,
			@RequestParam(name = "area", required = false) String area,
			@RequestParam(name = "price", required = false) Integer price,
			@RequestParam(name = "order", required = false) String order,
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable,
			Model model) {
		Page<MeetingRoom> meetingRoomPage;

		if (keyword != null && !keyword.isEmpty()) {
			if (order != null && order.equals("priceAsc")) {
				meetingRoomPage = meetingRoomRepository.findByNameLikeOrAddressLikeOrderByPriceAsc("%" + keyword + "%",
						"%" + keyword + "%", pageable);
			} else {
				meetingRoomPage = meetingRoomRepository.findByNameLikeOrAddressLikeOrderByCreatedAtDesc(
						"%" + keyword + "%", "%" + keyword + "%", pageable);
			}
		} else if (area != null && !area.isEmpty()) {
			if (order != null && order.equals("priceAsc")) {
				meetingRoomPage = meetingRoomRepository.findByAddressLikeOrderByPriceAsc("%" + area + "%", pageable);
			} else {
				meetingRoomPage = meetingRoomRepository.findByAddressLikeOrderByCreatedAtDesc("%" + area + "%",
						pageable);
			}
		} else if (price != null) {
			if (order != null && order.equals("priceAsc")) {
				meetingRoomPage = meetingRoomRepository.findByPriceLessThanEqualOrderByPriceAsc(price, pageable);
			} else {
				meetingRoomPage = meetingRoomRepository.findByPriceLessThanEqualOrderByCreatedAtDesc(price, pageable);
			}
		} else {
			if (order != null && order.equals("priceAsc")) {
				meetingRoomPage = meetingRoomRepository.findAllByOrderByPriceAsc(pageable);
			} else {
				meetingRoomPage = meetingRoomRepository.findAllByOrderByCreatedAtDesc(pageable);
			}
		}

		model.addAttribute("meetingRoomPage", meetingRoomPage);
		model.addAttribute("keyword", keyword);
		model.addAttribute("area", area);
		model.addAttribute("price", price);
		model.addAttribute("order", order);

		return "meeting_rooms/index";

	}

	@GetMapping("/{id}")
	public String show(@PathVariable(name = "id") Integer id, Model model) {
		MeetingRoom meetingRoom = meetingRoomRepository.getReferenceById(id);

		model.addAttribute("meetingRoom", meetingRoom);

		// 詳細ページで予約フォームを表示するために空のフォームクラスを渡す
		model.addAttribute("reservationInputForm", new ReservationInputForm());

		return "meeting_rooms/show";

	}

}