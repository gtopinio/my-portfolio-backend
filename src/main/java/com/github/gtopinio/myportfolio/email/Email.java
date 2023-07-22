package com.github.gtopinio.myportfolio.email;

import java.time.LocalDate;

public class Email {
    private Long id;
    private String senderEmail;
    private String senderName;
    private String message;
    private LocalDate date;

    public Email() {
    }

    public Email(Long id, String senderEmail, String senderName, String message, LocalDate date) {
        this.id = id;
        this.senderEmail = senderEmail;
        this.senderName = senderName;
        this.message = message;
        this.date = date;
    }

    public Email(String senderEmail, String senderName, String message, LocalDate date) {
        this.senderEmail = senderEmail;
        this.senderName = senderName;
        this.message = message;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", senderEmail='" + senderEmail + '\'' +
                ", senderName='" + senderName + '\'' +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}