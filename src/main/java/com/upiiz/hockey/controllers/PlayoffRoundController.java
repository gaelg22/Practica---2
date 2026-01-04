package com.upiiz.hockey.controllers;

import com.upiiz.hockey.PlayoffRound;
import com.upiiz.hockey.services.PlayoffRoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid; // ¡Importación clave!
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/playoffrounds")
@CrossOrigin
public class PlayoffRoundController {

    @Autowired
    private PlayoffRoundService service;

    @GetMapping
    public List<PlayoffRound> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Optional<PlayoffRound> getById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public PlayoffRound create(@Valid @RequestBody PlayoffRound round) { // <-- @Valid añadido
        return service.save(round);
    }

    @PutMapping("/{id}")
    public PlayoffRound update(@PathVariable Long id, @Valid @RequestBody PlayoffRound round) { // <-- @Valid añadido
        round.setId(id);
        return service.save(round);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}