package dev.leonardo.rouletteApp.service;

import dev.leonardo.rouletteApp.model.RouletteBet;
import dev.leonardo.rouletteApp.repository.RouletteBetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouletteBetServiceImpl implements RouletteBettingService{
    @Autowired
    private RouletteBetDao rouletteBetDao;

    @Override
    public boolean placeBets(Long userId, RouletteBet bet) {
        return rouletteBetDao.placeBets(userId,bet);
    }
}
