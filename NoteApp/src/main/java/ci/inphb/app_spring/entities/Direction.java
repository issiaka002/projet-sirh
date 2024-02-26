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
public class Direction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDirection;
    private String libelle;

    @OneToMany(mappedBy = "direction")
    private List<SousDirection> sousDirections;
}
