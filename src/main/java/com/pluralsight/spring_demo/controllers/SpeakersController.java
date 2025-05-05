package com.pluralsight.spring_demo.controllers;

import com.pluralsight.spring_demo.models.Speaker;
import com.pluralsight.spring_demo.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {

    @Autowired
    private SpeakerRepository speakerRepository;

    @PostMapping
    private Speaker create(@RequestBody final Speaker session) {
        return speakerRepository.saveAndFlush(session);
    }
    @PutMapping("/{id}")
    private Speaker update(@PathVariable final Long id, @RequestBody Speaker speaker) {
        Speaker existingSpeaker = speakerRepository.getReferenceById(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return speakerRepository.saveAndFlush(existingSpeaker);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable Long id) {
        speakerRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    private Speaker get(@PathVariable final Long id) {
        return speakerRepository.getReferenceById(id);

    }

    @GetMapping
    private List<Speaker> getAll() {
        return speakerRepository.findAll();

    }
}
