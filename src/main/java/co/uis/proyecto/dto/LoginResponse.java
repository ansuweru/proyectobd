package co.uis.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private Long idUsuario;
    private String nombreUsuario;
    private String rol;
    private Long idPersona;
}
