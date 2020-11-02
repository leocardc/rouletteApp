package dev.leonardo.rouletteApp.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class RouletteGame implements Serializable {
    private Long idRoulette;

    public Long getIdRoulette() {
        return idRoulette;
    }

    public void setIdRoulette(Long idRoulette) {
        this.idRoulette = idRoulette;
    }
}
