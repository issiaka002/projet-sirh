package ci.inphb.app_spring.service;

import ci.inphb.app_spring.entities.Conge;
import ci.inphb.app_spring.entities.Enseignant;
import ci.inphb.app_spring.entities.PersonnelAdministratif;

import java.util.List;

public interface PersonAdminitratifService {

    PersonnelAdministratif savePersonnelAdministratif(PersonnelAdministratif personnelAdministratif);
    PersonnelAdministratif updatePersonnelAdministratif(Long idPersonnelAdministratif, PersonnelAdministratif personnelAdministratif);
    List<PersonnelAdministratif> getAllPersonnelAdministratif();
    PersonnelAdministratif getPersonAdminitratifByEmail(String emailPersonnelAdministratif);
    PersonnelAdministratif getPersonnelAdministratif(Long idPersonnelAdministratif);
    void deletePersonnelAdministratif(Long idPersonnelAdministratif);
    //
    void affectToService(Long idPersonAdmin, String nomService);
}
