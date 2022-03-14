package com.test.corp.voting.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/agenda")
public class AgendaController {

    @GetMapping
    public ResponseEntity<String> getAll() {
        return new ResponseEntity<>("Hi, we had a agenda.", HttpStatus.OK);
    }
}
