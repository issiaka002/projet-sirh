package ci.inphb.app_spring.service;

import ci.inphb.app_spring.entities.Formation;
import ci.inphb.app_spring.exception.FormationNotFoundException;
import ci.inphb.app_spring.repositories.FormationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class FormationServiceImpl implements FormationService {

    private FormationRepository formationRepository;

    @Override
    public Formation saveFormation(Formation formation) {
        return formationRepository.save(formation);
    }

    @Override
    public Formation updateFormation(Long idFormation, Formation formation) {
        Formation _formation = this.getFormation(idFormation);
        _formation.setDuree(formation.getDuree());
        _formation.setLieu(formation.getLieu());
        _formation.setEmploye(formation.getEmploye());
        _formation.setTitre(formation.getTitre());
        return _formation;
    }

    @Override
    public List<Formation> getAllFormation() {
        return formationRepository.findAll();
    }

    @Override
    public Formation getFormation(Long idFormation) {
        return formationRepository.findById(idFormation).orElseThrow(()-> new FormationNotFoundException("Formation not found !!"));
    }

    @Override
    public void deleteFormation(Long idFormation) {
        formationRepository.deleteById(idFormation);
    }
}
