package miw.tfm.miw_tfm_spring.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Employee {
    @Id
    private String identifier;
    private String name;
    private String category;
    private String salary;
    private String[] comments;
}
