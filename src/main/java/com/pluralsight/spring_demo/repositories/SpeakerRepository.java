package com.pluralsight.spring_demo.repositories;

import com.pluralsight.spring_demo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
