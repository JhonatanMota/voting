package com.test.corp.voting.controller;

import com.test.corp.voting.model.Session;
import com.test.corp.voting.payload.OpenSessionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/session")
public class SessionController {

    @PostMapping(path="/open")
    public ResponseEntity<Session> openSession(@RequestBody OpenSessionDto openSession){
        return null;
    }
}
