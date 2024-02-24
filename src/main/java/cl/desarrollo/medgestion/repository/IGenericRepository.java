package cl.desarrollo.medgestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

//datos genericos
//cuando se usa genericos hay que usar la etiqueta norepositorybean para evitar que se genere el bean en esta  interfaz generica(<T, ID> )

@NoRepositoryBean
public interface IGenericRepository<T, ID> extends JpaRepository<T, ID> {
}
