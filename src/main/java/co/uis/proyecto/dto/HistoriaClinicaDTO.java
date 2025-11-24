package co.uis.proyecto.dto;

import co.uis.proyecto.entidades.EpisodioClinico;
import co.uis.proyecto.entidades.Paciente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoriaClinicaDTO {
    private EpisodioClinico episodio;
    private Paciente paciente;
    private String nombreMedico;
}
