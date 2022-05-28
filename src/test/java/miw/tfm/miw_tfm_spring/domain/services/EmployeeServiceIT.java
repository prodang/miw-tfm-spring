package miw.tfm.miw_tfm_spring.domain.services;

import miw.tfm.miw_tfm_spring.TestConfig;
import miw.tfm.miw_tfm_spring.domain.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class EmployeeServiceIT {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void testGetListEmployees(){
        assertEquals(2, employeeService.readAll().collect(Collectors.toList()).size());
    }

    @Test
    void testGetEmployeeById(){
        Employee employee = this.employeeService.readById("2");
        assertEquals("Name 2",employee.getName());
        assertEquals("Category 2", employee.getCategory());
        assertEquals("2", employee.getSalary());
    }

    @Test
    void testCreateEmployee(){

        String[] pruebaa = {"prueba", "pruebaa"};
        Employee employeeCreation = Employee.builder().name("probando").identifier("00000000").category("00000000").salary("00000000").comments(pruebaa).build();
        this.employeeService.createEmployee(employeeCreation);
        Employee employee = this.employeeService.readById("00000000");
        assertEquals("probando",employee.getName());
        assertEquals("00000000", employee.getCategory());
        assertEquals("00000000", employee.getSalary());
        assertEquals("prueba", employee.getComments()[0]);
    }
}
