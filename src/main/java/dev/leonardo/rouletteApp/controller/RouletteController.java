package dev.leonardo.rouletteApp.controller;

import dev.leonardo.rouletteApp.model.RouletteGame;
import dev.leonardo.rouletteApp.service.RouletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouletteController {

    @Autowired
    private RouletteService rouletteService;

    @PostMapping("/createRoulette")
    public ResponseEntity<String> saveRoulette(@RequestBody RouletteGame rouletteGame){
        Long result = rouletteService.saveRoulette(rouletteGame);
        if (result != null)
            return ResponseEntity.ok("Roulette Game Create Successfully!! id: "+result );
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
