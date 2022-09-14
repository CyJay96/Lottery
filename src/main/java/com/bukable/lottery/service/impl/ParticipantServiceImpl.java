package com.bukable.lottery.service.impl;

import com.bukable.lottery.domain.Participant;
import com.bukable.lottery.repository.ParticipantRepo;
import com.bukable.lottery.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepo participantRepo;

    @Override
    public List<Participant> findAll() {
        return participantRepo.findAll();
    }

    @Override
    public void saveParticipant(Participant participant) {
        Participant participantFromDb = participantRepo.findByName(participant.getName());

        if (participantFromDb == null) {
            participantRepo.save(participant);
        }
    }

}
