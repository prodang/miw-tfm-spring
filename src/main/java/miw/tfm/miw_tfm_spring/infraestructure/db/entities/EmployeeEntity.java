package miw.tfm.miw_tfm_spring.infraestructure.db.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miw.tfm.miw_tfm_spring.domain.model.Employee;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class EmployeeEntity {
    @Id
    private String identifier;
    private String name;
    private String category;
    private String salary;
    private String[] comments;

    public EmployeeEntity(Employee employee){
        BeanUtils.copyProperties(employee, this);
    }

    public Employee toEmployee() {
        Employee employee = new Employee();
        BeanUtils.copyProperties(this, employee);
        return employee;
    }

}
