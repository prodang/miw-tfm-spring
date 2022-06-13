package miw.tfm.miw_tfm_spring.infraestructure.api.resources;

import miw.tfm.miw_tfm_spring.domain.model.Feedback;
import miw.tfm.miw_tfm_spring.domain.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Stream;

@PreAuthorize("hasAuthority('ROLE_USER')")
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

    @PostMapping
    public Feedback createFeedback(@Valid @RequestBody Feedback feedback){
        return this.feedbackService.createFeedback(feedback);
    }
}
