package co.uis.proyecto.repositorios;

import co.uis.proyecto.entidades.Procedimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProcedimientoRepository extends JpaRepository<Procedimiento, Integer> {
    @Query("SELECT p FROM Procedimiento p WHERE p.numero_episodio = :numEpisodio")
    List<Procedimiento> findByNumEpisodio(@Param("numEpisodio") int numEpisodio);
}
