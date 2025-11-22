package co.uis.proyecto.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario_sistema")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {
    @Id
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @Column(name = "rol")
    private String rol;

    @Column(name = "id_persona")
    private Long idPersona;

    @Column(name = "contrasena")
    private String contrasena;
}
