package ci.inphb.app_spring.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@DiscriminatorValue(value = "ENSG")
public class Enseignant extends Employe{

    //@Column(nullable = false)
    private String domaine;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Ecole ecole;
}
