package dev.leonardo.rouletteApp.service;

import dev.leonardo.rouletteApp.model.RouletteBet;

import java.util.List;


public interface RouletteBettingService {
    boolean placeBets(Long userId, RouletteBet bet);
    List<RouletteBet> getBetById(Long id, int result);
}
