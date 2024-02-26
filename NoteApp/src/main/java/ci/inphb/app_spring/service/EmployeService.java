package ci.inphb.app_spring.service;

import ci.inphb.app_spring.entities.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmployeService {

    /*Employe saveEmploye(Employe employe);
    Employe updateEmploye(Long idEmploye, Employe employe);

    List<Employe> getAllEmploye();
    Employe getEmployeById(Long idEmploye);
    Employe getEmployeByEmail(String email);*/
    void deleteEmploye(Long idEmploye);
    List<Employe> getAllEmploye();

    Absence demandAbsence(String matricule, Absence absence);
    Conge demandConge(String matricule, Conge conge);
    Formation demandFormation(String matricule, Formation formation);
    DocAdministratif demandDocAdministratif(String matricule, DocAdministratif docAdministratif);
    //
    void attributeGrade(String matricule, String nomGrade);
    void attributeRole(String matricule, String roleName);
    void removeRole(String matricule, String roleName);
    //
    void addPhoto(String matricule, MultipartFile photo);

}
