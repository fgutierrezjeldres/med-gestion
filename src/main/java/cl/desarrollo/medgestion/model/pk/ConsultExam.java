package cl.desarrollo.medgestion.model.pk;

import cl.desarrollo.medgestion.model.Consult;
import cl.desarrollo.medgestion.model.Exam;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_consult_exam")
@IdClass(ConsultExamPK.class)
public class ConsultExam {

    @Id
    private Consult consult;

    @Id
    private Exam exam;
}
