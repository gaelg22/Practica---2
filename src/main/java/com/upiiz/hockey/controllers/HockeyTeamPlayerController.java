package com.upiiz.hockey.controllers;

import com.upiiz.hockey.HockeyTeamPlayer;
import com.upiiz.hockey.services.HockeyTeamPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid; // ¡Importación clave!
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teamplayers")
@CrossOrigin
public class HockeyTeamPlayerController {

    @Autowired
    private HockeyTeamPlayerService service;

    @GetMapping
    public List<HockeyTeamPlayer> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Optional<HockeyTeamPlayer> getById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public HockeyTeamPlayer create(@Valid @RequestBody HockeyTeamPlayer player) { // <-- @Valid añadido
        return service.save(player);
    }

    @PutMapping("/{id}")
    public HockeyTeamPlayer update(@PathVariable Long id, @Valid @RequestBody HockeyTeamPlayer player) { // <-- @Valid añadido
        player.setId(id);
        return service.save(player);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    // Endpoint de relación/filtro: Obtener jugadores por ID de equipo
    @GetMapping("/team/{teamId}")
    public List<HockeyTeamPlayer> getByTeam(@PathVariable Long teamId) {
        return service.findAll().stream().filter(p -> teamId.equals(p.getHockeyTeamId())).toList();
    }
}