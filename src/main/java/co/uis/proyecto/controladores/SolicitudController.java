package co.uis.proyecto.controladores;

import co.uis.proyecto.entidades.Solicitud;
import co.uis.proyecto.repositorios.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
@CrossOrigin(origins = "http://localhost:4200")
public class SolicitudController {

    @Autowired
    private SolicitudRepository solicitudRepository;

    @GetMapping("/paciente/{cedula}")
    public List<Solicitud> getSolicitudesByPaciente(@PathVariable Long cedula) {
        return solicitudRepository.findByCedula(cedula);
    }

    @PostMapping
    public Solicitud createSolicitud(@RequestBody Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }
}
