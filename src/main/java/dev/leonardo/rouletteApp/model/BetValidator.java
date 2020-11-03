package dev.leonardo.rouletteApp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BetValidator {


    public static List<Integer> blackNumbers = new ArrayList<Integer>(Arrays.asList(1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36));
    public static List<Integer>  redNumbers = new ArrayList<Integer>(Arrays.asList(2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35));
    private static final String STATUS = "CLOSED";
    public static boolean AreBetsValid(RouletteBet bet, RouletteGame rouletteGame) {

        if (bet.getGameId() <= 0 || bet.getBetAmount() <= 0 || bet.getNumberBet() < 0 ||
            bet.getNumberBet() > 36 || rouletteGame.getStatus().equals(STATUS)){
            return false;
        }
        return true;
    }


}
