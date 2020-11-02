package dev.leonardo.rouletteApp.service;

import dev.leonardo.rouletteApp.model.RouletteGame;
import dev.leonardo.rouletteApp.repository.RouletteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouletteServiceImpl implements RouletteService {

    @Autowired
    private RouletteDao rouletteDao;

    @Override
    public Long saveRoulette(RouletteGame rouletteGame) {
        return rouletteDao.saveRoulette(rouletteGame);
    }
}
