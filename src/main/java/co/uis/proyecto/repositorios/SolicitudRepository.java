package co.uis.proyecto.repositorios;

import co.uis.proyecto.entidades.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {
}
