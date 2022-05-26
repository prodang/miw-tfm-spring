package miw.tfm.miw_tfm_spring.infraestructure.api.resources;

import miw.tfm.miw_tfm_spring.domain.model.Employee;
import miw.tfm.miw_tfm_spring.domain.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping(EmployeeResource.EMPLOYEES)
public class EmployeeResource {
    public static final String EMPLOYEES = "/employees";
    public static final String SEARCH = "/search";
    public static final String ID_ID = "/{id}";

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeResource(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping(SEARCH)
    public Stream<Employee> readAll(){
        return this.employeeService.readAll();
    }

    @GetMapping(ID_ID)
    public Employee readById(@PathVariable String id){
        return this.employeeService.readById(id);
    }

}
