package com.github.gtopinio.myportfolio.email;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository <Email, Long> {
    // Responsible for database access
}
