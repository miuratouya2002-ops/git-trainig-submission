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
@RequestMapping("/admin/meeting_rooms")

public class AdminMeetingRoomController {

	private final MeetingRoomRepository meetingRoomRepository;

	public AdminMeetingRoomController(MeetingRoomRepository meetingRoomRepository) {

		this.meetingRoomRepository = meetingRoomRepository;

	}

	@GetMapping

	public String index(Model model,
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable,
			@RequestParam(name = "keyword", required = false) String keyword) {

		Page<MeetingRoom> meetingRoomsPage = meetingRoomRepository.findAll(pageable);

		if (keyword != null && !keyword.isEmpty()) {

			meetingRoomsPage = meetingRoomRepository.findByNameLike("%" + keyword + "%", pageable);

		} else {

			meetingRoomsPage = meetingRoomRepository.findAll(pageable);

		}

		model.addAttribute("meetingRoomsPage", meetingRoomsPage);

		model.addAttribute("keyword", keyword);

		return "admin/meeting_rooms/index";

	}

}
