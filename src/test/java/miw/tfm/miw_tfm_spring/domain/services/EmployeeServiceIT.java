package miw.tfm.miw_tfm_spring.domain.services;

import miw.tfm.miw_tfm_spring.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class EmployeeServiceIT {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void testListaEmployees(){
        assertEquals(2, employeeService.readAll().collect(Collectors.toList()).size());
    }
}
