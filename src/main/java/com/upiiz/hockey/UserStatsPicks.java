package com.upiiz.hockey;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "userstatspicks")
public class UserStatsPicks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // VALIDACIÓN: Referencias de claves foráneas
    @NotNull(message = "El ID de la ronda es obligatorio.")
    @Column(name = "roundid", nullable = false)
    private Long roundId;

    @NotNull(message = "El ID del líder de goles es obligatorio.")
    @Column(name = "goalleaderid", nullable = false)
    private Long goalLeaderId;

    @NotNull(message = "El ID del líder de asistencias es obligatorio.")
    @Column(name = "assistleaderid", nullable = false)
    private Long assistLeaderId;

    @NotNull(message = "El ID del líder de penalizaciones es obligatorio.")
    @Column(name = "penaltyleaderid", nullable = false)
    private Long penaltyLeaderId;

    @NotNull(message = "El ID del líder de +/- es obligatorio.")
    @Column(name = "plusminusleaderid", nullable = false)
    private Long plusMinusLeaderId;

    @NotNull(message = "El ID del líder de faceoffs ganados es obligatorio.")
    @Column(name = "faceoffswonleaderid", nullable = false)
    private Long faceoffsWonLeaderId;

    @NotNull(message = "El ID del líder de SOG es obligatorio.")
    @Column(name = "sogleaderid", nullable = false)
    private Long sogLeaderId;

    @NotNull(message = "El número de shutouts es obligatorio.")
    @Min(value = 0, message = "El número de shutouts no puede ser negativo.")
    private Integer numShutouts;

    @NotNull(message = "El ID del usuario es obligatorio.")
    @Column(name = "userid", nullable = false)
    private Long userId;

    public UserStatsPicks() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getRoundId() { return roundId; }
    public void setRoundId(Long roundId) { this.roundId = roundId; }
    public Long getGoalLeaderId() { return goalLeaderId; }
    public void setGoalLeaderId(Long goalLeaderId) { this.goalLeaderId = goalLeaderId; }
    public Long getAssistLeaderId() { return assistLeaderId; }
    public void setAssistLeaderId(Long assistLeaderId) { this.assistLeaderId = assistLeaderId; }
    public Long getPenaltyLeaderId() { return penaltyLeaderId; }
    public void setPenaltyLeaderId(Long penaltyLeaderId) { this.penaltyLeaderId = penaltyLeaderId; }
    public Long getPlusMinusLeaderId() { return plusMinusLeaderId; }
    public void setPlusMinusLeaderId(Long plusMinusLeaderId) { this.plusMinusLeaderId = plusMinusLeaderId; }
    public Long getFaceoffsWonLeaderId() { return faceoffsWonLeaderId; }
    public void setFaceoffsWonLeaderId(Long faceoffsWonLeaderId) { this.faceoffsWonLeaderId = faceoffsWonLeaderId; }
    public Long getSogLeaderId() { return sogLeaderId; }
    public void setSogLeaderId(Long sogLeaderId) { this.sogLeaderId = sogLeaderId; }
    public Integer getNumShutouts() { return numShutouts; }
    public void setNumShutouts(Integer numShutouts) { this.numShutouts = numShutouts; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}