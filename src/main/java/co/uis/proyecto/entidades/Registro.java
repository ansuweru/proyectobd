package co.uis.proyecto.entidades;

import jakarta.persistence.*;
import lombok.*;
@Entity@Table(name="registro")
@Data@NoArgsConstructor@AllArgsConstructor@Builder
public class Registro {
    @Id@Column(name = "num_registro")
    private int num_registro;

    @Column(name = "id_usuario")
    private int id_usuario;

    @Column(name = "num_episodio")
    private int num_episodio;

    @Column(name = "fecha_hora_registro")
    private String fecha_hora_registro;

    @Column(name = "tipo_acceso")
    private String tipo_acceso;
}