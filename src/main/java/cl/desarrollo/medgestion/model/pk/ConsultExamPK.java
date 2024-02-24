package cl.desarrollo.medgestion.model.pk;

import cl.desarrollo.medgestion.model.Consult;
import cl.desarrollo.medgestion.model.Exam;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
public class ConsultExamPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_consult")
    private Consult consult;

    @ManyToOne
    @JoinColumn(name = "id_exam")
    private Exam exam;

}
