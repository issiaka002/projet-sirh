package ci.inphb.app_spring.web;


import ci.inphb.app_spring.entities.Employe;
import ci.inphb.app_spring.entities.Enseignant;
import ci.inphb.app_spring.service.EnseignantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/enseignant")
public class EnseignantController {

    public EnseignantService enseignantService;

    @GetMapping
    public List<Enseignant> listEnseignant(){
        return enseignantService.getAllEnseignant();
    }

    @GetMapping("/{idEmploye}")
    public Enseignant getEnseignant(@PathVariable Long idEnseignant){
        return enseignantService.getEnseignantById(idEnseignant);
    }
    @GetMapping("/email/{emailEnseignant}")
    Enseignant getEnseignantByEmail(@PathVariable String emailEnseignant){
        return enseignantService.getEnseignantByEmail(emailEnseignant);
    }

    @DeleteMapping("/{idEnseignant}")
    void deleteEnseignant(@PathVariable Long idEnseignant){
        enseignantService.deleteEnseignant(idEnseignant);
    }

    @PutMapping("/{idEnseignant}")
    Enseignant updateEnseignant(@PathVariable Long idEnseignant,@RequestBody Enseignant enseignant){
        return enseignantService.updateEnseignant(idEnseignant,enseignant);
    }

    @PostMapping
    Enseignant saveEnseignant(@RequestBody Enseignant enseignant){
        return enseignantService.saveEnseignant(enseignant);
    }
    //
    @PutMapping("/affect/{idEnseigant}/{idEcole}")
    void affecterAEcole(@PathVariable Long idEnseigant,@PathVariable Long idEcole){
        enseignantService.affecterAEcole(idEnseigant,idEcole);
    }


}
