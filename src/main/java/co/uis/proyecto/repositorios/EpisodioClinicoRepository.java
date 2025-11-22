package co.uis.proyecto.repositorios;

import co.uis.proyecto.entidades.EpisodioClinico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EpisodioClinicoRepository extends JpaRepository<EpisodioClinico, Integer> {
    List<EpisodioClinico> findByCedula(Long cedula);
}
