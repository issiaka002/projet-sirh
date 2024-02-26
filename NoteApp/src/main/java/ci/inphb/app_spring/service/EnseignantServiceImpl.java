package ci.inphb.app_spring.service;

import ci.inphb.app_spring.entities.Ecole;
import ci.inphb.app_spring.entities.Enseignant;
import ci.inphb.app_spring.entities.RoleUser;
import ci.inphb.app_spring.exception.EnseignantNotFoundException;
import ci.inphb.app_spring.repositories.EnseignantRepository;
import ci.inphb.app_spring.repositories.RoleUserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class EnseignantServiceImpl implements EnseignantService {

    private EnseignantRepository enseignantRepository;
    private EcoleServie ecoleServie;
    private EmployeService employeService;

    @Override
    public List<Enseignant> getAllEnseignant() {
        return enseignantRepository.findAll();
    }

    @Override
    public Enseignant getEnseignantById(Long idEnseignant) {
        return enseignantRepository.findById(idEnseignant).orElseThrow(()->new EnseignantNotFoundException("Enseignant not found"));
    }

    @Override
    public Enseignant getEnseignantByEmail(String emailEnseignant) {
        return enseignantRepository.findByEmail(emailEnseignant);
    }

    @Override
    public void deleteEnseignant(Long idEnseignant) {
        enseignantRepository.deleteById(idEnseignant);
    }

    @Override
    public Enseignant updateEnseignant(Long idEnseignant, Enseignant enseignant) {
        Enseignant _enseignant= this.getEnseignantById(idEnseignant);
        _enseignant.setDomaine(enseignant.getDomaine());
        _enseignant.setCNI(enseignant.getCNI());
        _enseignant.setFonction(enseignant.getFonction());
        _enseignant.setEmail(enseignant.getEmail());
        _enseignant.setNom(enseignant.getNom());
        _enseignant.setPrenom(enseignant.getPrenom());
        _enseignant.setNotes(enseignant.getNotes());
        _enseignant.setMatricule(enseignant.getMatricule());
        _enseignant.setSalaire(enseignant.getSalaire());
        _enseignant.setStatus(enseignant.getStatus());
        _enseignant.setSexe(enseignant.getSexe());
        _enseignant.setTelephone(enseignant.getTelephone());
        _enseignant.setNationnalite(enseignant.getNationnalite());
        enseignantRepository.save(_enseignant);
        return enseignantRepository.save(_enseignant);
    }

    @Override
    public Enseignant saveEnseignant(Enseignant enseignant) {
        Enseignant save=enseignantRepository.save(enseignant);
        try{
            employeService.attributeRole(save.getMatricule(),"EMPLOYE");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return save;
    }

    @Override
    public void affecterAEcole(Long idEnseigant, Long idEcole) {
        Enseignant enseignant = this.getEnseignantById(idEnseigant);
        Ecole ecole = ecoleServie.getEcole(idEcole);
        enseignant.setEcole(ecole);
        ecole.getEnseignants().add(enseignant);
        ecoleServie.saveEcole(ecole);
        enseignantRepository.save(enseignant);
    }
}
