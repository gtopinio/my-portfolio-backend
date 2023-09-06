package com.github.gtopinio.myportfolio.click;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table
public class Click {
    @Id
    @SequenceGenerator(
            name = "click_sequence",
            sequenceName = "click_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "click_sequence"
    )
    private Long id;
    private String link;
    private LocalDate date;

    public Click() {
    }

    public Click(Long id, String link, LocalDate date) {
        this.id = id;
        this.link = link;
        this.date = date;
    }

    public Click(String link, LocalDate date) {
        this.link = link;
        this.date = date;
    }

    public String getLink() {
        return link;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Click{" +
                "id=" + id +
                ", link='" + link + '\'' +
                ", date=" + date +
                '}';
    }
}
