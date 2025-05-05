package com.pluralsight.spring_demo.controllers;

import com.pluralsight.spring_demo.models.Session;
import com.pluralsight.spring_demo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {

    @Autowired
    private SessionRepository sessionRepository;

    @PostMapping(consumes="application/json")
    //@ResponseStatus(HttpStatus.CREATED)
    public Session create(@RequestBody final Session session){
        return sessionRepository.saveAndFlush(session);
    }

    @PutMapping(path="/{id}")
    public Session update (@PathVariable Long id, @RequestBody Session session){
        Session existingSession = sessionRepository.getReferenceById(id);
        /*if(session.isParameterEmpty())
            return existingSession;existingSession*/
        BeanUtils.copyProperties(session,existingSession,"sessionId");
        return sessionRepository.saveAndFlush(existingSession);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable final Long id){
        sessionRepository.deleteById(id);
    }

    @GetMapping(produces = "application/json")
    public List<Session> list() {
        return sessionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Session get(@PathVariable final Long id) {
        return sessionRepository.getReferenceById(id);
    }



}
