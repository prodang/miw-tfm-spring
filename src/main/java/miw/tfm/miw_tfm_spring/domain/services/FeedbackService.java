package miw.tfm.miw_tfm_spring.domain.services;

import miw.tfm.miw_tfm_spring.domain.persistence.FeedbackPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    private final FeedbackPersistence feedbackPersistence;

    @Autowired
    public FeedbackService(FeedbackPersistence feedbackPersistence){
        this.feedbackPersistence = feedbackPersistence;
    }
}
