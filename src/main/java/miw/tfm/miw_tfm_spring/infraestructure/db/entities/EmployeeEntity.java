package miw.tfm.miw_tfm_spring.infraestructure.db.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miw.tfm.miw_tfm_spring.domain.model.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class EmployeeEntity {
    @Id
    private String identifier;
    private String name;
    private String category;
    private String salary;
    private String[] comments;

    public Employee toEmployee() {
        Employee employee = new Employee();
        BeanUtils.copyProperties(this, employee);
        return employee;
    }

}
