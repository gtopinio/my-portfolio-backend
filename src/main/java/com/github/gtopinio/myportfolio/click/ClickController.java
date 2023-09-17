package com.github.gtopinio.myportfolio.click;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.concurrent.CompletableFuture;

@Controller
@CrossOrigin
public class ClickController {
    // Responsible for handling requests and returning responses

    private final ClickService clickService;

    @Autowired
    public ClickController(ClickService clickService) {
        this.clickService = clickService;
    }

    @QueryMapping
    Iterable<Click> clicks() {
        return this.clickService.getClicks();
    }

    @MutationMapping
    CompletableFuture<Click> saveClick(@Argument ClickInput click) {
        return this.clickService.saveClick(click.linkName, click.ipAddress);
    }

    record ClickInput(String linkName, String ipAddress) {
    }
}
