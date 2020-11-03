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
    public Long createRoulette(RouletteGame rouletteGame) {
        try {
            rouletteGame.setStatus(rouletteGame.getStatus().toUpperCase());
            redisTemplate.opsForHash().put(KEY, rouletteGame.getIdRoulette().toString(),rouletteGame);
            return rouletteGame.getIdRoulette();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean openRoulette(RouletteGame rouletteGame) {
        try {
            redisTemplate.opsForHash().put(KEY, rouletteGame.getIdRoulette().toString(),rouletteGame);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public List<RouletteGame> getAllRoulette() {
        List<RouletteGame> rouletteGames;
        rouletteGames = redisTemplate.opsForHash().values(KEY);
        return rouletteGames;
    }

    @Override
    public RouletteGame getRouletteById(Long id) {
        RouletteGame rouletteGame;
        rouletteGame = (RouletteGame) redisTemplate.opsForHash().get(KEY,id.toString());
        return rouletteGame;
    }

    @Override
    public boolean deleteRoulette(Long id) {
        try {
            redisTemplate.opsForHash().delete(KEY,id.toString());
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


}
