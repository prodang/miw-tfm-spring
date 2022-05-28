package miw.tfm.miw_tfm_spring.infraestructure.api.resources;

import miw.tfm.miw_tfm_spring.domain.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(FeedbackResource.FEEDBACKS)
public class FeedbackResource {
    public static final String FEEDBACKS = "/feedbacks";

    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackResource(FeedbackService feedbackService){
        this.feedbackService = feedbackService;
    }
}
