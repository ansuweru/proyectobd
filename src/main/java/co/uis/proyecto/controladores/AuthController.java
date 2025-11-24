package co.uis.proyecto.controladores;

import co.uis.proyecto.dto.LoginRequest;
import co.uis.proyecto.dto.LoginResponse;
import co.uis.proyecto.entidades.Usuario;
import co.uis.proyecto.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Usuario usuario = usuarioRepository.findByNombreUsuarioAndContrasena(request.getUsername(),
                request.getPassword());

        if (usuario != null) {
            return ResponseEntity.ok(new LoginResponse(
                    usuario.getIdUsuario(),
                    usuario.getNombreUsuario(),
                    usuario.getRol(),
                    usuario.getIdPersona()));
        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }
}
