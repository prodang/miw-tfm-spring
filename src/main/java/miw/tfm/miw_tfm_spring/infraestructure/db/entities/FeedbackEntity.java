package miw.tfm.miw_tfm_spring.infraestructure.db.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class FeedbackEntity {
    @Id
    private String identifier;
    private String feedback;
}
