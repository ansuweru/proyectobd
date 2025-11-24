package co.uis.proyecto.controladores;

import co.uis.proyecto.dto.LogAuditoriaDTO;
import co.uis.proyecto.repositorios.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/auditoria")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistroController {

    @Autowired
    private RegistroRepository registroRepository;

    @GetMapping
    public List<LogAuditoriaDTO> getLogAuditoria() {
        return registroRepository.obtenerLogAuditoria();
    }

    @GetMapping("/episodio/{id}")
    public List<LogAuditoriaDTO> getLogAuditoriaPorEpisodio(
            @org.springframework.web.bind.annotation.PathVariable int id) {
        return registroRepository.obtenerLogAuditoriaPorEpisodio(id);
    }

    @org.springframework.web.bind.annotation.PostMapping
    public co.uis.proyecto.entidades.Registro createRegistro(
            @org.springframework.web.bind.annotation.RequestBody co.uis.proyecto.entidades.Registro registro) {
        // Auto-generate ID (simple max + 1 for now since it's in-memory H2 and not
        // auto-increment in schema)
        int maxId = registroRepository.findAll().stream().mapToInt(co.uis.proyecto.entidades.Registro::getNum_registro)
                .max().orElse(0);
        registro.setNum_registro(maxId + 1);

        // Set current timestamp if not provided
        if (registro.getFecha_hora_registro() == null) {
            java.time.LocalDateTime now = java.time.LocalDateTime.now();
            java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter
                    .ofPattern("yyyy-MM-dd HH:mm:ss");
            registro.setFecha_hora_registro(now.format(formatter));
        }

        return registroRepository.save(registro);
    }
}
