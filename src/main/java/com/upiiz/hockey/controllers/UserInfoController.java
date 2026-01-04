package com.upiiz.hockey.controllers;

import com.upiiz.hockey.UserInfo;
import com.upiiz.hockey.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid; // ¡Importación clave!
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/userinfo")
@CrossOrigin
public class UserInfoController {

    @Autowired
    private UserInfoService service;

    @GetMapping
    public List<UserInfo> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Optional<UserInfo> getById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public UserInfo create(@Valid @RequestBody UserInfo info) { // <-- @Valid añadido
        return service.save(info);
    }

    @PutMapping("/{id}")
    public UserInfo update(@PathVariable Long id, @Valid @RequestBody UserInfo info) { // <-- @Valid añadido
        info.setId(id);
        return service.save(info);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    // Endpoint de relación/filtro: Obtener UserInfo por AppUser ID (asumiendo que es la clave más lógica)
    @GetMapping("/user/{userId}")
    public Optional<UserInfo> getByUserId(@PathVariable Long userId) {
        // Asumiendo que esta es una relación 1:1, solo debería haber un resultado.
        return service.findAll().stream().filter(i -> userId.equals(i.getUserId())).findFirst();
    }
}