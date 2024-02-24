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
@Table(name = "tbl_medic")
public class Medic {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idMedic;

    @Column(nullable = false, length = 70)
    private String firstName;
    @Column(nullable = false, length = 70)
    private String lastName;
    @Column(nullable = false, length = 12)
    private String code;
    // por defecto toma 255
    private String photoUrl;



}
