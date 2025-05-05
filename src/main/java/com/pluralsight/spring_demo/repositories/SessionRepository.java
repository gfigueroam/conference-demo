package com.pluralsight.spring_demo.repositories;

import com.pluralsight.spring_demo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session,Long> {

}
