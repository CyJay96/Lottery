package com.bukable.lottery.service.impl;

import com.bukable.lottery.config.RandomWebClient;
import com.bukable.lottery.domain.Participant;
import com.bukable.lottery.domain.Winner;
import com.bukable.lottery.repository.ParticipantRepo;
import com.bukable.lottery.service.ParticipantService;
import com.bukable.lottery.service.WinnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepo participantRepo;
    private final WinnerService winnerService;
    private final RandomWebClient randomWebClient;

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

    @Override
    public Winner startLottery() {
        List<Participant> participants = participantRepo.findAll();

        if (participants.size() < 2) {
            //todo
            System.out.println("error");
        }

        String randomStr;
        int winningAmount = 0;
        int winnerId = 0;

        randomStr = randomWebClient.getRandomNumber(1, 1000).block();
        if (randomStr != null) {
            winningAmount = Integer.parseInt(randomStr.replace("\n", ""));
        }

        randomStr = randomWebClient.getRandomNumber(0, participants.size() - 1).block();
        if (randomStr != null) {
            winnerId = Integer.parseInt(randomStr.replace("\n", ""));
        }


        Winner winner = Winner.builder()
                .name(participants.get(winnerId).getName())
                .age(participants.get(winnerId).getAge())
                .city(participants.get(winnerId).getCity())
                .winningAmount(winningAmount)
                .build();

        winnerService.saveWinner(winner);

        return winner;
    }

}
