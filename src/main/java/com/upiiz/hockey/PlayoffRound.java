package com.upiiz.hockey;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "playoffround")
public class PlayoffRound {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // VALIDACIONES Y REFERENCIAS:
    @NotNull(message = "El ID del equipo 1 es obligatorio.")
    private Long team1Id;

    @NotNull(message = "El ID del equipo 2 es obligatorio.")
    private Long team2Id;

    @NotNull(message = "La fecha y hora de inicio de la ronda son obligatorias.")
    private LocalDateTime startTime;

    @NotNull(message = "La fecha y hora de fin de la ronda son obligatorias.")
    // Nota: La validación @FutureOrPresent o de que endTime sea posterior a startTime
    // debe hacerse a nivel de clase o servicio, pero @NotNull cubre la validación básica.
    private LocalDateTime endTime;

    @NotNull(message = "El número de ronda es obligatorio.")
    @Min(value = 1, message = "El número de ronda debe ser al menos 1.")
    private Integer roundNum;

    @OneToMany(mappedBy = "round", fetch = FetchType.LAZY)
    private List<HockeyGame> games;

    public PlayoffRound() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getTeam1Id() { return team1Id; }
    public void setTeam1Id(Long team1Id) { this.team1Id = team1Id; }
    public Long getTeam2Id() { return team2Id; }
    public void setTeam2Id(Long team2Id) { this.team2Id = team2Id; }
    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }
    public Integer getRoundNum() { return roundNum; }
    public void setRoundNum(Integer roundNum) { this.roundNum = roundNum; }
    public List<HockeyGame> getGames() { return games; }
    public void setGames(List<HockeyGame> games) { this.games = games; }
}