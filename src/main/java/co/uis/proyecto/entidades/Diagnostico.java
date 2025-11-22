package co.uis.proyecto.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity@Table(name="diagnostico")
@Data@NoArgsConstructor@AllArgsConstructor@Builder
public class Diagnostico {
    @Id
    private int id_diagnostico;

    @Column(name = "num_episodio")
    private int num_episodio;

    @Column(name = "codigo_cie")
    private String codigo_cie;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "tipo")
    private String tipo;
}
