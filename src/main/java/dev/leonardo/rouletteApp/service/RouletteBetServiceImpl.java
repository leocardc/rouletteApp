package dev.leonardo.rouletteApp.service;

import dev.leonardo.rouletteApp.model.RouletteBet;
import dev.leonardo.rouletteApp.repository.RouletteBetDao;
import dev.leonardo.rouletteApp.repository.RouletteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouletteBetServiceImpl implements RouletteBettingService{
    @Autowired
    private RouletteBetDao rouletteBetDao;

    @Override
    public boolean RegisterBets(Long userId, RouletteBet bet) {
        return rouletteBetDao.RegisterBets(userId,bet);
    }
}
