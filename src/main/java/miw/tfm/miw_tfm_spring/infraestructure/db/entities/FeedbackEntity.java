package miw.tfm.miw_tfm_spring.infraestructure.db.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miw.tfm.miw_tfm_spring.domain.model.Feedback;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class FeedbackEntity {
    @Id
    private String identifier;
    private String feedback;

    public FeedbackEntity(Feedback feedback) {
        BeanUtils.copyProperties(feedback, this);
    }

    public Feedback toFeedback(FeedbackEntity feedbackEntity) {
        Feedback feedback = new Feedback();
        BeanUtils.copyProperties(this, feedback);
        return feedback;
    }

    public Feedback toFeedback() {
        Feedback feedback = new Feedback();
        BeanUtils.copyProperties(this, feedback);
        return feedback;
    }
}
