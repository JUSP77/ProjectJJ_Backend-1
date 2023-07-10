package com.perfumeReco.restConrtoller;

import com.perfumeReco.dto.ResponseDto;
import com.perfumeReco.service.QuizService;
import com.perfumeReco.service.UserAnswerService;
import com.perfumeReco.utils.SessionUtils;
import com.perfumeReco.vo.Quiz;
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

    @PostMapping("userAnswer")
    public ResponseDto<String> userAnswer(
            @RequestParam String answer,
            @RequestParam int no,
            HttpServletRequest request
    ) {
        ResponseDto<String> response = new ResponseDto<>();
        QuizStatistics quizStatistics = new QuizStatistics();
        Date currentTime = new Date();
        UserAnswer userAnswer = new UserAnswer();

        HttpSession session = request.getSession(true);
        String sessionId = session.getId();

        //세션에서 UserAnswerList를 가져오기
        List<UserAnswer> userAnswerList = (List<UserAnswer>) SessionUtils.getAttribute(sessionId);

        //UserAnswerList가 없을 경우 새로 생성
        if(userAnswerList == null ){
            userAnswerList = new ArrayList<>();
            SessionUtils.addAttribute(sessionId, userAnswerList);
        }
        userAnswer.setQuizNo(no);
        userAnswer.setUserAnswer(answer);
        userAnswer.setSubmissionTime(currentTime);
        userAnswerList.add(userAnswer);

        // 수정 요망
        if (userAnswerList.size() == 5) {
            try {
                for (UserAnswer userAnswer1 : userAnswerList) {
                    userAnswerService.insertUserAnswer(userAnswer1);
                    quizService.updateQuizStatistics(userAnswer1.getQuizNo(), answer);
                }
                response.setStatus("OK");
            } catch (IOException e) {
                response.setStatus("ERROR");
                e.printStackTrace();
            } finally {
                SessionUtils.removeAttribute(sessionId);
            }
        } else {
            response.setStatus("Incomplete");
        }
        return response;
    }

    @GetMapping("/result")
    public ResponseDto<Result> getResult(HttpServletRequest request) {
        ResponseDto<Result> response = new ResponseDto<>();

        // 세션을 가져옴
        HttpSession session = request.getSession();

        // 문제를 푼 사용자의 세션 아이디와 현재 세션 아이디를 비교하여 검증
        if (!session.getId().equals(session.getAttribute("userId"))) {
            response.setStatus("Unauthorized");
            return response;
        }

        // 문제를 푼 사용자의 세션에서 결과를 가져옴
        String userAnswer = (String) session.getAttribute("userAnswer");

        // 결과 생성
        Result result = new Result();
        result.setUserAnswer(userAnswer);

        // 결과 반환
        response.setItem(result);
        response.setStatus("OK");
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