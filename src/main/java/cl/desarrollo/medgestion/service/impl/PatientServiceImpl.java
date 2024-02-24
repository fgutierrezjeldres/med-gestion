package cl.desarrollo.medgestion.service.impl;

import cl.desarrollo.medgestion.model.Patient;
import cl.desarrollo.medgestion.repository.IGenericRepository;
import cl.desarrollo.medgestion.repository.IPatientRepository;
import cl.desarrollo.medgestion.service.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//logica de negocio service
@Service //cuando se usa esta etiqueta se genera un bean (instancia de la clase) con singleton, se usa esta etiqueta para diferenciar los bean de tipo service
@RequiredArgsConstructor
public class PatientServiceImpl extends CRUDImpl <Patient,Integer > implements IPatientService {

    private final IPatientRepository repo;

    @Override
    protected IGenericRepository<Patient, Integer> getRepository() {
        return repo;
    }
}
