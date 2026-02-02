package com.example.moattravel4.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.moattravel4.entity.MeetingRoom;
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
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable,
			Model model) {
		Page<MeetingRoom> meetingRoomPage;

		if (keyword != null && !keyword.isEmpty()) {
			meetingRoomPage = meetingRoomRepository.findByNameLikeOrAddressLike("%" + keyword + "%",
					"%" + keyword + "%", pageable);
		} else if (area != null && !area.isEmpty()) {
			meetingRoomPage = meetingRoomRepository.findByAddressLike("%" + area + "%", pageable);
		} else if (price != null) {
			meetingRoomPage = meetingRoomRepository.findByPriceLessThanEqual(price, pageable);
		} else {
			meetingRoomPage = meetingRoomRepository.findAll(pageable);
		}

		model.addAttribute("meetingRoomPage", meetingRoomPage);
		model.addAttribute("keyword", keyword);
		model.addAttribute("area", area);
		model.addAttribute("price", price);

		return "meeting_rooms/index";
	}
}