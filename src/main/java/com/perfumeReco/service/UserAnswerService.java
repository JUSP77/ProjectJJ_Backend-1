package com.perfumeReco.service;

import com.perfumeReco.dao.UserAnswerDao;
import com.perfumeReco.dto.ResponseDto;
import com.perfumeReco.vo.UserAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
public class UserAnswerService {

    @Autowired
    UserAnswerDao userAnswerDao;

    @Transactional
    public void insertUserAnswer(UserAnswer userAnswer) throws IOException {
        ResponseDto<String> response = new ResponseDto<>();
        userAnswerDao.insertUserAnswer(userAnswer);
    }

    public List<UserAnswer> countUserCorrectAnswer(String userId){
        return userAnswerDao.countUserCorrectAnswer(userId);
    }

}
