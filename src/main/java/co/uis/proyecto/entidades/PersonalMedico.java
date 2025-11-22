package co.uis.proyecto.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity@Table(name="personal_medico")
@Data@NoArgsConstructor@AllArgsConstructor@Builder
public class PersonalMedico {
    @Id@Column(name = "id_medico")
    private int id_medico;

    @Column(name = "nombre_completo")
    private String nombre_completo;

    @Column(name = "especialidad")
    private String especialidad;

    @Column(name = "num_colegiado")
    private int num_colegiado;
}
