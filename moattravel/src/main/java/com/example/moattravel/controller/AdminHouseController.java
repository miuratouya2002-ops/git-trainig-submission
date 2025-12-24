package com.example.moattravel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.moattravel.entity.House;
import com.example.moattravel.form.HouseRegisterForm;
import com.example.moattravel.repository.HouseRepository;

@Controller

@RequestMapping("/admin/houses")

public class AdminHouseController {

	private final HouseRepository houseRepository;

	public AdminHouseController(HouseRepository houseRepository) {

		this.houseRepository = houseRepository;

	}

	@GetMapping("/{id}")

	public String show(@PathVariable(name = "id") Integer id, Model model) {

		House house = houseRepository.getReferenceById(id);

		model.addAttribute("house", house);

		return "admin/houses/show";

	}

	@GetMapping("/register")

	public String register(Model model) {

		model.addAttribute("houseRegisterForm", new HouseRegisterForm());

		return "admin/houses/register";

	}

}
