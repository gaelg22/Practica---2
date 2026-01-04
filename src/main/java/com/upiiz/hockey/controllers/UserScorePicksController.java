package com.upiiz.hockey.controllers;

import com.upiiz.hockey.UserScorePicks;
import com.upiiz.hockey.services.UserScorePicksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid; // ¡Importación clave!
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/scorepicks")
@CrossOrigin
public class UserScorePicksController {

    @Autowired
    private UserScorePicksService service;

    @GetMapping
    public List<UserScorePicks> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Optional<UserScorePicks> getById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public UserScorePicks create(@Valid @RequestBody UserScorePicks pick) { // <-- @Valid añadido
        return service.save(pick);
    }

    @PutMapping("/{id}")
    public UserScorePicks update(@PathVariable Long id, @Valid @RequestBody UserScorePicks pick) { // <-- @Valid añadido
        pick.setId(id);
        return service.save(pick);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    // Endpoint de relación/filtro: Picks por usuario
    @GetMapping("/user/{userId}")
    public List<UserScorePicks> getByUser(@PathVariable Long userId) {
        return service.findAll().stream().filter(p -> userId.equals(p.getUserId())).toList();
    }

    // Endpoint de relación/filtro: Picks por juego
    @GetMapping("/game/{gameId}")
    public List<UserScorePicks> getByGame(@PathVariable Long gameId) {
        return service.findAll().stream().filter(p -> gameId.equals(p.getHockeyGameId())).toList();
    }
}