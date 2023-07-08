package com.perfumeReco.dao;

import com.perfumeReco.vo.Quiz;
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
}
