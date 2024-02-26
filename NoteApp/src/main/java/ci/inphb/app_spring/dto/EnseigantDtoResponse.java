package ci.inphb.app_spring.dto;

import ci.inphb.app_spring.entities.RoleUser;
import ci.inphb.app_spring.enums.Sexe;
import ci.inphb.app_spring.enums.Status;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnseigantDtoResponse {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private Double salaire;
    private Sexe sexe;
    private String adresse;
    private String matricule;
    private String telephone;
    private Status status;
    private String domaine;
    private String nationnalite;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<RoleUser> roles;
}
