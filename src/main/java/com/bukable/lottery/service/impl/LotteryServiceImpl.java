package com.bukable.lottery.service.impl;

import com.bukable.lottery.config.RandomWebClient;
import com.bukable.lottery.domain.Participant;
import com.bukable.lottery.domain.Winner;
import com.bukable.lottery.repository.ParticipantRepo;
import com.bukable.lottery.service.LotteryService;
import com.bukable.lottery.service.WinnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LotteryServiceImpl implements LotteryService {

    private static final int MIN_NUMBER_OF_PARTICIPANTS = 2;
    private static final int MIN_WINNING_AMOUNT = 1;
    private static final int MAX_WINNING_AMOUNT = 1000;

    private final ParticipantRepo participantRepo;
    private final WinnerService winnerService;
    private final RandomWebClient randomWebClient;

    @Override
    public Winner startLottery() {
        List<Participant> participants = participantRepo.findAll();

        if (participants.size() < MIN_NUMBER_OF_PARTICIPANTS) {
            throw new IllegalArgumentException("The number of participants is less than " + MIN_NUMBER_OF_PARTICIPANTS);
        }

        int winningAmount = randomWebClient.getRandomNumber(MIN_WINNING_AMOUNT, MAX_WINNING_AMOUNT);
        int winnerId = randomWebClient.getRandomNumber(0, participants.size() - 1);

        Winner winner = Winner.builder()
                .name(participants.get(winnerId).getName())
                .age(participants.get(winnerId).getAge())
                .city(participants.get(winnerId).getCity())
                .winningAmount(winningAmount)
                .build();

        winnerService.saveWinner(winner);
        participantRepo.deleteAll();

        return winner;
    }

}
