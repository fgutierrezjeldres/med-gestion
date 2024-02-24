package cl.desarrollo.medgestion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data //  getter, setter, equalsandhashcode, tostring
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true) //
@Table(name = "tbl_specialty")
public class Specialty {

    //en caso de tener bases de datos no estan bien relacionadas no es recomendable usar spring jpa
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idSpecialty;

    @Column(nullable = false, length = 80)
    private String name;

    @Column(nullable = false, length = 150)
    private String description;

}
