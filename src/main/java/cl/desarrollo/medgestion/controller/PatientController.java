package cl.desarrollo.medgestion.controller;

import cl.desarrollo.medgestion.model.Patient;
import cl.desarrollo.medgestion.service.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//hateoas
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    @Autowired
    private final IPatientService service;

   /* public PatientController(IPatientService service){
        this.service = service;
    }*/
    @GetMapping
    public ResponseEntity <List<Patient>> findAll() {
        List<Patient> list = service.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK) ;
    }

    //hateoas usa el objeto EntityModel
    @GetMapping("/hateoas/{id}")
    public EntityModel<Patient> findByIdHateoas(@PathVariable("id") Integer id){
        EntityModel<Patient> resource = EntityModel.of(service.findById(id));
        //esto genera un link informativo (esto obtiene el link del servicio  )
        WebMvcLinkBuilder linkGetFindByIDPatient = linkTo(methodOn(this.getClass()).findById(id));// no ejecuta el metodo solo obtiene el link del recurso
        resource.add(linkGetFindByIDPatient.withRel("patient-info"));
        return resource;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findById(@PathVariable("id") Integer id) {
        Patient obj = service.findById(id);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PostMapping //@RequestBody recibe el json y lo convierte a clase java
    public ResponseEntity<Patient> save(@RequestBody Patient patient){
        Patient obj = service.save(patient);
        URI location  = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPatient()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> update(@PathVariable("id") Integer id, @RequestBody Patient patient) {
        patient.setIdPatient(id);
        Patient obj = service.update(patient, id);
        return new ResponseEntity<>(obj, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
