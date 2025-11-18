package co.uis.proyecto.repositorios;

import co.uis.proyecto.entidades.Historia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoriaRepository extends JpaRepository<Historia,Integer> {
}
