package com.upiiz.hockey;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent; // Para LocalDateTime
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "hockeygame")
public class HockeyGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // VALIDACIONES Y REFERENCIAS:
    @NotNull(message = "El ID de la ronda es obligatorio.")
    @Column(name = "playoff_round_id", nullable = false) // Corrección: Usar el nombre de columna del script SQL (playoff_round_id)
    private Long roundId;

    @NotNull(message = "La fecha y hora de inicio son obligatorias.")
    @FutureOrPresent(message = "La hora de inicio debe ser futura o presente.")
    private LocalDateTime startTime;

    @NotBlank(message = "La descripción del juego es obligatoria.")
    private String description;

    @NotNull(message = "El ID del equipo 1 (local) es obligatorio.")
    @Column(name = "home_team_id", nullable = false) // Corrección: Usar el nombre de columna del script SQL (home_team_id)
    private Long team1Id;

    @NotNull(message = "El ID del equipo 2 (visitante) es obligatorio.")
    @Column(name = "away_team_id", nullable = false) // Corrección: Usar el nombre de columna del script SQL (away_team_id)
    private Long team2Id;

    // Relaciones (mantengo la estructura)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "playoff_round_id", insertable = false, updatable = false)
    private PlayoffRound round;

    @OneToOne(mappedBy = "game", fetch = FetchType.LAZY)
    private GameScores scores;

    public HockeyGame() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getRoundId() { return roundId; }
    public void setRoundId(Long roundId) { this.roundId = roundId; }
    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Long getTeam1Id() { return team1Id; }
    public void setTeam1Id(Long team1Id) { this.team1Id = team1Id; }
    public Long getTeam2Id() { return team2Id; }
    public void setTeam2Id(Long team2Id) { this.team2Id = team2Id; }
    public PlayoffRound getRound() { return round; }
    public void setRound(PlayoffRound round) { this.round = round; }
    public GameScores getScores() { return scores; }
    public void setScores(GameScores scores) { this.scores = scores; }
}