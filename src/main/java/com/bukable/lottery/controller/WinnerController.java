package com.bukable.lottery.controller;

import com.bukable.lottery.domain.Winner;
import com.bukable.lottery.service.WinnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("lottery")
@RequiredArgsConstructor
public class WinnerController {

    private final WinnerService winnerService;

    @GetMapping("/winners")
    public List<Winner> findWinners() {
        return winnerService.findAll();
    }

}
