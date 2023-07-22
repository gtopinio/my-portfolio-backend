package com.github.gtopinio.myportfolio.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmailService {
    // Responsible for business logic

    private final EmailRepository emailRepository;

    @Autowired
    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public List<Email> getEmails() {
        return emailRepository.findAll();
    }

    public Optional<Email> getEmailById(Long id) {
        return emailRepository.findById(id);
    }

    public Email saveEmail(String senderEmail, String senderName, String message) {
        Email email = new Email();
        email.setSenderEmail(senderEmail);
        email.setSenderName(senderName);
        email.setMessage(message);
        email.setDate(LocalDate.now());
        return emailRepository.save(email);
    }
}
