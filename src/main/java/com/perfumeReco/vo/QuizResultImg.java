package com.perfumeReco.vo;

public class QuizResultImg {

    private String no;
    private String url;
    private Integer correctCount;

    public QuizResultImg(){}

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCorrectCount() {
        return correctCount;
    }

    public void setCorrectCount(Integer correctCount) {
        this.correctCount = correctCount;
    }

    @Override
    public String toString() {
        return "QuizResultImg{" +
                "no='" + no + '\'' +
                ", url='" + url + '\'' +
                ", correctCount=" + correctCount +
                '}';
    }
}
