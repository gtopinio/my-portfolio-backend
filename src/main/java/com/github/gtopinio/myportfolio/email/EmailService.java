package com.github.gtopinio.myportfolio.email;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class EmailService {

    public List<Email> getEmails() {
        return List.of(
                new Email(
                        1L,
                        "example1@mail.com",
                        "John Doe",
                        "Hello! I'm John Doe!",
                        LocalDate.of(2000, Month.JANUARY, 1)),
                new Email(
                        2L,
                        "example2@mail.com",
                        "Jane Doe",
                        "Hello! I'm Jane Doe!",
                        LocalDate.of(2001, Month.FEBRUARY, 2)),
                new Email(
                        3L,
                        "example3@mail.com",
                        "Bobby Sanders",
                        "Hello! I'm Bobby Sanders!",
                        LocalDate.of(2002, Month.MARCH, 3))
        );
    }
}
