package ci.inphb.app_spring.web;

import ci.inphb.app_spring.entities.Formation;
import ci.inphb.app_spring.service.FormationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/formation")
public class FormationController {

    public FormationService formationService;

    @PostMapping
    Formation saveFormation(@RequestBody Formation formation){
        return formationService.saveFormation(formation);
    }

    @PutMapping("/{idFormation}")
    Formation updateFormation(@PathVariable Long idFormation,@RequestBody Formation formation){
        return formationService.updateFormation(idFormation,formation);
    }

    @GetMapping
    List<Formation> getAllFormation(){
        return formationService.getAllFormation();
    }

    @GetMapping("/{idFormation}")
    Formation getFormation(@PathVariable Long idFormation){
        return formationService.getFormation(idFormation);
    }

    @DeleteMapping("/{idFormation}")
    void deleteFormation(@PathVariable Long idFormation){
        formationService.deleteFormation(idFormation);
    }
}
