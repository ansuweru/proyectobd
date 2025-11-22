package co.uis.proyecto.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "solicitud")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Solicitud {
    @Id
    @Column(name = "num_solicitud")
    private long num_solicitud;
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_solicitud")
    private String fecha;

    @Column(name = "cedula")
    private Long cedula;
}
