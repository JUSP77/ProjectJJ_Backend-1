package com.perfumeReco.dao;

import com.perfumeReco.vo.UserAnswer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAnswerDao {
    void insertUserAnswer(UserAnswer userAnswer);

}
