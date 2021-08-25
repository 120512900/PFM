package com.example.pfm.req;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SpendReq {

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", date=").append(date);
        sb.append("]");
        return sb.toString();
    }
}