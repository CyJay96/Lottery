package com.bukable.lottery.controller;

import com.bukable.lottery.domain.Participant;
import com.bukable.lottery.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "lottery/participant", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ParticipantController {

    private final ParticipantService participantService;

    @GetMapping
    public ResponseEntity<List<Participant>> findParticipants() {
        return ResponseEntity.ok(participantService.findAll());
    }

    @PostMapping
    public ResponseEntity<List<Participant>> saveParticipant(@RequestBody Participant participant) {
        participantService.saveParticipant(participant);
        return findParticipants();
    }

}
