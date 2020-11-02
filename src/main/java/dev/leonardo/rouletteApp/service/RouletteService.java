package dev.leonardo.rouletteApp.service;

import dev.leonardo.rouletteApp.model.RouletteGame;

import java.util.List;

public interface RouletteService {
    Long saveRoulette(RouletteGame rouletteGame);
    boolean updateRoulette(RouletteGame rouletteGame);
    List<RouletteGame> fetchAllUser();

}
