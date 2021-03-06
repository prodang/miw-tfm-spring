package miw.tfm.miw_tfm_spring.infraestructure.api.resources;

import miw.tfm.miw_tfm_spring.domain.model.Employee;
import miw.tfm.miw_tfm_spring.domain.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;
import javax.transaction.Transactional;
import javax.validation.Valid;

@PreAuthorize("hasAuthority('ROLE_ADMIN')")
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

    @GetMapping(SEARCH + ID_ID)
    @Transactional
    public Stream<Employee> searchById(@PathVariable String id){
        return this.employeeService.searchById(id);
    }

    @PostMapping
    public Employee createEmployee(@Valid @RequestBody Employee employee){
        return this.employeeService.createEmployee(employee);
    }

    @DeleteMapping(ID_ID)
    public void deleteEmployee(@PathVariable String id){
         this.employeeService.deleteEmployee(id);
    }

    @PutMapping(ID_ID)
    public Employee updateEmployee(@PathVariable String id, @Valid @RequestBody Employee employee){
        return this.employeeService.updateEmployee(id, employee);
    }

}
