package com.example.moattravel4.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.moattravel4.entity.User;
import com.example.moattravel4.form.UserEditForm;
import com.example.moattravel4.repository.UserRepository;
import com.example.moattravel4.security.UserDetailsImpl;
import com.example.moattravel4.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private final UserRepository userRepository;
	private final UserService userService;

	public UserController(UserRepository userRepository, UserService userService) {
		this.userRepository = userRepository;
		this.userService = userService;
	}

	// 会員詳細ページ（マイページ）
	@GetMapping
	public String index(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, Model model) {
		User user = userRepository.getReferenceById(userDetailsImpl.getUser().getId());
		model.addAttribute("user", user);

		return "user/index";
	}

	// 会員編集ページ
	@GetMapping("/edit")
	public String edit(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, Model model) {
		User user = userRepository.getReferenceById(userDetailsImpl.getUser().getId());

		// フォームに現在の情報を詰める
		UserEditForm userEditForm = new UserEditForm(
				user.getId(),
				user.getName(),
				user.getFurigana(),
				user.getPostalCode(),
				user.getAddress(),
				user.getPhoneNumber(),
				user.getEmail());

		model.addAttribute("userEditForm", userEditForm);

		return "user/edit";
	}

	// 更新処理
	@PostMapping("/update")
	public String update(@ModelAttribute @Validated UserEditForm userEditForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		// メールアドレスが変更されており、かつ既に登録済みであればエラー
		if (userService.isEmailRegistered(userEditForm.getEmail())) {
			// 自分のメールアドレスと同じならOK（変更なし）、他人のと被ったらNG
			User currentUser = userRepository.getReferenceById(userEditForm.getId());
			if (!currentUser.getEmail().equals(userEditForm.getEmail())) {
				FieldError fieldError = new FieldError(bindingResult.getObjectName(), "email", "すでに登録済みのメールアドレスです。");
				bindingResult.addError(fieldError);
			}
		}

		if (bindingResult.hasErrors()) {
			return "user/edit";
		}

		userService.update(userEditForm);
		redirectAttributes.addFlashAttribute("successMessage", "会員情報を編集しました。");

		return "redirect:/user";
	}
}