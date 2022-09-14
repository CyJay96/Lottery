package com.bukable.lottery.controller;

import com.bukable.lottery.domain.Participant;
import com.bukable.lottery.domain.Winner;
import com.bukable.lottery.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lottery")
@RequiredArgsConstructor
public class ParticipantController {

    private final ParticipantService participantService;

    @GetMapping("/participant")
    public ResponseEntity<List<Participant>> findParticipants() {
        return ResponseEntity.ok(participantService.findAll());
    }

    @PostMapping("/participant")
    public ResponseEntity<List<Participant>> saveParticipant(@RequestBody Participant participant) {
        participantService.saveParticipant(participant);
        return findParticipants();
    }

    @GetMapping("/start")
    public ResponseEntity<Winner> start() {
        Winner winner = participantService.startLottery();
        return ResponseEntity.ok(winner);
    }

}
