package miw.tfm.miw_tfm_spring.domain.services;

import miw.tfm.miw_tfm_spring.domain.model.Feedback;
import miw.tfm.miw_tfm_spring.domain.persistence.FeedbackPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class FeedbackService {

    private final FeedbackPersistence feedbackPersistence;

    @Autowired
    public FeedbackService(FeedbackPersistence feedbackPersistence){
        this.feedbackPersistence = feedbackPersistence;
    }

    public Stream<Feedback> readAll() {
        return this.feedbackPersistence.findAll().stream();
    }

    public Feedback createFeedback(Feedback feedback) {
        return this.feedbackPersistence.create(feedback);
    }
}
