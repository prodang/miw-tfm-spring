package miw.tfm.miw_tfm_spring.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TimeRegistration {
    @Id
    private String id;
    private LocalDateTime entryHour;
    private LocalDateTime leaveHour;
    private String idEmployee;
}
