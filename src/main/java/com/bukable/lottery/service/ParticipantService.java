package com.bukable.lottery.service;

import com.bukable.lottery.domain.Participant;

import java.util.List;

public interface ParticipantService {

    List<Participant> findAll();

    void saveParticipant(Participant participant);

}
