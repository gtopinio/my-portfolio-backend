package com.github.gtopinio.myportfolio.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class EmailController {
    // Responsible for handling requests and returning responses

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @QueryMapping
    Iterable<Email> emails() {
        return this.emailService.getEmails();
    }

    @QueryMapping
    Optional<Email> emailById(@Argument Long id) {
        return this.emailService.getEmailById(id);
    }

    @MutationMapping
    Email saveEmail(@Argument EmailInput email) {
        return this.emailService.saveEmail(email.senderEmail, email.senderName, email.message);
    }

    record EmailInput(String senderEmail, String senderName, String message) {
    }

}
