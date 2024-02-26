package ci.inphb.app_spring.web;


import ci.inphb.app_spring.entities.Absence;
import ci.inphb.app_spring.service.AbsenceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/absence")
public class AbsenceController {
    public AbsenceService absenceService;

    @PostMapping
    Absence saveAbsence(@RequestBody Absence absence){
        return absenceService.saveAbsence(absence);
    }

    @PutMapping("/{idAbsence}")
    Absence updateAbsence( @PathVariable Long idAbsence,@RequestBody Absence absence){
        return absenceService.updateAbsence(idAbsence,absence);
    }

    @GetMapping
    List<Absence> getAllAbsence(){
        return absenceService.getAllAbsence();
    }

    @GetMapping("/{idAbsence}")
    Absence getAbsence(@PathVariable Long idAbsence){
        return absenceService.getAbsence(idAbsence);
    }

    @DeleteMapping("/{idAbsence}")
    void deleteAbsence(@PathVariable Long idAbsence){
        absenceService.deleteAbsence(idAbsence);
    }

}
