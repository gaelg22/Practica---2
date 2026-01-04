package com.upiiz.hockey;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "userinfo")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // CLAVE FORÁNEA FALTANTE: user_id (referencia a AppUser)
    @NotNull(message = "El ID del usuario (AppUser) es obligatorio.")
    @Column(name = "user_id", nullable = false, unique = true) // UNIQUE para una relación 1:1
    private Long userId;

    @NotBlank(message = "El nombre es obligatorio.")
    private String firstName;

    @NotBlank(message = "El apellido es obligatorio.")
    private String lastName;

    @Email(message = "El formato del correo electrónico es inválido.")
    private String email;

    // Puntos (Asumimos que no pueden ser negativos)
    @Min(value = 0, message = "Los puntos deben ser un valor positivo o cero.")
    private Integer round1Points;

    @Min(value = 0, message = "Los puntos deben ser un valor positivo o cero.")
    private Integer round2Points;

    @Min(value = 0, message = "Los puntos deben ser un valor positivo o cero.")
    private Integer round3Points;

    @Min(value = 0, message = "Los puntos deben ser un valor positivo o cero.")
    private Integer round4Points;

    // Relación de lectura (opcional, pero útil)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private AppUser appUser;

    public UserInfo() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Integer getRound1Points() { return round1Points; }
    public void setRound1Points(Integer round1Points) { this.round1Points = round1Points; }
    public Integer getRound2Points() { return round2Points; }
    public void setRound2Points(Integer round2Points) { this.round2Points = round2Points; }
    public Integer getRound3Points() { return round3Points; }
    public void setRound3Points(Integer round3Points) { this.round3Points = round3Points; }
    public Integer getRound4Points() { return round4Points; }
    public void setRound4Points(Integer round4Points) { this.round4Points = round4Points; }
    public AppUser getAppUser() { return appUser; }
    public void setAppUser(AppUser appUser) { this.appUser = appUser; }
}