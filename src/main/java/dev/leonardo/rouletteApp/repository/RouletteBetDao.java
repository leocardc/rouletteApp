package dev.leonardo.rouletteApp.repository;

import dev.leonardo.rouletteApp.model.RouletteBet;

import java.util.List;

public interface RouletteBetDao {
    boolean RegisterBets(Long userId, RouletteBet bet);
}
