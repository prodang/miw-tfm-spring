package miw.tfm.miw_tfm_spring.infraestructure.db.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miw.tfm.miw_tfm_spring.domain.model.TimeRegistration;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class TimeRegistrationEntity {
    @Id
    private String id;
    private LocalDateTime entryHour;
    private LocalDateTime leaveHour;
    private String idEmployee;

    public TimeRegistrationEntity(TimeRegistration timeRegistration){
        BeanUtils.copyProperties(timeRegistration, this);
    }

    public TimeRegistration toTimeRegistration(){
        TimeRegistration timeRegistration = new TimeRegistration();
        BeanUtils.copyProperties(this, timeRegistration);
        return timeRegistration;
    }
}
