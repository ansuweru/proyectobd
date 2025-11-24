package co.uis.proyecto.repositorios;

import co.uis.proyecto.entidades.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DiagnosticoRepository extends JpaRepository<Diagnostico, Integer> {
    @Query("SELECT d FROM Diagnostico d WHERE d.num_episodio = :numEpisodio")
    List<Diagnostico> findByNumEpisodio(@Param("numEpisodio") int numEpisodio);
}
