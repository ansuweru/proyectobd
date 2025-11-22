package co.uis.proyecto.repositorios;

import co.uis.proyecto.entidades.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosticoRepository extends JpaRepository<Diagnostico,Integer> {
}
