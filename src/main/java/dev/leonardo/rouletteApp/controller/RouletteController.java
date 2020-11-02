package dev.leonardo.rouletteApp.controller;

import dev.leonardo.rouletteApp.model.RouletteGame;
import dev.leonardo.rouletteApp.service.RouletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PutMapping("/openRoulette/{id}")
    public ResponseEntity<String> updateRoulette(@PathVariable("id") Long id, @RequestBody RouletteGame rouletteGame){
        boolean result = rouletteService.updateRoulette(rouletteGame);
        if (result )
            return ResponseEntity.ok("Roulette Game Open Successfully!!");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @GetMapping("/roulettes")
    public ResponseEntity<List<RouletteGame>> fetchAllUser(){
        List<RouletteGame> rouletteGames;
        rouletteGames = rouletteService.fetchAllUser();
        return ResponseEntity.ok(rouletteGames);
    }

}
