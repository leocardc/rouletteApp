package dev.leonardo.rouletteApp.repository;

import dev.leonardo.rouletteApp.model.RouletteGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RouletteDaoImpl implements RouletteDao {

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY = "ROULETTE";

    @Override
    public Long saveRoulette(RouletteGame rouletteGame) {
        try {
            redisTemplate.opsForHash().put(KEY, rouletteGame.getIdRoulette().toString(),rouletteGame);
            return rouletteGame.getIdRoulette();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateRoulette(RouletteGame rouletteGame) {
        try {
            redisTemplate.opsForHash().put(KEY, rouletteGame.getIdRoulette().toString(),rouletteGame);
            return true;
        }catch (Exception e){
            e.printStackTrace(); 
            return false;
        }
    }

    @Override
    public List<RouletteGame> fetchAllUser() {
        List<RouletteGame> rouletteGames;
        rouletteGames = redisTemplate.opsForHash().values(KEY);
        return rouletteGames;
    }

}
