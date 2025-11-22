package co.uis.proyecto.repositorios;

import co.uis.proyecto.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,Integer> {
}
