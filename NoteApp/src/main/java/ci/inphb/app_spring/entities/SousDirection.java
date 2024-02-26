package ci.inphb.app_spring.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class SousDirection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSousDirection;
    private String libelle;

    @OneToMany(mappedBy = "sousDirection")
    private List<Service> services;

    @ManyToOne
    private Direction direction;

}
