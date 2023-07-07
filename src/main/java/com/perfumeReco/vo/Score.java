package com.perfumeReco.vo;

public class Score {

    private Integer no;
    private String result;

    public Score(){}

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Score{" +
                "no=" + no +
                ", result='" + result + '\'' +
                '}';
    }
}
