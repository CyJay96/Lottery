package com.bukable.lottery.service;

import com.bukable.lottery.domain.Winner;

import java.util.List;

public interface WinnerService {

    List<Winner> findAll();

    void saveWinner(Winner winner);

}
