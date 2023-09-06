package com.github.gtopinio.myportfolio.click;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

@Service
public class ClickService {
    // Responsible for business logic

    private final ClickRepository clickRepository;

    @Autowired
    public ClickService(ClickRepository clickRepository) {
        this.clickRepository = clickRepository;
    }

    public Iterable<Click> getClicks() {
        return this.clickRepository.findAll();
    }

    @Async
    public CompletableFuture<Click> saveClick(String linkName) {
        // Validate input parameters
        if (linkName == null || linkName.isEmpty()) {
            throw new IllegalArgumentException("Link name must not be null or empty");
        }

        // Get current date
        LocalDate date = LocalDate.now();

        // Save click
        Click click = new Click(linkName, date);
        clickRepository.save(click);

        // Return click
        return CompletableFuture.completedFuture(click);
    }

}
