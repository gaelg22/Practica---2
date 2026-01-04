package com.upiiz.hockey.controllers;

import com.upiiz.hockey.UserStatsPicks;
import com.upiiz.hockey.services.UserStatsPicksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid; // ¡Importación clave!
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/statspicks")
@CrossOrigin
public class UserStatsPicksController {

    @Autowired
    private UserStatsPicksService service;

    @GetMapping
    public List<UserStatsPicks> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Optional<UserStatsPicks> getById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public UserStatsPicks create(@Valid @RequestBody UserStatsPicks pick) { // <-- @Valid añadido
        return service.save(pick);
    }

    @PutMapping("/{id}")
    public UserStatsPicks update(@PathVariable Long id, @Valid @RequestBody UserStatsPicks pick) { // <-- @Valid añadido
        pick.setId(id);
        return service.save(pick);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    // Endpoint de relación/filtro: Obtener picks por usuario
    @GetMapping("/user/{userId}")
    public List<UserStatsPicks> getByUser(@PathVariable Long userId) {
        return service.findAll().stream().filter(p -> userId.equals(p.getUserId())).toList();
    }
}