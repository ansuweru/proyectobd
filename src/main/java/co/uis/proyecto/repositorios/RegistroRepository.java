package co.uis.proyecto.repositorios;

import co.uis.proyecto.entidades.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface RegistroRepository extends JpaRepository<Registro, Integer> {
    // JOIN #3: Log de Auditoría (Registro + Usuario)
    @Query("SELECT new co.uis.proyecto.dto.LogAuditoriaDTO(r, u.nombreUsuario) " +
            "FROM Registro r, Usuario u WHERE r.id_usuario = u.idUsuario")
    List<co.uis.proyecto.dto.LogAuditoriaDTO> obtenerLogAuditoria();

    @Query("SELECT new co.uis.proyecto.dto.LogAuditoriaDTO(r, u.nombreUsuario) " +
            "FROM Registro r, Usuario u WHERE r.id_usuario = u.idUsuario AND r.num_episodio = :numEpisodio")
    List<co.uis.proyecto.dto.LogAuditoriaDTO> obtenerLogAuditoriaPorEpisodio(
            @org.springframework.data.repository.query.Param("numEpisodio") int numEpisodio);
}
