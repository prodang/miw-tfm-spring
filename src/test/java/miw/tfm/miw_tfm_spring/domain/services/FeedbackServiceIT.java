package miw.tfm.miw_tfm_spring.domain.services;

import miw.tfm.miw_tfm_spring.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class FeedbackServiceIT {

    @Autowired
    private FeedbackService feedbackService;

    @Test
    void testGetListFeedbacks(){
        assertEquals(2, (int) feedbackService.readAll().count());
    }
}
