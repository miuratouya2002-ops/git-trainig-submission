package com.example.moattravel4.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

	public String index(Model model) {

		List<MeetingRoom> meetingRooms = meetingRoomRepository.findAll();

		model.addAttribute("meetingRooms", meetingRooms);

		return "admin/meeting_rooms/index";

	}

}
