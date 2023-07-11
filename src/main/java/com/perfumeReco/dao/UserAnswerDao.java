package com.perfumeReco.dao;

import com.perfumeReco.vo.UserAnswer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserAnswerDao {
    void insertUserAnswer(UserAnswer userAnswer);
    List<UserAnswer> countUserCorrectAnswer(String userId);
}
