package com.github.gtopinio.myportfolio.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
@Service
public class EmailService {
    // Responsible for business logic

    private final EmailRepository emailRepository;

    @Autowired private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}") private String myEmail;

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

    @Async
    public CompletableFuture<Email> saveEmail(String senderEmail, String senderName, String message) {
        // Validate input parameters
        if (senderEmail == null || senderEmail.isEmpty()) {
            throw new IllegalArgumentException("Sender email must not be null or empty");
        }
        if (senderName == null || senderName.isEmpty()) {
            throw new IllegalArgumentException("Sender name must not be null or empty");
        }
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message must not be null or empty");
        }

        Email email = new Email();
        LocalDate date = LocalDate.now();
        email.setSenderEmail(senderEmail);
        email.setSenderName(senderName);
        email.setMessage(message);
        email.setDate(date);

        try {
            SimpleMailMessage msg = new SimpleMailMessage();

            // Set up the email message
            msg.setFrom(this.myEmail);
            msg.setTo(this.myEmail);
            msg.setText(message);
            msg.setSubject("From Portfolio Website: Message from " + senderName + " (" + senderEmail + ")");

            // Send the email
            javaMailSender.send(msg);
        } catch (Exception e) {
            // Rethrow the exception to indicate that the operation failed
            throw new RuntimeException("Failed to send email", e);
        }

        return CompletableFuture.completedFuture(emailRepository.save(email));
    }

}
