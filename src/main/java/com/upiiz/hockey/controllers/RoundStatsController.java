package com.upiiz.hockey.controllers;

import com.upiiz.hockey.RoundStats;
import com.upiiz.hockey.services.RoundStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid; // ¡Importación clave!
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roundstats")
@CrossOrigin
public class RoundStatsController {

    @Autowired
    private RoundStatsService service;

    @GetMapping
    public List<RoundStats> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Optional<RoundStats> getById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public RoundStats create(@Valid @RequestBody RoundStats stats) { // <-- @Valid añadido
        return service.save(stats);
    }

    @PutMapping("/{id}")
    public RoundStats update(@PathVariable Long id, @Valid @RequestBody RoundStats stats) { // <-- @Valid añadido
        stats.setId(id);
        return service.save(stats);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    // Endpoint de relación/filtro: Obtener estadísticas por ID de ronda
    @GetMapping("/round/{roundId}")
    public List<RoundStats> getByRound(@PathVariable Long roundId) {
        return service.findAll().stream().filter(s -> roundId.equals(s.getPlayoffRoundId())).toList();
    }
}