package com.usuario_gateway.model;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "correo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Correo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 45)
    private String correoElectronico;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usermodel usermodel;

}
