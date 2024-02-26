package ci.inphb.app_spring.service;

import ci.inphb.app_spring.entities.*;
import ci.inphb.app_spring.exception.EmployeNotFoundException;
import ci.inphb.app_spring.repositories.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class EmployeServiceImpl implements EmployeService {

    private EmployeRepository employeRepository;
    private AbsenceRepository absenceRepository;
    private RoleUserRepository roleUserRepository;
    private CongeRepository congeRepository;
    //private DocAdministratif docAdministratif;
    private FormationRepository formationRepository;
    private GradeRepository gradeRepository;

    @Override
    public void deleteEmploye(Long idEmploye) {
        employeRepository.deleteById(idEmploye);
    }

    @Override
    public List<Employe> getAllEmploye() {
        return employeRepository.findAll();
    }

    /**
     *
     * @param matricule matricule de l'employe
     * @param absence absence a demande
     * @return absence a demande
     */
    @Override
    public Absence demandAbsence(String matricule, Absence absence) {
        Employe _employe = employeRepository.findByMatricule(matricule);
        if(_employe==null) throw new EmployeNotFoundException("Employe not found !!!");

        Absence _absence = Absence.builder()
                .dateDebut(absence.getDateDebut())
                .dateFin(absence.getDateFin())
                .motif(absence.getMotif())
                .build();

        _employe.getAbsences().add(_absence);
        _absence.setEmploye(_employe);

        employeRepository.save(_employe);
        absenceRepository.save(_absence);

        return _absence;
    }

    @Override
    public Conge demandConge(String matricule, Conge conge) {
        Employe _employe = employeRepository.findByMatricule(matricule);
        if(_employe==null) throw new EmployeNotFoundException("Employe not found !!!");

        Conge _conge = Conge.builder()
                .description(conge.getDescription())
                .dateDebutConge(conge.getDateDebutConge())
                .dateFinConge(conge.getDateFinConge())
                .build();

        _employe.getCongeList().add(_conge);
        _conge.setEmploye(_employe);

        employeRepository.save(_employe);
        congeRepository.save(_conge);

        return _conge;
    }

    @Override
    public Formation demandFormation(String matricule, Formation formation) {
        Employe _employe = employeRepository.findByMatricule(matricule);
        if(_employe==null) throw new EmployeNotFoundException("Employe not found !!!");

        Formation _formation = Formation.builder()
                .duree(formation.getDuree())
                .lieu(formation.getLieu())
                .titre(formation.getTitre())
                .build();

        _employe.getFormations().add(_formation);
        _formation.setEmploye(_employe);
        return _formation;
    }

    @Override
    public DocAdministratif demandDocAdministratif(String matricule, DocAdministratif docAdministratif) {
        //Employe _employe = employeRepository.findById(idEmploye).orElseThrow(()->new EmployeNotFoundException("Employe not found !!!"));
        return null;
    }

    @Override
    public void attributeGrade(String matricule, String nomGrade) {
        Employe _employe = employeRepository.findByMatricule(matricule);
        if(_employe==null) throw new EmployeNotFoundException("Employe not found !!!");
        Grade grade = gradeRepository.findByTitre(nomGrade);
        if(grade!=null && _employe!=null){
            _employe.setGrade(grade);
            employeRepository.save(_employe);
        }
    }

    @Override
    public void attributeRole(String matricule, String roleName) {
        Employe _employe = employeRepository.findByMatricule(matricule);
        if(_employe==null) throw new EmployeNotFoundException("Employe not found !!!");

        RoleUser roleUser = roleUserRepository.findByLibelle(roleName);

        _employe.getRoles().add(roleUser);
        roleUser.getEmployes().add(_employe);

        employeRepository.save(_employe);
        roleUserRepository.save(roleUser);
    }

    @Override
    public void removeRole(String matricule, String roleName) {
        Employe _employe = employeRepository.findByMatricule(matricule);
        if(_employe==null) throw new EmployeNotFoundException("Employe not found !!!");

        RoleUser roleUser = roleUserRepository.findByLibelle(roleName);

        _employe.getRoles().remove(roleUser);
        roleUser.getEmployes().remove(_employe);

        employeRepository.save(_employe);
        roleUserRepository.save(roleUser);

    }

    @Override
    public void addPhoto(String matricule, MultipartFile photo) {
        Employe _employe = employeRepository.findByMatricule(matricule);
        if(_employe==null) throw new EmployeNotFoundException("Employe not found !!!");

    }
}
