package com.perfumeReco.controller;

import com.perfumeReco.form.MemberRegisterForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.Member;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(){
        return "home";
    }

    @GetMapping("/loginform")
    public String loginform(){
        return "member/loginform";
    }

    @GetMapping("/findid")
    public String findid(){
        return "member/findid";
    }

    @PostMapping("/findid")
    public String findId(MemberRegisterForm form){
        return "home";

    }

    @GetMapping("/findpassword")
    public String findpassword(){
        return "member/findpassword";
    }
}
