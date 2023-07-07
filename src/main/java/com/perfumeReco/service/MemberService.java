package com.perfumeReco.service;

import com.perfumeReco.dao.MemberDao;
import com.perfumeReco.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    public Member registerMember(Member member){


        return member;
    }
}
