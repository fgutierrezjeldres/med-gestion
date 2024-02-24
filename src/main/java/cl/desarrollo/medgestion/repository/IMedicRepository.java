package cl.desarrollo.medgestion.repository;

import cl.desarrollo.medgestion.model.Medic;
import cl.desarrollo.medgestion.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository  si la interfaz extiende de jpaRepository no es necesario agregar esta etiqueta ya que JpaRepository ya la trae
public interface IMedicRepository extends IGenericRepository<Medic, Integer> {


}
