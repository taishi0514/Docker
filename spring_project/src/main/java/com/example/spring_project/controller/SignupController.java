package com.example.spring_project.controller;

import java.util.Optional;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.spring_project.constant.UrlConst;
import com.example.spring_project.entity.UserInfo;
import com.example.spring_project.form.SignupForm;
import com.example.spring_project.service.SignupService;
import com.example.spring_project.util.AppUtil;
import com.example.spring_project.constant.MessageConst;
import com.example.spring_project.constant.SignupMessage;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SignupController {

	private final SignupService service;

	private final MessageSource messageSource;


	@GetMapping(UrlConst.SIGNUP)
	public String view(Model model, SignupForm form) {
		return "signup";
	}
	

	@PostMapping("/signup")
	public String signup(Model model, @Validated SignupForm form, BindingResult bdResult) {
		if (bdResult.hasErrors()) {
			editGuideMessage(model, MessageConst.FORM_ERROR, true);
		}else{
			var userInfoOpt = service.resistUserInfo(form);
			var signupMessage = judgeMessageKey(userInfoOpt);
			editGuideMessage(model, signupMessage.getMessageId(), signupMessage.isError());
			return UrlConst.LOGIN;
		}
			return null;
		
	}

	/**
	 * 画面に表示するガイドメッセージを設定する
	 * 
	 * @param model モデル
	 * @param messageId メッセージID
	 * @param isError エラー有無
	 */
	private void editGuideMessage(Model model, String messageId, boolean isError) {
		var message = AppUtil.getMessage(messageSource, messageId);
		model.addAttribute("message", message);
		model.addAttribute("isError", isError);
	}
		

	/**
	 * ユーザ情報登録の結果メッセージキーを判断する
	 * 
	 * @param userInfoOpt ユーザ登録結果(登録済みだった場合はEmpty)
	 * @return メッセージキー
	 */
	private SignupMessage judgeMessageKey(Optional<UserInfo> userInfoOpt) {
		if (userInfoOpt.isEmpty()) {
			return SignupMessage.EXISTED_EMAIL;
		} else {
			return SignupMessage.SUCCEED;
		}
	}

}