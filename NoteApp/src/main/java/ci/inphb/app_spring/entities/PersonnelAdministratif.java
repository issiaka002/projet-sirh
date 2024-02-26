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
@DiscriminatorValue(value = "ADMIS")
public class PersonnelAdministratif extends Employe{

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Service service;

}
