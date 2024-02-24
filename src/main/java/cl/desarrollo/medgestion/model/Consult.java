package cl.desarrollo.medgestion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data //  getter, setter, equalsandhashcode, tostring
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true) //
@Table(name = "tbl_consult")
public class Consult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idConsult;

    @ManyToOne //si se quiere referenciar a otra tabla se usa este
    @JoinColumn(name = "id_patient", nullable = false, foreignKey = @ForeignKey(name = "FK_CONSULT_PATIENT"))
    private Patient patient;

    @ManyToOne //si se quiere referenciar a otra tabla se usa este
    @JoinColumn(name = "id_medic", nullable = false, foreignKey = @ForeignKey(name = "FK_CONSULT_MEDIC"))
    private Medic medic;

    @ManyToOne //si se quiere referenciar a otra tabla se usa este
    @JoinColumn(name = "id_specialty", nullable = false, foreignKey = @ForeignKey(name = "FK_CONSULT_SPECIALTY"))
    private Specialty specialty;

    @Column(length = 3, nullable = false)
    private String numConsult;

    private LocalDateTime consultDate;


    //principios acid ... principio motor de base de datos relacional
    /*
    atomicidad, consistencia, aislamiento, durabilidad
    * */
    /*orpan removal true es cuando se podria eliminar un registro  */
    /*lazy no trae la data poblada, eager esta la data poblada*/
    @OneToMany(mappedBy = "consult", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)// lo que le pase a la cabecera tambien le pasa al detalle si se elimnina la cabecera se elimina el detalle
    private List<ConsultDetail> details;


}
