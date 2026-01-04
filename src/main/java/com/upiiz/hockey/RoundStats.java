package com.upiiz.hockey;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "roundstats")
public class RoundStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // VALIDACIÓN: La referencia a la ronda es obligatoria.
    @NotNull(message = "El ID de la ronda de playoff es obligatorio.")
    @Column(name = "playoff_round_id", nullable = false)
    private Long playoffRoundId;

    // VALIDACIÓN: Los shutouts deben ser al menos cero.
    @NotNull(message = "El número de shutouts es obligatorio.")
    @Min(value = 0, message = "El número de shutouts no puede ser negativo.")
    private Integer numShutouts;

    // VALIDACIÓN: Los IDs de los líderes son obligatorios para registrar las estadísticas.
    @NotNull(message = "El ID del líder de goles es obligatorio.")
    private Long goalLeaderId;

    @NotNull(message = "El ID del líder de asistencias es obligatorio.")
    private Long assistLeaderId;

    @NotNull(message = "El ID del líder de penalizaciones es obligatorio.")
    private Long penaltyLeaderId;

    @NotNull(message = "El ID del líder de +/- es obligatorio.")
    private Long plusMinusLeaderId;

    @NotNull(message = "El ID del líder de faceoffs ganados es obligatorio.")
    private Long faceoffsWonLeaderId;

    @NotNull(message = "El ID del líder de SOG es obligatorio.")
    private Long sogLeaderId;

    // Mapeo opcional de relaciones (lo mantendré simple ya que no lo enviaste):
    // @ManyToOne ...
    // private PlayoffRound round;

    public RoundStats() {}

    // 🔹 Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlayoffRoundId() {
        return playoffRoundId;
    }

    public void setPlayoffRoundId(Long playoffRoundId) {
        this.playoffRoundId = playoffRoundId;
    }

    public Integer getNumShutouts() {
        return numShutouts;
    }

    public void setNumShutouts(Integer numShutouts) {
        this.numShutouts = numShutouts;
    }

    public Long getGoalLeaderId() {
        return goalLeaderId;
    }

    public void setGoalLeaderId(Long goalLeaderId) {
        this.goalLeaderId = goalLeaderId;
    }

    public Long getAssistLeaderId() {
        return assistLeaderId;
    }

    public void setAssistLeaderId(Long assistLeaderId) {
        this.assistLeaderId = assistLeaderId;
    }

    public Long getPenaltyLeaderId() {
        return penaltyLeaderId;
    }

    public void setPenaltyLeaderId(Long penaltyLeaderId) {
        this.penaltyLeaderId = penaltyLeaderId;
    }

    public Long getPlusMinusLeaderId() {
        return plusMinusLeaderId;
    }

    public void setPlusMinusLeaderId(Long plusMinusLeaderId) {
        this.plusMinusLeaderId = plusMinusLeaderId;
    }

    public Long getFaceoffsWonLeaderId() {
        return faceoffsWonLeaderId;
    }

    public void setFaceoffsWonLeaderId(Long faceoffsWonLeaderId) {
        this.faceoffsWonLeaderId = faceoffsWonLeaderId;
    }

    public Long getSogLeaderId() {
        return sogLeaderId;
    }

    public void setSogLeaderId(Long sogLeaderId) {
        this.sogLeaderId = sogLeaderId;
    }
}