package com.upiiz.hockey.controllers;

import com.upiiz.hockey.HockeyGame;
import com.upiiz.hockey.services.HockeyGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid; // ¡Importación clave!
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/games")
@CrossOrigin
public class HockeyGameController {

    @Autowired
    private HockeyGameService service;

    @GetMapping
    public List<HockeyGame> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Optional<HockeyGame> getById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public HockeyGame create(@Valid @RequestBody HockeyGame game) { // <-- @Valid añadido
        return service.save(game);
    }

    @PutMapping("/{id}")
    public HockeyGame update(@PathVariable Long id, @Valid @RequestBody HockeyGame game) { // <-- @Valid añadido
        game.setId(id);
        return service.save(game);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    // Endpoint de relación/filtro: Buscar juegos por ronda de playoff
    @GetMapping("/round/{roundId}")
    public List<HockeyGame> findByRound(@PathVariable Long roundId) {
        // Usando getRoundId() que está en la entidad
        return service.findAll().stream().filter(g -> roundId.equals(g.getRoundId())).toList();
    }
}