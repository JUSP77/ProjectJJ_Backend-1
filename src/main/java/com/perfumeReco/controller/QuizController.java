package com.perfumeReco.controller;

import com.perfumeReco.dto.ResponseDto;
import com.perfumeReco.service.QuizService;
import com.perfumeReco.vo.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@CrossOrigin(origins = "*")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/upload")
    public String uploadQuiz(
            @RequestParam int no,
            @RequestParam String correctAnswer,
            @RequestParam("imageA") MultipartFile imageA,
            @RequestParam("imageB") MultipartFile imageB,
            @RequestParam String hint,
            @RequestParam String explanation,
            RedirectAttributes redirectAttributes
    ) {
        try {
            // 퀴즈 저장
            quizService.uploadQuiz(no, correctAnswer, imageA, imageB, hint, explanation);
            redirectAttributes.addFlashAttribute("status", "OK");
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("status", "ERROR");
            redirectAttributes.addFlashAttribute("error", "퀴즈 업로드에 실패했습니다: " + e.getMessage());
        }

        return "/";
    }

}