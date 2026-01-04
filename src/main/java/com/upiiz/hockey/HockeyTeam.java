package com.upiiz.hockey;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "hockeyteam")
public class HockeyTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del equipo es obligatorio.")
    @Size(max = 100, message = "El nombre no debe exceder los 100 caracteres.")
    @Column(name = "team_name", nullable = false) // ⬅️ CORRECCIÓN CLAVE para forzar el mapeo
    private String name;

    @NotBlank(message = "La ciudad es obligatoria.")
    @Size(max = 100, message = "La ciudad no debe exceder los 100 caracteres.")
    private String city;

    @NotBlank(message = "El nombre del coach es obligatorio.")
    @Size(max = 100, message = "El nombre del coach no debe exceder los 100 caracteres.")
    private String coachName;

    private String logo; // El mapeo a 'logo' es correcto.

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private List<HockeyTeamPlayer> players;

    public HockeyTeam() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    // Getters y Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getCoachName() { return coachName; }
    public void setCoachName(String coachName) { this.coachName = coachName; }

    public String getLogo() { return logo; }
    public void setLogo(String logo) { this.logo = logo; }
    public List<HockeyTeamPlayer> getPlayers() { return players; }
    public void setPlayers(List<HockeyTeamPlayer> players) { this.players = players; }
}