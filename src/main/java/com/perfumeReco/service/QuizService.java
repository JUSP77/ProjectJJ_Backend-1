package com.perfumeReco.service;

import com.perfumeReco.dao.QuizDao;
import com.perfumeReco.dto.ResponseDto;
import com.perfumeReco.vo.Quiz;
import com.perfumeReco.vo.QuizResultImg;
import com.perfumeReco.vo.QuizStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;

    public ResponseDto<String> uploadQuiz(int no, String correctAnswer, MultipartFile imageA, MultipartFile imageB, String hint, String explanation) throws IOException {
        ResponseDto<String> response = new ResponseDto<>();

        try {
            // 이미지 파일을 byte 배열로 변환
            byte[] arrayImageA = imageA.getBytes();
            byte[] arrayImageB = imageB.getBytes();

            Quiz quiz = new Quiz();
            quiz.setNo(no);
            quiz.setImageA(arrayImageA);
            quiz.setImageB(arrayImageB);
            quiz.setCorrectAnswer(correctAnswer);
            quiz.setHint(hint);
            quiz.setExplanation(explanation);
            quizDao.insertQuiz(quiz);

            response.setStatus("OK");
        } catch (IOException e) {
            response.setStatus("ERROR");
            response.setError("Failed to upload Quiz: " + e.getMessage());
        }
        return response;
    }

    public List<Quiz> getAllQuiz() {

        return quizDao.getAllQuiz();
    }

    public QuizStatistics getQuizStatistics(int no){

        return quizDao.getQuizStatistics(no);
    }

    @Transactional
    public void updateQuizStatistics(int quizNo, String answer) throws IOException{
        QuizStatistics quizStatistics = new QuizStatistics();

        int attempCount = getQuizStatistics(quizNo).getAttempCount();
        int correctCount = getQuizStatistics(quizNo).getCorrectCount();
        if (answer.equals("O")) {
            attempCount ++;
            correctCount ++;
        }else{
            attempCount ++;
        }
        quizStatistics.setCorrectCount(correctCount);
        quizStatistics.setAttempCount(attempCount);
        quizStatistics.setQuizNo(quizNo);
        quizDao.updateQuizStatistics(quizStatistics);
    }

    public QuizResultImg getResultImg(int countCorrectAnswer){

        return quizDao.getResultImg(countCorrectAnswer);
    }
}