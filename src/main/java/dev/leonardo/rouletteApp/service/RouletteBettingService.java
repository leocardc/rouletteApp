package dev.leonardo.rouletteApp.service;

import dev.leonardo.rouletteApp.model.RouletteBet;


public interface RouletteBettingService {
    boolean placeBets(Long userId, RouletteBet bet);
}
