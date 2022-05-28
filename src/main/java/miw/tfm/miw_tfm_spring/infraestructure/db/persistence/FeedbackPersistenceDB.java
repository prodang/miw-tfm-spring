package miw.tfm.miw_tfm_spring.infraestructure.db.persistence;

import miw.tfm.miw_tfm_spring.infraestructure.db.dao.FeedbackDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FeedbackPersistenceDB {

    private final FeedbackDao feedbackDao;

    @Autowired
    public FeedbackPersistenceDB(FeedbackDao feedbackDao){
        this.feedbackDao = feedbackDao;
    }
}
