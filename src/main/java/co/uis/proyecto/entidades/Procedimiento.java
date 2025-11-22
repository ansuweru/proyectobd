package co.uis.proyecto.entidades;

import jakarta.persistence.*;
import lombok.*;
@Entity@Table(name="procedimiento")
@Data@NoArgsConstructor@AllArgsConstructor@Builder
public class Procedimiento {

    @Id@Column(name = "id_procedimiento")
    private int id_procedimiento;

    @Column(name = "id_procedimiento")
    private int numero_episodio;

    @Column(name = "codigo_cup")
    private String codigo_cup;

    @Column(name = "nombre_procedimiento")
    private String nombre_procedimiento;

    @Column(name = "fecha_procedimiento")
    private String fecha_procedimiento;
}
