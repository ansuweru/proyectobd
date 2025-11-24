package co.uis.proyecto.controladores;

import co.uis.proyecto.entidades.EpisodioClinico;
import co.uis.proyecto.repositorios.EpisodioClinicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/episodios")
@CrossOrigin(origins = "http://localhost:4200")
public class EpisodioClinicoController {

    @Autowired
    private EpisodioClinicoRepository episodioRepository;

    @GetMapping("/paciente/{cedula}")
    public ResponseEntity<List<EpisodioClinico>> getEpisodiosByPaciente(@PathVariable Long cedula) {
        List<EpisodioClinico> episodios = episodioRepository.findByCedula(cedula);
        return ResponseEntity.ok(episodios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EpisodioClinico> getEpisodio(@PathVariable int id) {
        Optional<EpisodioClinico> episodio = episodioRepository.findById(id);
        return episodio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public EpisodioClinico createEpisodio(@RequestBody EpisodioClinico episodio) {
        return episodioRepository.save(episodio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EpisodioClinico> updateEpisodio(@PathVariable int id,
            @RequestBody EpisodioClinico episodioDetails) {
        return episodioRepository.findById(id).map(episodio -> {
            episodio.setMotivo_consulta(episodioDetails.getMotivo_consulta());
            episodio.setAnamnesis(episodioDetails.getAnamnesis());
            episodio.setPlan_manejo(episodioDetails.getPlan_manejo());
            episodio.setEstado(episodioDetails.getEstado());
            return ResponseEntity.ok(episodioRepository.save(episodio));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEpisodio(@PathVariable int id) {
        if (episodioRepository.existsById(id)) {
            episodioRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/historial-completo/{cedula}")
    public List<co.uis.proyecto.dto.HistoriaClinicaDTO> getHistorialCompleto(@PathVariable Long cedula) {
        return episodioRepository.obtenerHistorialCompleto(cedula);
    }

    @GetMapping("/detalle-completo/{id}")
    public List<co.uis.proyecto.dto.DetalleEpisodioDTO> getDetalleCompleto(@PathVariable int id) {
        return episodioRepository.obtenerDetalleCompleto(id);
    }

    @Autowired
    private co.uis.proyecto.repositorios.DiagnosticoRepository diagnosticoRepository;

    @Autowired
    private co.uis.proyecto.repositorios.ProcedimientoRepository procedimientoRepository;

    @GetMapping("/{id}/diagnosticos")
    public List<co.uis.proyecto.entidades.Diagnostico> getDiagnosticos(@PathVariable int id) {
        return diagnosticoRepository.findByNumEpisodio(id);
    }

    @GetMapping("/{id}/procedimientos")
    public List<co.uis.proyecto.entidades.Procedimiento> getProcedimientos(@PathVariable int id) {
        return procedimientoRepository.findByNumEpisodio(id);
    }
}
