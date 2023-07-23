package com.github.gtopinio.myportfolio.email;

//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class EmailConfig {

//    @Bean
//    CommandLineRunner commandLineRunner(EmailRepository emailRepository) {
//        return args -> {
//            Email email1 = new Email(
//                    "example1@mail.com",
//                    "John Doe",
//                    "Hi! I'm John Doe",
//                    LocalDate.of(2023, Month.JANUARY, 1)
//            );
//
//            Email email2 = new Email(
//                    "example2@mail.com",
//                    "Jane Harlow",
//                    "Hello! I'm Jane Harlow",
//                    LocalDate.of(2023, Month.FEBRUARY, 2)
//            );
//
//            emailRepository.saveAll(
//                    List.of(email1, email2));
//        };
//    }
}
