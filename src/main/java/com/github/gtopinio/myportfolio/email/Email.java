package com.github.gtopinio.myportfolio.email;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Email {
    @Id
    @SequenceGenerator(
            name = "email_sequence",
            sequenceName = "email_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "email_sequence"
    )

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