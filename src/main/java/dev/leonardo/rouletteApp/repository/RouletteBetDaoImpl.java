package dev.leonardo.rouletteApp.repository;

import dev.leonardo.rouletteApp.model.RouletteBet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class RouletteBetDaoImpl implements RouletteBetDao {

    @Autowired
    private RedisTemplate redisTemplate;


    private static final String KEY = "BET";

    @Override
    public boolean placeBets(Long userId, RouletteBet bet) {
        try {
            bet.setBetId(userId);
            redisTemplate.opsForHash().put(KEY,bet.getGameId().toString(),bet);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }


    }
}
