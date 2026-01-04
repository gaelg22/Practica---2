package com.upiiz.hockey;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "hockeyteamplayer")
public class HockeyTeamPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // VALIDACIÓN: El ID del equipo es obligatorio
    @NotNull(message = "El ID del equipo es obligatorio.")
    @Column(name = "hockeyteamid", nullable = false)
    private Long hockeyTeamId;

    // VALIDACIONES: Nombre del jugador
    @NotBlank(message = "El nombre del jugador es obligatorio.")
    @Size(max = 100) // Basado en tu script SQL para player_name
    private String firstName;

    @NotBlank(message = "El apellido del jugador es obligatorio.")
    @Size(max = 100)
    private String lastName;

    @NotBlank(message = "El número de camiseta es obligatorio.")
    private String jerseyNum;

    @NotBlank(message = "La posición es obligatoria.")
    @Size(max = 50)
    private String position;

    // Relación de lectura
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hockeyteamid", insertable = false, updatable = false)
    private HockeyTeam team;

    public HockeyTeamPlayer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHockeyTeamId() {
        return hockeyTeamId;
    }

    public void setHockeyTeamId(Long hockeyTeamId) {
        this.hockeyTeamId = hockeyTeamId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJerseyNum() {
        return jerseyNum;
    }

    public void setJerseyNum(String jerseyNum) {
        this.jerseyNum = jerseyNum;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public HockeyTeam getTeam() {
        return team;
    }

    public void setTeam(HockeyTeam team) {
        this.team = team;
    }
}