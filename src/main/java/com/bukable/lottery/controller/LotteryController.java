package com.bukable.lottery.controller;

import com.bukable.lottery.domain.Winner;
import com.bukable.lottery.service.LotteryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "lottery/start", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class LotteryController {

    private final LotteryService lotteryService;

    @GetMapping
    public ResponseEntity<Winner> start() {
        Winner winner = lotteryService.startLottery();
        return ResponseEntity.ok(winner);
    }

}
