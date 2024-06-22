// package com.example.spring_project.controller;

// import java.util.Optional;

// import org.springframework.security.core.annotation.AuthenticationPrincipal;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;

// import com.example.spring_project.constant.UrlConst;
// import com.example.spring_project.entity.UserInfo;
// import com.example.spring_project.form.SignupForm;
// import com.example.spring_project.service.UserUpdateService;


// import org.springframework.ui.Model;
// import org.springframework.validation.BindingResult;
// import org.springframework.validation.annotation.Validated;

// import lombok.RequiredArgsConstructor;

// @Controller
// @RequiredArgsConstructor
// public class UserUpdateController {


//     private final UserUpdateService service;


//     @GetMapping(UrlConst.UPDATE)
// 	public String view(Model model, SignupForm form) {
// 		return "userUpdate";
// 	}


//     @RequestMapping(UrlConst.UPDATE)
//     public String view(@AuthenticationPrincipal User user, Model model, @Validated SignupForm form, BindingResult bdResult){
//         if (bdResult.hasErrors()) {
// 			model.addAttribute("error", "文字数制限です");
// 			return "userUpdate";
// 		}
//         Optional<UserInfo> userInfoOpt = service.editUserInfo(form);



//         // String userName = form.getUserName();
//         // String email = form.getEmail();
//         // String password = form.getPassword();

//         // model.addAttribute("userName", userName);
//         // model.addAttribute("email", email);
//         // model.addAttribute("email", password);


//         return "main";

//     }


    
// }
