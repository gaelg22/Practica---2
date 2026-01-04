package com.upiiz.hockey;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "gamescores")
public class GameScores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // VALIDACIONES Y REFERENCIAS:
    @NotNull(message = "El ID del juego es obligatorio.")
    @Column(name = "hockeygameid", nullable = false) // Added nullable = false for constraint consistency
    private Long hockeyGameId;

    @NotNull(message = "La puntuación del equipo 1 es obligatoria.")
    @Min(value = 0, message = "La puntuación debe ser un valor positivo.")
    @Column(nullable = false)
    private Integer team1Score;

    @NotNull(message = "La puntuación del equipo 2 es obligatoria.")
    @Min(value = 0, message = "La puntuación debe ser un valor positivo.")
    @Column(nullable = false)
    private Integer team2Score;

    // Relación de lectura. Tu mapeo de FK es correcto.
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hockeygameid", insertable = false, updatable = false)
    private HockeyGame game;

    public GameScores() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getHockeyGameId() { return hockeyGameId; }
    public void setHockeyGameId(Long hockeyGameId) { this.hockeyGameId = hockeyGameId; }
    public Integer getTeam1Score() { return team1Score; }
    public void setTeam1Score(Integer team1Score) { this.team1Score = team1Score; }
    public Integer getTeam2Score() { return team2Score; }
    public void setTeam2Score(Integer team2Score) { this.team2Score = team2Score; }
    public HockeyGame getGame() { return game; }
    public void setGame(HockeyGame game) { this.game = game; }
}