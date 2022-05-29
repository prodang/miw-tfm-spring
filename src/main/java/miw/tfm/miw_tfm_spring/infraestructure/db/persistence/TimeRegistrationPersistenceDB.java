package miw.tfm.miw_tfm_spring.infraestructure.db.persistence;

import miw.tfm.miw_tfm_spring.domain.exceptions.ConflictException;
import miw.tfm.miw_tfm_spring.domain.exceptions.NotFoundException;
import miw.tfm.miw_tfm_spring.domain.model.TimeRegistration;
import miw.tfm.miw_tfm_spring.domain.persistence.TimeRegistrationPersistence;
import miw.tfm.miw_tfm_spring.infraestructure.db.dao.TimeRegistrationDao;
import miw.tfm.miw_tfm_spring.infraestructure.db.entities.TimeRegistrationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Stream;

@Repository
public class TimeRegistrationPersistenceDB implements TimeRegistrationPersistence {

    private final TimeRegistrationDao timeRegistrationDao;

    @Autowired
    public TimeRegistrationPersistenceDB(TimeRegistrationDao timeRegistrationDao){
        this.timeRegistrationDao = timeRegistrationDao;
    }

    public TimeRegistration create(TimeRegistration timeRegistration) {
        String id = UUID.randomUUID().toString();
        timeRegistration.setId(id);
        timeRegistration.setEntry(LocalDateTime.now());
        return this.timeRegistrationDao.save(new TimeRegistrationEntity(timeRegistration)).toTimeRegistration();
    }

    public TimeRegistration updateLeave(String id) {
        if(this.timeRegistrationDao.findById(id).isEmpty()){
            throw new NotFoundException("The id doesn't exist: "+id);
        }

        TimeRegistrationEntity timeRegistrationEntity = this.timeRegistrationDao.findById(id).get();
        timeRegistrationEntity.setLeave(LocalDateTime.now());
        return this.timeRegistrationDao.save(timeRegistrationEntity).toTimeRegistration();
    }

    public Stream<TimeRegistration> findByIdEmployee(String dni) {
        return this.timeRegistrationDao.findByIdEmployee(dni);
    }

    public Stream<TimeRegistration> findAll() {
        return this.timeRegistrationDao.findAll().stream()
                .map(TimeRegistrationEntity::toTimeRegistration);
    }

    @Override
    public TimeRegistration update(String id, TimeRegistration timeRegistration) {
        this.assertIdAndModel(id, timeRegistration);

        TimeRegistrationEntity timeRegistrationEntity = this.timeRegistrationDao.findById(id).get();
        timeRegistrationEntity.setEntry(timeRegistration.getEntry());
        timeRegistrationEntity.setLeave(timeRegistration.getLeave());
        return this.timeRegistrationDao.save(timeRegistrationEntity).toTimeRegistration();
    }

    private void assertIdAndModel(String id, TimeRegistration timeRegistration){
        if(this.timeRegistrationDao.findById(id).isEmpty()){
            throw new NotFoundException("The id doesn't exist: "+id);
        }else if(!timeRegistration.getId().equals(id)){
            throw new ConflictException("The id isn't equal than id request");
        }
    }

}
