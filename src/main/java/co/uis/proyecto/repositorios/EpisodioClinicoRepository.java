package co.uis.proyecto.repositorios;

import co.uis.proyecto.entidades.EpisodioClinico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EpisodioClinicoRepository extends JpaRepository<EpisodioClinico, Integer> {
    List<EpisodioClinico> findByCedula(Long cedula);

    // JOIN #1: Historial del Paciente (Paciente + Episodio + Medico)
    @Query("SELECT new co.uis.proyecto.dto.HistoriaClinicaDTO(e, p, m.nombre_completo) " +
            "FROM EpisodioClinico e, Paciente p, PersonalMedico m " +
            "WHERE e.cedula = p.cedula AND e.id_medico = m.id_medico AND p.cedula = :cedula")
    List<co.uis.proyecto.dto.HistoriaClinicaDTO> obtenerHistorialCompleto(@Param("cedula") Long cedula);

    // JOIN #2: Detalle Episodio (Episodio + Diagnostico + Procedimiento)
    @Query("SELECT new co.uis.proyecto.dto.DetalleEpisodioDTO(e.num_episodio, e.fecha_apertura, e.motivo_consulta, d.descripcion, proc.nombre_procedimiento) "
            +
            "FROM EpisodioClinico e " +
            "LEFT JOIN Diagnostico d ON e.num_episodio = d.num_episodio " +
            "LEFT JOIN Procedimiento proc ON e.num_episodio = proc.numero_episodio " +
            "WHERE e.num_episodio = :numEpisodio")
    List<co.uis.proyecto.dto.DetalleEpisodioDTO> obtenerDetalleCompleto(@Param("numEpisodio") int numEpisodio);
}
