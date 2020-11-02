package dev.leonardo.rouletteApp.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class RouletteGame implements Serializable {
    private Long idRoulette;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getIdRoulette() {
        return idRoulette;
    }

    public void setIdRoulette(Long idRoulette) {
        this.idRoulette = idRoulette;
    }
}
