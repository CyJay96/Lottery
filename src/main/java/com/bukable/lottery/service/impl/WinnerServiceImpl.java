package com.bukable.lottery.service.impl;

import com.bukable.lottery.domain.Winner;
import com.bukable.lottery.repository.WinnerRepo;
import com.bukable.lottery.service.WinnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WinnerServiceImpl implements WinnerService {

    private final WinnerRepo winnerRepo;

    @Override
    public List<Winner> findAll() {
        return winnerRepo.findAll();
    }

    @Override
    public void saveWinner(Winner winner) {
        winnerRepo.save(winner);
    }

}
