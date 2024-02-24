package cl.desarrollo.medgestion.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data //  getter, setter, equalsandhashcode, tostring
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true) //
@Table(name = "tbl_patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include //  esto permite generar si este id e igual manejarlo como si fuera la misma clase si son disintas se tratara como si fuera una clase distinta
    private Integer idPatient;
    @Column(length = 70, nullable = false)
    private String firstName;
    @Column(length = 10, nullable = false)
    private String rut;
    @Column(length = 10, nullable = false)
    private String phone;
    @Column(length = 150, nullable = false)
    private String email;
    @Column(length = 70, nullable = false)
    private String lastName;
    @Column(length = 150, nullable = false)
    private String address;
}
