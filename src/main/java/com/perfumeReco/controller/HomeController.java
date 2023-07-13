package com.perfumeReco.controller;

import com.perfumeReco.form.MemberRegisterForm;
import com.perfumeReco.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@CrossOrigin(origins = "*")
@Controller
public class HomeController {

    @Autowired
    QuizService quizService;

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/loginform")
    public String loginform() {
        return "member/loginform";
    }

    @GetMapping("/findid")
    public String findid() {
        return "member/findid";
    }

    @PostMapping("/findid")
    public String findId(MemberRegisterForm form) {
        return "home";

    }

    @GetMapping("/findpassword")
    public String findpassword() {
        return "member/findpassword";
    }
}
