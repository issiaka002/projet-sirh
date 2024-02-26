package ci.inphb.app_spring.service;

import ci.inphb.app_spring.entities.Enseignant;

import java.util.List;


public interface EnseignantService {

    List<Enseignant> getAllEnseignant();
    Enseignant getEnseignantById(Long idEnseignant);
    Enseignant getEnseignantByEmail(String emailEnseignant);
    void deleteEnseignant(Long idEnseignant);
    Enseignant updateEnseignant(Long idEnseignant, Enseignant enseignant);
    Enseignant saveEnseignant(Enseignant enseignant);
    //
    void affecterAEcole(Long idEnseigant, Long idEcole);
}
