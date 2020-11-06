package com.kgc.entity;

public class Condition {
    private String searchName;
    private int startPay;
    private int endPay;
    private int searcherId;

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public int getStartPay() {
        return startPay;
    }

    public void setStartPay(int startPay) {
        this.startPay = startPay;
    }

    public int getEndPay() {
        return endPay;
    }

    public void setEndPay(int endPay) {
        this.endPay = endPay;
    }

    public int getSearcherId() {
        return searcherId;
    }

    public void setSearcherId(int searcherId) {
        this.searcherId = searcherId;
    }
}
