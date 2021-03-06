package miw.tfm.miw_tfm_spring.infraestructure.db.dao;

import miw.tfm.miw_tfm_spring.infraestructure.db.entities.EmployeeEntity;
import miw.tfm.miw_tfm_spring.infraestructure.db.entities.FeedbackEntity;
import miw.tfm.miw_tfm_spring.infraestructure.db.entities.TimeRegistrationEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;

@Repository
public class DatabaseStarting {

    private final EmployeeDao employeeDao;
    private final FeedbackDao feedbackDao;
    private final TimeRegistrationDao timeRegistrationDao;

    @Autowired
    public DatabaseStarting(EmployeeDao employeeDao, FeedbackDao feedbackDao, TimeRegistrationDao timeRegistrationDao){
        this.employeeDao = employeeDao;
        this.feedbackDao = feedbackDao;
        this.timeRegistrationDao = timeRegistrationDao;
        this.initialize();
    }

    void initialize() {
        String[] comments = {"comentario1", "comentario2"};
        String[] comments2 ={};
        EmployeeEntity employeeEntity = EmployeeEntity.builder().identifier("peramt.pro09@gmail.com").name("Name 1").category("Category 1").salary("1").comments(comments2).build();
        EmployeeEntity employeeEntity2 = EmployeeEntity.builder().identifier("2").name("Name 2").category("Category 2").salary("2").comments(comments).build();
        EmployeeEntity employeeEntity3 = EmployeeEntity.builder().identifier("3").name("Sergio Merayo Alba").category("Category 3").salary("100000").comments(comments2).build();
        this.employeeDao.save(employeeEntity);
        this.employeeDao.save(employeeEntity2);
        this.employeeDao.save(employeeEntity3);
        LogManager.getLogger(this.getClass()).warn("------- Create Employees Various -----------");

        FeedbackEntity feedbackEntity = FeedbackEntity.builder().identifier("1").feedback("I want more free hours.").build();
        this.feedbackDao.save(feedbackEntity);
        FeedbackEntity feedbackEntity2 = FeedbackEntity.builder().identifier("2").feedback("I want higher salary.").build();
        this.feedbackDao.save(feedbackEntity2);
        LogManager.getLogger(this.getClass()).warn("------- Create Feedbacks Various -----------");

        TimeRegistrationEntity timeRegistrationEntity = TimeRegistrationEntity.builder()
                .id("1")
                .entryHour(LocalDateTime.of(2015, Month.JULY, 1, 7, 30, 40))
                .leaveHour(LocalDateTime.of(2015, Month.JULY, 1, 15, 30, 50))
                .idEmployee("peramt.pro09@gmail.com")
                .build();
        this.timeRegistrationDao.save(timeRegistrationEntity);
        TimeRegistrationEntity timeRegistrationEntity2 = TimeRegistrationEntity.builder()
                .id("2")
                .entryHour(LocalDateTime.of(2015, Month.JULY, 30, 9, 30, 40))
                .leaveHour(LocalDateTime.of(2015, Month.JULY, 30, 18, 30, 0))
                .idEmployee("2")
                .build();
        this.timeRegistrationDao.save(timeRegistrationEntity2);
        TimeRegistrationEntity timeRegistrationEntity3 = TimeRegistrationEntity.builder()
                .id("3")
                .entryHour(LocalDateTime.of(2015, Month.JULY, 2, 8, 30, 40))
                .leaveHour(LocalDateTime.of(2015, Month.JULY, 2, 14, 30, 40))
                .idEmployee("peramt.pro09@gmail.com")
                .build();
        this.timeRegistrationDao.save(timeRegistrationEntity3);
        TimeRegistrationEntity timeRegistrationEntity4 = TimeRegistrationEntity.builder()
                .id("4")
                .entryHour(LocalDateTime.of(2015, Month.JULY, 2, 15, 30, 40))
                .leaveHour(LocalDateTime.of(2015, Month.JULY, 2, 17, 30, 50))
                .idEmployee("peramt.pro09@gmail.com")
                .build();
        this.timeRegistrationDao.save(timeRegistrationEntity4);
        LogManager.getLogger(this.getClass()).warn("------- Create Time Registration Various -----------");
    }
}
