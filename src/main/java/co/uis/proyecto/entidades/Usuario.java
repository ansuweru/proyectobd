package co.uis.proyecto.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity@Table(name="usuario")
@Data@NoArgsConstructor@AllArgsConstructor@Builder
public class Usuario {
    @Id@Column(name="id_usuario")
    private long id_usuario;

    @Column(name="nombre_usuario")
    private String nombre_usuario;

    @Column(name="rol")
    private String rol;

    @Column(name="id_persona")
    private String id_persona;
}
