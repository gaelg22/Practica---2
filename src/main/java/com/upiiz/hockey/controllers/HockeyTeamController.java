package com.upiiz.hockey.controllers;

import com.upiiz.hockey.HockeyTeam;
import com.upiiz.hockey.services.HockeyTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid; // ¡Importación clave!
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teams")
@CrossOrigin
public class HockeyTeamController {

    @Autowired
    private HockeyTeamService service;

    @GetMapping
    public List<HockeyTeam> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Optional<HockeyTeam> getById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public HockeyTeam create(@Valid @RequestBody HockeyTeam team) { // <-- @Valid añadido
        return service.save(team);
    }

    @PutMapping("/{id}")
    public HockeyTeam update(@PathVariable Long id, @Valid @RequestBody HockeyTeam team) { // <-- @Valid añadido
        team.setId(id);
        return service.save(team);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}