package com.upiiz.hockey.controllers;

import com.upiiz.hockey.GameScores;
import com.upiiz.hockey.services.GameScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid; // ¡Importación clave!
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gamescores")
@CrossOrigin
public class GameScoresController {

    @Autowired
    private GameScoresService service;

    @GetMapping
    public List<GameScores> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Optional<GameScores> getById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public GameScores create(@Valid @RequestBody GameScores scores) { // <-- @Valid añadido
        return service.save(scores);
    }

    @PutMapping("/{id}")
    public GameScores update(@PathVariable Long id, @Valid @RequestBody GameScores scores) { // <-- @Valid añadido
        scores.setId(id);
        return service.save(scores);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    // Endpoint de relación/filtro
    @GetMapping("/game/{gameId}")
    public List<GameScores> getByGame(@PathVariable Long gameId) {
        return service.findAll().stream().filter(s -> gameId.equals(s.getHockeyGameId())).toList();
    }
}