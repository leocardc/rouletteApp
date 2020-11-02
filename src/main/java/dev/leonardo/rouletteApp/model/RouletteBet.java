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
}
