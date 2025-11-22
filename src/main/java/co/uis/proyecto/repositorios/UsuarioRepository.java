package co.uis.proyecto.repositorios;

import co.uis.proyecto.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNombreUsuarioAndContrasena(String nombreUsuario, String contrasena);
}
