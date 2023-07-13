package com.perfumeReco.restConrtoller;

import com.perfumeReco.dto.ResponseDto;
import com.perfumeReco.service.QuizService;
import com.perfumeReco.service.UserAnswerService;
import com.perfumeReco.utils.SessionUtils;
import com.perfumeReco.vo.Quiz;
import com.perfumeReco.vo.QuizResultImg;
import com.perfumeReco.vo.QuizStatistics;
import com.perfumeReco.vo.UserAnswer;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rest")
public class QuizRestController {

    @Autowired
    private QuizService quizService;
    @Autowired
    private UserAnswerService userAnswerService;
    private UserAnswer userAnswer = new UserAnswer();

    @GetMapping("getQuiz")
    public ResponseDto<Quiz> getQuiz() {
        ResponseDto<Quiz> response = new ResponseDto<>();
        List<Quiz> quizList = quizService.getAllQuiz();

        for (Quiz quiz : quizList) {
            byte[] imageABytes = quiz.getImageA();
            byte[] imageBBytes = quiz.getImageB();
            Blob imageABlob = convertBytesToBlob(imageABytes);
            Blob imageBBlob = convertBytesToBlob(imageBBytes);
            String imageAUrl = convertBlobToUrl(imageABlob);
            String imageBUrl = convertBlobToUrl(imageBBlob);
            quiz.setImageAUrl(imageAUrl);
            quiz.setImageBUrl(imageBUrl);
        }

        response.setItem(quizList);

        return response;
    }

    // byte[] 배열을 Blob 객체로 변환하는 메서드
    private Blob convertBytesToBlob(byte[] bytes) {
        Blob blob = null;
        try {
            blob = new SerialBlob(bytes);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blob;
    }

    // Blob 데이터를 BLOB URL로 변환하는 메서드
    private String convertBlobToUrl(Blob blob) {
        try {
            InputStream inputStream = blob.getBinaryStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            StreamUtils.copy(inputStream, outputStream);
            byte[] bytes = outputStream.toByteArray();

            // BLOB 데이터를 Base64로 인코딩
            String base64Data = Base64.getEncoder().encodeToString(bytes);

            // BLOB URL 생성
            String url = "data:image/jpeg;base64," + base64Data;

            return url;
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<UserAnswer> userAnswerList = new ArrayList<>();

    @PostMapping("userAnswer")
    public ResponseDto<Integer> userAnswer(
            @RequestBody List<UserAnswer> answers
    ) {

        System.out.println(answers);
        ResponseDto<Integer> response = new ResponseDto<>();
        List<UserAnswer> answerList = new ArrayList<>();
        Integer countCorrectAnswer = 0;
        try {

            for (UserAnswer ans : answers) {
                System.out.println(ans.getQuizNo());
                ans.setSubmissionTime(new Date());
                userAnswerService.insertUserAnswer(ans);
                quizService.updateQuizStatistics(ans.getQuizNo(), ans.getUserAnswer());
                if(ans.getUserAnswer().equals(("O"))){
                    countCorrectAnswer ++;
                    System.out.println(countCorrectAnswer);
                }
            }
            response.setStatus("OK");
            response.setData(countCorrectAnswer);

        } catch (IOException e) {
            response.setStatus("ERROR");
            response.setError(e.getMessage());
        }
        return response;
    }

    @GetMapping("/getCount")
    public Map<String, Integer> getAttemptCount() {
        QuizStatistics quizStatistics = quizService.getQuizStatistics(1);
        int count = quizStatistics.getAttempCount();
        Map<String, Integer> response = new HashMap<>();
        response.put("count", count);
        return response;
    }

}

