package com.upiiz.hockey.controllers;

import com.upiiz.hockey.AppUser;
import com.upiiz.hockey.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid; //
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class AppUserController {

    @Autowired
    private AppUserService service;

    @GetMapping
    public List<AppUser> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Optional<AppUser> getById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public AppUser create(@Valid @RequestBody AppUser user) { // <-- @Valid añadido
        return service.save(user);
    }

    @PutMapping("/{id}")
    public AppUser update(@PathVariable Long id, @Valid @RequestBody AppUser user) { // <-- @Valid añadido
        user.setId(id);
        return service.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}