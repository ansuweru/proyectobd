package co.uis.proyecto.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity@Table(name="episodio_clinico")
@Data@NoArgsConstructor@AllArgsConstructor@Builder
public class EpisodioClinico {
    @Id@Column(name = "num_episodio")
    private int num_episodio;

    @Column(name = "cedula")
    private int cedula;

    @Column(name = "id_medico")
    private int id_medico;

    @Column(name = "fecha_apertura")
    private String fecha_apertura;

    @Column(name = "motivo_consulta")
    private String motivo_consulta;

    @Column(name = "anamnesis")
    private String anamnesis;

    @Column(name = "plan_manejo")
    private String plan_manejo;

    @Column(name = "estado")
    private boolean estado;
}


