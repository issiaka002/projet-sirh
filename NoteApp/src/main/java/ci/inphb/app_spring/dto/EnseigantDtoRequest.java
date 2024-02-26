package ci.inphb.app_spring.dto;

import ci.inphb.app_spring.enums.Sexe;
import ci.inphb.app_spring.enums.Status;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnseigantDtoRequest {

    private String nom;
    private String prenom;
    private String email;
    private Double salaire;
    private Sexe sexe;
    private String adresse;
    private String matricule;
    private Status status;
    private String telephone;
    private String nationnalite;
    private String domaine;

}
