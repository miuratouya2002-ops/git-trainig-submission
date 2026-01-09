package com.example.moattravel2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController {

	@GetMapping("/")

	public String index() {

		//return "index";と記述すれば、src/main/resources/templatesフォルダ内にあるindex.htmlが呼び出される

		return "index";
	}

}
