package ci.inphb.app_spring.service;

import ci.inphb.app_spring.entities.Formation;

import java.util.List;

public interface FormationService {

    Formation saveFormation(Formation formation);
    Formation updateFormation(Long idFormation, Formation formation);
    List<Formation> getAllFormation();
    Formation getFormation(Long idFormation);
    void deleteFormation(Long idFormation);
}
