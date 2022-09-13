package com.bukable.lottery.controller;

import com.bukable.lottery.domain.Participant;
import com.bukable.lottery.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lottery")
@RequiredArgsConstructor
public class ParticipantController {

    private final ParticipantService participantService;

    @GetMapping("/participant")
    public List<Participant> findParticipants() {
        return participantService.findAll();
    }

    @PostMapping("/participant")
    public List<Participant> Participant(@RequestBody Participant participant) {
        participantService.saveParticipant(participant);
        return participantService.findAll();
    }

}
