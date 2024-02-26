package ci.inphb.app_spring.service;

import ci.inphb.app_spring.entities.PersonnelAdministratif;
import ci.inphb.app_spring.entities.Service;
import ci.inphb.app_spring.exception.PersonnelAdministratifNotFoundExecption;
import ci.inphb.app_spring.repositories.PersonnelAdminRepository;
import ci.inphb.app_spring.repositories.ServiceRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
@Slf4j
@Transactional
@AllArgsConstructor
public class PersonAdminitratifServiceImpl implements PersonAdminitratifService {

    private PersonnelAdminRepository personnelAdminRepository;
    private ServiceRepository serviceRepository;

    @Override
    public PersonnelAdministratif savePersonnelAdministratif(PersonnelAdministratif personnelAdministratif) {
        return personnelAdminRepository.save(personnelAdministratif);
    }

    @Override
    public PersonnelAdministratif updatePersonnelAdministratif(Long idPersonnelAdministratif, PersonnelAdministratif personnelAdministratif) {
        PersonnelAdministratif _personAdmin = this.getPersonnelAdministratif(idPersonnelAdministratif);
        _personAdmin.setAdresse(personnelAdministratif.getAdresse());
        _personAdmin.setEmail(personnelAdministratif.getEmail());
        _personAdmin.setCNI(personnelAdministratif.getCNI());
        _personAdmin.setTypeContrat(personnelAdministratif.getTypeContrat());
        _personAdmin.setNom(personnelAdministratif.getNom());
        _personAdmin.setPrenom(personnelAdministratif.getPrenom());
        _personAdmin.setMatricule(personnelAdministratif.getMatricule());
        _personAdmin.setSalaire(personnelAdministratif.getSalaire());
        _personAdmin.setAdresse(personnelAdministratif.getAdresse());
        _personAdmin.setFonction(personnelAdministratif.getFonction());
        _personAdmin.setSexe(personnelAdministratif.getSexe());
        _personAdmin.setNotes(personnelAdministratif.getNotes());
        _personAdmin.setNationnalite(personnelAdministratif.getNationnalite());
        _personAdmin.setStatus(personnelAdministratif.getStatus());
        _personAdmin.setTelephone(personnelAdministratif.getTelephone());
        return _personAdmin;
    }

    @Override
    public List<PersonnelAdministratif> getAllPersonnelAdministratif() {
        return personnelAdminRepository.findAll();
    }

    @Override
    public PersonnelAdministratif getPersonAdminitratifByEmail(String emailPersonnelAdministratif) {
        return personnelAdminRepository.findByEmail(emailPersonnelAdministratif);
    }

    @Override
    public PersonnelAdministratif getPersonnelAdministratif(Long idPersonnelAdministratif) {
        return personnelAdminRepository.findById(idPersonnelAdministratif).orElseThrow(()-> new PersonnelAdministratifNotFoundExecption("Psersonnel administratif not found !!!"));
    }

    @Override
    public void deletePersonnelAdministratif(Long idPersonnelAdministratif) {
        personnelAdminRepository.deleteById(idPersonnelAdministratif);
    }

    @Override
    public void affectToService(Long idPersonAdmin, String nomService) {
        PersonnelAdministratif personnelAdministratif = this.getPersonnelAdministratif(idPersonAdmin);
        Service service = serviceRepository.findByLibelle(nomService);
        personnelAdministratif.setService(service);
        service.getPersonnelAdministratifs().add(personnelAdministratif);
        serviceRepository.save(service);
        personnelAdminRepository.save(personnelAdministratif);
    }
}
