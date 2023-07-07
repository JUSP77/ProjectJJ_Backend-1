package com.perfumeReco.restConrtoller;


import com.perfumeReco.dto.ResponseDto;
import com.perfumeReco.form.MemberRegisterForm;
import com.perfumeReco.service.GameService;
import com.perfumeReco.vo.Member;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/member")
public class MemberRestController {


    @PostMapping("/register")
    public ResponseDto<String> register(@RequestBody MemberRegisterForm form){
        ResponseDto<String> res = new ResponseDto<>();
        Member member = new Member();
        BeanUtils.copyProperties(form, member);

        member.setPassword(member.getPassword());
        System.out.println("비밀번호 : "+ member.getPassword());


        return res;

    }
}
