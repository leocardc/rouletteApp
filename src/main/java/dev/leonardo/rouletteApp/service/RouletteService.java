package dev.leonardo.rouletteApp.service;

import dev.leonardo.rouletteApp.model.RouletteGame;

import java.util.List;

public interface RouletteService {
    Long createRoulette(RouletteGame rouletteGame);
    boolean openRoulette(RouletteGame rouletteGame);
    List<RouletteGame> getAllRoulette();
    RouletteGame getRouletteById(Long id);
    boolean deleteRoulette(Long id);
}
