package miw.tfm.miw_tfm_spring.infraestructure.db.persistence;

import miw.tfm.miw_tfm_spring.domain.exceptions.ConflictException;
import miw.tfm.miw_tfm_spring.domain.model.Feedback;
import miw.tfm.miw_tfm_spring.domain.persistence.FeedbackPersistence;
import miw.tfm.miw_tfm_spring.infraestructure.db.dao.FeedbackDao;
import miw.tfm.miw_tfm_spring.infraestructure.db.entities.FeedbackEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FeedbackPersistenceDB implements FeedbackPersistence {

    private final FeedbackDao feedbackDao;

    @Autowired
    public FeedbackPersistenceDB(FeedbackDao feedbackDao){
        this.feedbackDao = feedbackDao;
    }

    @Override
    public List<Feedback> findAll() {
        return this.feedbackDao.findAll().stream()
                .map(feedbackEntity -> feedbackEntity.toFeedback(feedbackEntity))
                .collect(Collectors.toList());
    }

    @Override
    public Feedback create(Feedback feedback) {
        if(this.feedbackDao.findById(feedback.getIdentifier()).isPresent()){
            throw new ConflictException("The identifier already exists: " + feedback.getIdentifier());
        }
        return this.feedbackDao.save(new FeedbackEntity(feedback)).toFeedback();
    }
}
