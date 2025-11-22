package co.uis.proyecto.repositorios;

import co.uis.proyecto.entidades.Procedimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedimientoRepository extends JpaRepository<Procedimiento,Integer> {
}
