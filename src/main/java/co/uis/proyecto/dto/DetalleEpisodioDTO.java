package co.uis.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleEpisodioDTO {
    private int numEpisodio;
    private String fechaApertura;
    private String motivoConsulta;
    private String descripcionDiagnostico;
    private String nombreProcedimiento;
}
