package cl.desarrollo.medgestion.controller;

import cl.desarrollo.medgestion.model.Medic;
import cl.desarrollo.medgestion.service.IMedicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/medics")
@RequiredArgsConstructor
public class MedicController {

    @Autowired
    private final IMedicService service;

   /* public MedicController(IMedicService service){
        this.service = service;
    }*/
    @GetMapping
    public ResponseEntity <List<Medic>> findAll() {
        List<Medic> list = service.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK) ;
    }

    //hateoas usa el objeto EntityModel
    @GetMapping("/hateoas/{id}")
    public EntityModel<Medic> findByIdHateoas(@PathVariable("id") Integer id){
        EntityModel<Medic> resource = EntityModel.of(service.findById(id));
        //esto genera un link informativo (esto obtiene el link del servicio  )
        WebMvcLinkBuilder linkGetFindByIDMedic = linkTo(methodOn(this.getClass()).findById(id));// no ejecuta el metodo solo obtiene el link del recurso
        resource.add(linkGetFindByIDMedic.withRel("medic-info"));
        return resource;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medic> findById(@PathVariable("id") Integer id) {
        Medic obj = service.findById(id);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PostMapping //@RequestBody recibe el json y lo convierte a clase java
    public ResponseEntity<Medic> save(@RequestBody Medic medic){
        Medic obj = service.save(medic);
        URI location  = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdMedic()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medic> update(@PathVariable("id") Integer id, @RequestBody Medic medic) {
        medic.setIdMedic(id);
        Medic obj = service.update(medic, id);
        return new ResponseEntity<>(obj, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
