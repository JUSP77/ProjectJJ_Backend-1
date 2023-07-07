package com.perfumeReco.dto;

import java.util.List;

public class ResponseDto<T> {

    private String status;
    private String error;
    private List<?> item;

    public ResponseDto() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<?> getItem() {
        return item;
    }

    public void setItem(List<?> item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "status='" + status + '\'' +
                ", error='" + error + '\'' +
                ", item=" + item +
                '}';
    }
}
