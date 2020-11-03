package dev.leonardo.rouletteApp.service;

import dev.leonardo.rouletteApp.model.RouletteGame;
import dev.leonardo.rouletteApp.repository.RouletteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouletteServiceImpl implements RouletteService {

    @Autowired
    private RouletteDao rouletteDao;

    @Override
    public Long createRoulette(RouletteGame rouletteGame) { return rouletteDao.createRoulette(rouletteGame);
    }

    @Override
    public boolean openRoulette(RouletteGame rouletteGame) {
        return rouletteDao.openRoulette(rouletteGame);
    }

    @Override
    public List<RouletteGame> getAllRoulette() {
        return rouletteDao.getAllRoulette();
    }

    @Override
    public RouletteGame getRouletteById(Long id) {
        return rouletteDao.getRouletteById(id);
    }

    @Override
    public boolean deleteRoulette(Long id) {
        return rouletteDao.deleteRoulette(id);
    }


}
