package com.perfumeReco.vo;

import java.util.Arrays;

public class Quiz {

    private int no;
    private byte[] imageA;
    private byte[] imageB;
    private String imageAUrl;
    private String imageBUrl;
    private String correctAnswer;
    private String hint;
    private String explanation;

    public int getNo() {
        return no;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getImageAUrl() {
        return imageAUrl;
    }

    public void setImageAUrl(String imageAUrl) {
        this.imageAUrl = imageAUrl;
    }

    public String getImageBUrl() {
        return imageBUrl;
    }

    public void setImageBUrl(String imageBUrl) {
        this.imageBUrl = imageBUrl;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "no=" + no +
                ", imageA=" + Arrays.toString(imageA) +
                ", imageB=" + Arrays.toString(imageB) +
                ", imageAUrl='" + imageAUrl + '\'' +
                ", imageBUrl='" + imageBUrl + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", hint='" + hint + '\'' +
                ", explanation='" + explanation + '\'' +
                '}';
    }

    public byte[] getImageA() {
        return imageA;
    }

    public void setImageA(byte[] imageA) {
        this.imageA = imageA;
    }

    public byte[] getImageB() {
        return imageB;
    }

    public void setImageB(byte[] imageB) {
        this.imageB = imageB;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

}
