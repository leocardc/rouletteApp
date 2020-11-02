package dev.leonardo.rouletteApp.repository;

import dev.leonardo.rouletteApp.model.RouletteGame;

public interface RouletteDao {
    Long saveRoulette(RouletteGame rouletteGame);
}
