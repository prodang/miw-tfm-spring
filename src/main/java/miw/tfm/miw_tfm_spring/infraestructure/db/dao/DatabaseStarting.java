package miw.tfm.miw_tfm_spring.infraestructure.db.dao;

import miw.tfm.miw_tfm_spring.infraestructure.db.entities.EmployeeEntity;
import miw.tfm.miw_tfm_spring.infraestructure.db.entities.FeedbackEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DatabaseStarting {

    private final EmployeeDao employeeDao;
    private final FeedbackDao feedbackDao;

    @Autowired
    public DatabaseStarting(EmployeeDao employeeDao, FeedbackDao feedbackDao){
        this.employeeDao = employeeDao;
        this.feedbackDao = feedbackDao;
        this.initialize();
    }

    void initialize() {
        String[] comments = {"comentario1", "comentario2"};
        String[] comments2 ={};
        EmployeeEntity employeeEntity = EmployeeEntity.builder().identifier("1").name("Name").category("Category 1").salary("1").comments(comments2).build();
        EmployeeEntity employeeEntity2 = EmployeeEntity.builder().identifier("2").name("Name 2").category("Category 2").salary("2").comments(comments).build();
        this.employeeDao.save(employeeEntity);
        this.employeeDao.save(employeeEntity2);
        LogManager.getLogger(this.getClass()).warn("------- Create Employees Various -----------");

        FeedbackEntity feedbackEntity = FeedbackEntity.builder().identifier("1").feedback("I want more free hours.").build();
        this.feedbackDao.save(feedbackEntity);
        FeedbackEntity feedbackEntity2 = FeedbackEntity.builder().identifier("2").feedback("I want higher salary.").build();
        this.feedbackDao.save(feedbackEntity2);
        LogManager.getLogger(this.getClass()).warn("------- Create Feedbacks Various -----------");
    }
}
