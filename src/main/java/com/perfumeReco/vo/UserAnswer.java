package com.perfumeReco.vo;

import java.util.Date;

public class UserAnswer {

    private String userId;
    private int userAnswerId;
    private int quizNo;
    private String userAnswer;
    private Date submissionTime;

    public UserAnswer(){}

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getUserAnswerId() {
        return userAnswerId;
    }

    public void setUserAnswerId(int userAnswerId) {
        this.userAnswerId = userAnswerId;
    }

    public int getQuizNo() {
        return quizNo;
    }

    public void setQuizNo(int quizNo) {
        this.quizNo = quizNo;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public Date getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(Date submissionTime) {
        this.submissionTime = submissionTime;
    }

    @Override
    public String toString() {
        return "UserAnswer{" +
                "userId='" + userId + '\'' +
                ", userAnswerId=" + userAnswerId +
                ", quizNo=" + quizNo +
                ", userAnswer='" + userAnswer + '\'' +
                ", submissionTime=" + submissionTime +
                '}';
    }
}
