package co.uis.proyecto.dto;

import co.uis.proyecto.entidades.Registro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogAuditoriaDTO {
    private Registro registro;
    private String nombreUsuario;
}
