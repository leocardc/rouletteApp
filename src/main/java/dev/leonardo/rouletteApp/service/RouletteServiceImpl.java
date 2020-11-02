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
    public Long saveRoulette(RouletteGame rouletteGame) { return rouletteDao.saveRoulette(rouletteGame);
    }

    @Override
    public boolean updateRoulette(RouletteGame rouletteGame) {
        return rouletteDao.updateRoulette(rouletteGame);
    }

    @Override
    public List<RouletteGame> fetchAllGame() {
        return rouletteDao.fetchAllGame();
    }

    @Override
    public RouletteGame fetchGameById(Long id) {
        return rouletteDao.fetchGameById(id);
    }


}
