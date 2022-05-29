package miw.tfm.miw_tfm_spring.domain.services;

import miw.tfm.miw_tfm_spring.TestConfig;
import miw.tfm.miw_tfm_spring.domain.exceptions.ConflictException;
import miw.tfm.miw_tfm_spring.domain.model.Feedback;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
public class FeedbackServiceIT {

    @Autowired
    private FeedbackService feedbackService;

    @Test
    void testGetListFeedbacks(){
        assertEquals(3, (int) feedbackService.readAll().count());
    }

    @Test
    void testCreateFeedbackExisting(){
        Feedback feedback = Feedback.builder().feedback("test feedback").build();
        Feedback f1 = this.feedbackService.createFeedback(feedback);
        assertEquals("test feedback", f1.getFeedback());
    }
}
