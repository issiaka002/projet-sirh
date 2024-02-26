package ci.inphb.app_spring.web;


import ci.inphb.app_spring.entities.PersonnelAdministratif;
import ci.inphb.app_spring.service.PersonAdminitratifService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/administratif")
public class AdministratifController {

    public PersonAdminitratifService personAdminitratifService;

    @PostMapping
    PersonnelAdministratif savePersonnelAdministratif(@RequestBody PersonnelAdministratif personnelAdministratif){
        return personAdminitratifService.savePersonnelAdministratif(personnelAdministratif);
    }

    @PutMapping("/{idPersonnelAdministratif}")
    PersonnelAdministratif updatePersonnelAdministratif(@PathVariable Long idPersonnelAdministratif,@RequestBody PersonnelAdministratif personnelAdministratif){
        return personAdminitratifService.updatePersonnelAdministratif(idPersonnelAdministratif,personnelAdministratif);
    }

    @GetMapping
    List<PersonnelAdministratif> getAllPersonnelAdministratif(){
        return personAdminitratifService.getAllPersonnelAdministratif();
    }

    @GetMapping("/email/{emailPersonnelAdministratif}")
    PersonnelAdministratif getPersonAdminitratifByEmail(@PathVariable String emailPersonnelAdministratif){
        return personAdminitratifService.getPersonAdminitratifByEmail(emailPersonnelAdministratif);
    }

    @GetMapping("/{idPersonnelAdministratif}")
    PersonnelAdministratif getPersonnelAdministratif(@PathVariable Long idPersonnelAdministratif){
        return personAdminitratifService.getPersonnelAdministratif(idPersonnelAdministratif);
    }

    @DeleteMapping("/{idPersonnelAdministratif}")
    void deletePersonnelAdministratif(@PathVariable Long idPersonnelAdministratif){
        personAdminitratifService.deletePersonnelAdministratif(idPersonnelAdministratif);
    }

    //
    @PutMapping("/affect/service/{idPersonAdmin}/{nomService}")
    void affectToService(@PathVariable Long idPersonAdmin,@PathVariable String nomService){
        personAdminitratifService.affectToService(idPersonAdmin, nomService);
    }

}
