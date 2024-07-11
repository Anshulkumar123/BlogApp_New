package com.NestBlog.Payload;

import java.util.Date;

public class ErrorDetail {
    private Date date;
    private String message;
    private String details;

    public ErrorDetail(Date date, String message, String details) {
        this.date = date;
        this.message = message;
        this.details = details;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
