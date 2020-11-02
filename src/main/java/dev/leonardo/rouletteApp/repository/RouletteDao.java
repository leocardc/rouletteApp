package dev.leonardo.rouletteApp.repository;

import dev.leonardo.rouletteApp.model.RouletteGame;

import java.util.List;

public interface RouletteDao {
    Long saveRoulette(RouletteGame rouletteGame);

    boolean updateRoulette(RouletteGame rouletteGame);

    List<RouletteGame> fetchAllUser();

}
