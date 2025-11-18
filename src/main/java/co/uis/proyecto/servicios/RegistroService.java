package co.uis.proyecto.servicios;

import co.uis.proyecto.entidades.Registro;
import co.uis.proyecto.repositorios.RegistroRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.model.internal.PersistentAttributeFilter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service@RequiredArgsConstructor
public class RegistroService {
    private final RegistroRepository repo;

    public List<Registro> listar(){return repo.findAll();}
    public Registro obtener(int num_registro){
        return repo.findById(num_registro).orElseThrow(()->new EntityNotFoundException("Registro no encontrado"));
    }
    @Transactional
    public Registro crear(Registro r){return repo.save(r);}

    @Transactional
    public Registro actualizar(Integer num_registro, Registro r){
        Registro a = obtener(num_registro);
        a.setNum_historia(r.getNum_historia());
        a.setNum_usuario(r.getNum_usuario());
        a.setFecha(r.getFecha());
        a.setHora(r.getHora());

    }
}
