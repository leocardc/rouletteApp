package dev.leonardo.rouletteApp.controller;

import dev.leonardo.rouletteApp.model.BetValidator;
import dev.leonardo.rouletteApp.model.RouletteBet;
import dev.leonardo.rouletteApp.model.RouletteGame;
import dev.leonardo.rouletteApp.service.RouletteBettingService;
import dev.leonardo.rouletteApp.service.RouletteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RouletteController {

    private final RouletteService rouletteService;
    private final RouletteBettingService  bettingService;

    private static final String STATUSOPEN = "OPEN";
    private static final String STATUSCLOSE = "CLOSED";

    public RouletteController(RouletteBettingService bettingService, RouletteService rouletteService) {
        this.bettingService = bettingService;
        this.rouletteService = rouletteService;
    }

    @PostMapping("/createRoulette")
    public ResponseEntity<String> createRoulette(@RequestBody RouletteGame rouletteGame){
        Long result = rouletteService.createRoulette(rouletteGame);
        if (result != null)
            return ResponseEntity.ok("Roulette Game Create Successfully!! id: "+result );
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @PutMapping("/openRoulette/{id}")
    public ResponseEntity<String> openRoulette(@PathVariable("id") Long id){
        RouletteGame rouletteGame= rouletteService.getRouletteById(id);
        rouletteGame.setStatus(STATUSOPEN);
        rouletteGame.setNumberWinner(0);
        boolean result = rouletteService.openRoulette(rouletteGame);
        if (result )
            return ResponseEntity.ok("Roulette Game Open Successfully!!");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @GetMapping("/roulettes")
    public ResponseEntity<List<RouletteGame>> getAllRoulette(){
        List<RouletteGame> rouletteGames;
        rouletteGames = rouletteService.getAllRoulette();
        return ResponseEntity.ok(rouletteGames);
    }
    @GetMapping("/roulette/{id}")
    public ResponseEntity<RouletteGame> getRouletteById(@PathVariable("id") Long id){
        RouletteGame rouletteGame;
        rouletteGame = rouletteService.getRouletteById(id);
        return ResponseEntity.ok(rouletteGame);
    }

    @PostMapping("/bet/{id}")
    public ResponseEntity<String> placeBets(@PathVariable("id") Long id, @RequestBody RouletteBet bet) {
        RouletteGame rouletteGame;
        rouletteGame = rouletteService.getRouletteById(bet.getGameId());
        if (BetValidator.AreBetsValid(bet, rouletteGame)) {
            boolean result = bettingService.placeBets(id, bet);
            if (result) {
                return ResponseEntity.ok("Roulette Bet on Successfully!!");
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @PutMapping("/closeBet/{id}")
    public ResponseEntity<List<RouletteBet>> closeBet(@PathVariable("id") Long id){
        int numberWinner = (int)Math.floor(Math.random()*1 +1);
        RouletteGame rouletteGame= rouletteService.getRouletteById(id);
        rouletteGame.setStatus(STATUSCLOSE);
        rouletteGame.setNumberWinner(numberWinner);
        List<RouletteBet> bets;
        boolean result = rouletteService.openRoulette(rouletteGame);
        if (result) {
            bets = bettingService.getBetById(id,numberWinner);
            return ResponseEntity.ok(bets);
        }else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/roulette/{id}")
    public ResponseEntity<String> deleteRoulette(@PathVariable("id") Long id){
        boolean result = rouletteService.deleteRoulette(id);
        if (result)
            return ResponseEntity.ok("Roulette deleted Successfully!!");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
