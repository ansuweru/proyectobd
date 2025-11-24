package co.uis.proyecto.controladores;

import co.uis.proyecto.entidades.Paciente;
import co.uis.proyecto.repositorios.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "http://localhost:4200")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    @PostMapping
    public Paciente createPaciente(@RequestBody Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @PutMapping("/{cedula}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable Long cedula, @RequestBody Paciente pacienteDetails) {
        return pacienteRepository.findById(cedula).map(paciente -> {
            paciente.setNombre(pacienteDetails.getNombre());
            paciente.setFecha_nacimiento(pacienteDetails.getFecha_nacimiento());
            paciente.setGenero(pacienteDetails.getGenero());
            paciente.setDireccion(pacienteDetails.getDireccion());
            return ResponseEntity.ok(pacienteRepository.save(paciente));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{cedula}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Long cedula) {
        if (pacienteRepository.existsById(cedula)) {
            pacienteRepository.deleteById(cedula);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<Paciente> getPaciente(@PathVariable Long cedula) {
        Optional<Paciente> paciente = pacienteRepository.findById(cedula);
        return paciente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
