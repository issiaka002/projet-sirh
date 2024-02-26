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
public class DocAdministratif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private double taille;
    @Column(length = 10000, name = "doc")
    private byte[] docByte;

    @OneToMany(mappedBy = "docAdmintratif")
    private List<DetailDoc> detailDocs;
}
