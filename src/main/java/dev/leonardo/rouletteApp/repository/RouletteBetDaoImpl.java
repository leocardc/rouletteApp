package dev.leonardo.rouletteApp.repository;

import dev.leonardo.rouletteApp.model.BetValidator;
import dev.leonardo.rouletteApp.model.RouletteBet;
import dev.leonardo.rouletteApp.model.RouletteGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class RouletteBetDaoImpl implements RouletteBetDao {

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY = "BET";

    @Override
    public boolean placeBets(Long userId, RouletteBet bet) {
        try {
            bet.setUserId(userId);
            redisTemplate.opsForHash().put(KEY,bet.getBetId().toString(),bet);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<RouletteBet> getBetById(Long id, int result) {
        List<RouletteBet> bets;
        List<RouletteBet> filterBets = new ArrayList<>();
        bets = redisTemplate.opsForHash().values(KEY);
        for (RouletteBet bet : bets){
            if(bet.getGameId() == id.longValue()){
                filterBets.add(bet);
                bet.GetWinnings(bet,result);
            }
        }
        return  filterBets;
    }
}
