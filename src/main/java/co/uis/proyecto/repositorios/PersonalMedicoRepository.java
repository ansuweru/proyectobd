package co.uis.proyecto.repositorios;

import co.uis.proyecto.entidades.PersonalMedico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalMedicoRepository extends JpaRepository<PersonalMedico,Integer> {
}
