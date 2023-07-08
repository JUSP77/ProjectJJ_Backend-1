package com.perfumeReco.vo;

public class QuizStatistics {

    private int quizNo;
    private int attempCount;
    private int correctCount;

    public QuizStatistics(){}

    public int getQuizNo() {
        return quizNo;
    }

    public void setQuizNo(int quizNo) {
        this.quizNo = quizNo;
    }

    public int getAttempCount() {
        return attempCount;
    }

    public void setAttempCount(int attempCount) {
        this.attempCount = attempCount;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public void setCorrectCount(int correctCount) {
        this.correctCount = correctCount;
    }

    @Override
    public String toString() {
        return "QuizStatistics{" +
                "quizNo=" + quizNo +
                ", attempCount=" + attempCount +
                ", correctCount=" + correctCount +
                '}';
    }
}
