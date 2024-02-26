package ci.inphb.app_spring.dto;

import ci.inphb.app_spring.enums.Sexe;
import ci.inphb.app_spring.enums.Status;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonnelAdministratifDtoRequest {

    private String nom;
    private String prenom;
    private String email;
    private Double salaire;
    private Sexe sexe;
    private String adresse;
    private Status status;
    private String matricule;
    private String telephone;
    private String nationnalite;
}
