package miw.tfm.miw_tfm_spring.infraestructure.api.resources;

import miw.tfm.miw_tfm_spring.domain.model.TimeRegistration;
import miw.tfm.miw_tfm_spring.domain.services.TimeRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Stream;

@RestController
@RequestMapping(TimeRegistrationResource.REGISTRATIONS)
public class TimeRegistrationResource {
    public static final String REGISTRATIONS = "/registrations";
    public static final String ID_ID = "/{id}";
    public static final String LEAVE = "/leave";
    public static final String SEARCH = "/search";

    private final TimeRegistrationService timeRegistrationService;

    @Autowired
    public TimeRegistrationResource(TimeRegistrationService timeRegistrationService){
        this.timeRegistrationService = timeRegistrationService;
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping
    public TimeRegistration create(@Valid @RequestBody TimeRegistration timeRegistration){
        return this.timeRegistrationService.create(timeRegistration);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PatchMapping(ID_ID+LEAVE)
    public TimeRegistration updateLeave(@PathVariable String id){
        return this.timeRegistrationService.updateLeave(id);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping(ID_ID)
    public Stream<TimeRegistration> findById(@PathVariable String id){
        return this.timeRegistrationService.findByIdEmployee(id);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(SEARCH)
    public Stream<TimeRegistration> findAll(){
        return this.timeRegistrationService.findAll();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping(ID_ID)
    public TimeRegistration update(@PathVariable String id, @Valid @RequestBody TimeRegistration timeRegistration){
        return this.timeRegistrationService.update(id, timeRegistration);
    }
}
