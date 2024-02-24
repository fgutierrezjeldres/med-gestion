package cl.desarrollo.medgestion.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TBL_CONSULT_DETAIL")
public class ConsultDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idDetail;

    @ManyToOne
    @JoinColumn(name = "id_consult", nullable = false, foreignKey = @ForeignKey(name = "FK_CONSULT_DETAIL"))
    private Consult consult;

    @Column(nullable = false, length = 70)
    private String diagnosis;

    @Column(nullable = false, length = 300)
    private String treatment;




}
