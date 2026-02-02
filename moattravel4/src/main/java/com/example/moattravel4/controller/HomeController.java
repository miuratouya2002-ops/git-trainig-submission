package com.example.moattravel4.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.moattravel4.entity.MeetingRoom;
import com.example.moattravel4.repository.MeetingRoomRepository;

@Controller
public class HomeController {
	private final MeetingRoomRepository meetingRoomRepository;

	public HomeController(MeetingRoomRepository meetingRoomRepository) {
		this.meetingRoomRepository = meetingRoomRepository;
	}

	@GetMapping("/")
	public String index(Model model) {
		// 新着10件を取得
		List<MeetingRoom> newMeetingRooms = meetingRoomRepository.findTop10ByOrderByCreatedAtDesc();
		model.addAttribute("newMeetingRooms", newMeetingRooms);

		return "index";
	}
}