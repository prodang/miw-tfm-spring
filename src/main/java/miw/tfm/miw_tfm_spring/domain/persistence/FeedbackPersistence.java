package miw.tfm.miw_tfm_spring.domain.persistence;

import miw.tfm.miw_tfm_spring.domain.model.Feedback;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FeedbackPersistence {
    List<Feedback> findAll();

    Feedback create(Feedback feedback);
}
