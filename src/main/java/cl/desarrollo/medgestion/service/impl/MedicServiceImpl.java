package cl.desarrollo.medgestion.service.impl;

import cl.desarrollo.medgestion.model.Medic;
import cl.desarrollo.medgestion.repository.IGenericRepository;
import cl.desarrollo.medgestion.repository.IMedicRepository;
import cl.desarrollo.medgestion.service.IMedicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//logica de negocio service
@Service //cuando se usa esta etiqueta se genera un bean (instancia de la clase) con singleton, se usa esta etiqueta para diferenciar los bean de tipo service
@RequiredArgsConstructor
public class MedicServiceImpl extends CRUDImpl <Medic,Integer > implements IMedicService {

    private final IMedicRepository repo;

    @Override
    protected IGenericRepository<Medic, Integer> getRepository() {
        return repo;
    }
}


