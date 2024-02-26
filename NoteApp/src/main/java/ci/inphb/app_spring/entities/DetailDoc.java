package ci.inphb.app_spring.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class DetailDoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetailDoc;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateDelivre;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private DocAdministratif docAdmintratif;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Employe employe;

}
