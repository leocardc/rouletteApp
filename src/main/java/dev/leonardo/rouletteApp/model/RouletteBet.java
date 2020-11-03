package dev.leonardo.rouletteApp.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class RouletteBet implements Serializable {

    private int numberBet;
    private BetType betType;
    private Double betAmount;
    private Long gameId;
    private Long userId;
    private Long betId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBetId() {
        return betId;
    }

    public void setBetId(Long betId) {
        this.betId = betId;
    }

    private double winnings;

    public int getNumberBet() {
        return numberBet;
    }

    public void setNumberBet(int numberBet) {
        this.numberBet = numberBet;
    }

    public BetType getBetType() {
        return betType;
    }

    public void setBetType(BetType betType) {
        this.betType = betType;
    }

    public Double getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(Double betAmount) {
        this.betAmount = betAmount;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public double getWinnings() {
        return winnings;
    }

    public void setWinnings(double winnings) {
        this.winnings = winnings;
    }

    public void GetWinnings(RouletteBet bet,int result) {
        if ( IsWinningBet(bet, result)) {

            if (bet.betType != null) {
                setWinnings(GetSpecialBetWinnings(bet));
            }
            else {
                setWinnings(bet.betAmount * 5);
            }
        }else{setWinnings(0);}

    }

    private double GetSpecialBetWinnings(RouletteBet bet) {
        switch (bet.betType) {
            case RED:
            case BLACK:
                return bet.betAmount * 1.8;
        }
        return 0;
    }
    public static boolean IsWinningBet(RouletteBet bet, int result) {
        if (bet.getBetType() == null) {
            if (bet.getNumberBet() == result) {
                return true;
            }
            return false;
        }

        switch (bet.betType) {
            case RED:
                if (BetValidator.redNumbers.contains(result)) {
                    return true;
                }
                break;
            case BLACK:
                if (BetValidator.blackNumbers.contains(result)) {
                    return true;
                }
                break;

        }

        return false;
    }
}
