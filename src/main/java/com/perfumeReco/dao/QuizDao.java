package com.perfumeReco.dao;

import com.perfumeReco.vo.Quiz;
import com.perfumeReco.vo.QuizResultImg;
import com.perfumeReco.vo.QuizStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuizDao {

// Image A 인지 B인지 확인
    void insertQuiz(Quiz quiz);
    List<Quiz> getAllQuiz();
    void updateQuizStatistics(QuizStatistics quizStatistics);
    QuizStatistics getQuizStatistics(int quizNo);
    QuizResultImg getResultImg(int countCorrectAnswer);
}
//        Integer countCorrectAnswer = userAnswerService.countCorrectAnswerByUserId("session-1689069912165");
//        if(countCorrectAnswer != null){
//            System.out.println(countCorrectAnswer);
//        } else{
//            countCorrectAnswer = 0;
//        }
//        System.out.println(countCorrectAnswer);