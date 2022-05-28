package miw.tfm.miw_tfm_spring.infraestructure.api.resources;

import miw.tfm.miw_tfm_spring.domain.model.Feedback;
import miw.tfm.miw_tfm_spring.domain.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(FeedbackResource.FEEDBACKS)
public class FeedbackResource {
    public static final String FEEDBACKS = "/feedbacks";
    public static final String SEARCH = "/search";

    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackResource(FeedbackService feedbackService){
        this.feedbackService = feedbackService;
    }

    @GetMapping(SEARCH)
    public Stream<Feedback> readAll(){
        return this.feedbackService.readAll();
    }
}
