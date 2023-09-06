package com.github.gtopinio.myportfolio.click;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClickRepository extends JpaRepository<Click, Long> {
    // Responsible for database access
}
