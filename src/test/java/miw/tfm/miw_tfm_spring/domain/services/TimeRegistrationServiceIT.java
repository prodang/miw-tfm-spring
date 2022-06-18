package miw.tfm.miw_tfm_spring.domain.services;

import miw.tfm.miw_tfm_spring.TestConfig;
import miw.tfm.miw_tfm_spring.domain.model.TimeRegistration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.stream.Collectors;

@TestConfig
public class TimeRegistrationServiceIT {

    @Autowired
    private TimeRegistrationService timeRegistrationService;

    @Test
    @Transactional
    void testAllMethods(){

        LocalDateTime previousLeaveTime = LocalDateTime.of(2015, Month.JULY, 29, 9, 30, 40);

        TimeRegistration timeRegistration = TimeRegistration.builder()
                .id("--")
                .entryHour(LocalDateTime.now())
                .leaveHour(previousLeaveTime)
                .idEmployee("--")
                .build();
        this.timeRegistrationService.create(timeRegistration);
        assertEquals(1, (int) this.timeRegistrationService.findByIdEmployee("--").stream().count());

        String id = this.timeRegistrationService.findByIdEmployee("--").get(0).getId();
        this.timeRegistrationService.updateLeave(id);
        assertNotEquals(this.timeRegistrationService.findByIdEmployee("--").get(0).getLeaveHour(), previousLeaveTime);

        TimeRegistration timeToUpdate = TimeRegistration.builder()
                .id(id)
                .entryHour(LocalDateTime.of(2022, Month.JANUARY, 29, 9, 30, 40))
                .leaveHour(LocalDateTime.of(2022, Month.JANUARY, 29, 19, 30, 0))
                .idEmployee("--")
                .build();
        this.timeRegistrationService.update(id, timeToUpdate);
        assertEquals(LocalDateTime.of(2022, Month.JANUARY, 29, 9, 30, 40),
                this.timeRegistrationService.findByIdEmployee("--")
                .get(0).getEntryHour()
                );
        assertEquals(LocalDateTime.of(2022, Month.JANUARY, 29, 19, 30, 0),
                this.timeRegistrationService.findByIdEmployee("--").get(0).getLeaveHour()
                );

         assertTrue(this.timeRegistrationService.findAll().count() > 2);
    }

}
