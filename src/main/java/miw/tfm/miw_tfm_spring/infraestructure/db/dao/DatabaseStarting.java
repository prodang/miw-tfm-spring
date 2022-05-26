package miw.tfm.miw_tfm_spring.infraestructure.db.dao;

import miw.tfm.miw_tfm_spring.infraestructure.db.entities.EmployeeEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DatabaseStarting {

    private final EmployeeDao employeeDao;

    @Autowired
    public DatabaseStarting(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
        this.initialize();
    }

    void initialize() {
        EmployeeEntity employeeEntity = EmployeeEntity.builder().identifier("1").name("Name").category("Category 1").salary("1").comments(null).build();
        EmployeeEntity employeeEntity2 = EmployeeEntity.builder().identifier("2").name("Name 2").category("Category 2").salary("2").comments(null).build();
        this.employeeDao.save(employeeEntity);
        this.employeeDao.save(employeeEntity2);
        LogManager.getLogger(this.getClass()).warn("------- Create Employees Various -----------");
    }
}
