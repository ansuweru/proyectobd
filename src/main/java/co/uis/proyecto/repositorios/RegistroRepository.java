package co.uis.proyecto.repositorios;

import co.uis.proyecto.entidades.Registro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroRepository extends JpaRepository<Registro,Integer> {
}
