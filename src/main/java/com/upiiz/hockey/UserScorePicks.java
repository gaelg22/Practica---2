package com.upiiz.hockey;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "userscorepicks")
public class UserScorePicks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // VALIDACIÓN: El ID del juego es obligatorio.
    @NotNull(message = "El ID del juego es obligatorio.")
    @Column(name = "hockeygameid", nullable = false)
    private Long hockeyGameId;

    // VALIDACIÓN: Las puntuaciones predichas son obligatorias y no negativas.
    @NotNull(message = "La puntuación predicha del equipo 1 es obligatoria.")
    @Min(value = 0, message = "La puntuación predicha debe ser un valor positivo o cero.")
    @Column(nullable = false)
    private Integer team1score;

    @NotNull(message = "La puntuación predicha del equipo 2 es obligatoria.")
    @Min(value = 0, message = "La puntuación predicha debe ser un valor positivo o cero.")
    @Column(nullable = false)
    private Integer team2score;

    // VALIDACIÓN: El ID del usuario es obligatorio.
    @NotNull(message = "El ID del usuario es obligatorio.")
    @Column(name = "userid", nullable = false)
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hockeygameid", insertable = false, updatable = false)
    private HockeyGame game;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", insertable = false, updatable = false)
    private AppUser user;

    public UserScorePicks() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getHockeyGameId() { return hockeyGameId; }
    public void setHockeyGameId(Long hockeyGameId) { this.hockeyGameId = hockeyGameId; }
    public Integer getTeam1score() { return team1score; }
    public void setTeam1score(Integer team1score) { this.team1score = team1score; }
    public Integer getTeam2score() { return team2score; }
    public void setTeam2score(Integer team2score) { this.team2score = team2score; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public HockeyGame getGame() { return game; }
    public void setGame(HockeyGame game) { this.game = game; }
    public AppUser getUser() { return user; }
    public void setUser(AppUser user) { this.user = user; }
}