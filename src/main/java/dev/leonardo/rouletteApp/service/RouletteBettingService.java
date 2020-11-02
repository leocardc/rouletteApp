package dev.leonardo.rouletteApp.service;

import dev.leonardo.rouletteApp.model.RouletteBet;


public interface RouletteBettingService {
    boolean RegisterBets(Long userId, RouletteBet bet);
}
