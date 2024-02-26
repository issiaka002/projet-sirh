package ci.inphb.app_spring.web;

import ci.inphb.app_spring.entities.*;
import ci.inphb.app_spring.service.EmployeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/employe")
public class EmployeController {

    public EmployeService employeService;

    @PostMapping("/absence/demand/{matricule}")
    Absence demandAbsence(@PathVariable String matricule, @RequestBody Absence absence){
        return employeService.demandAbsence(matricule,absence);
    }

    @DeleteMapping("/{idEmpl}")
    public void deleteEmploye(@PathVariable Long idEmpl){
        employeService.deleteEmploye(idEmpl);
    }

    @PostMapping("/conge/demand/{matricule}")
    Conge demandConge(@PathVariable String matricule, @RequestBody Conge conge){
        return employeService.demandConge(matricule,conge);
    }

    @PostMapping("/formation/demand/{matricule}")
    Formation demandFormation(@PathVariable String matricule, @RequestBody Formation formation){
        return employeService.demandFormation(matricule,formation);
    }

    DocAdministratif demandDocAdministratif(@PathVariable String matricule,@RequestBody DocAdministratif docAdministratif){
        return null;
    }
    //
    @PutMapping("/grade/{matricule}/{nomGrade}")
    void attributeGrade(@PathVariable String matricule,@PathVariable String nomGrade){
        employeService.attributeGrade(matricule,nomGrade);
    }

    @GetMapping("/all")
    List<Employe> getAllEmploye(){
        return employeService.getAllEmploye();
    }

    @PutMapping("/addRole/{matricule}/{roleName}")
    void attributeRole(@PathVariable String matricule, @PathVariable String roleName){
        employeService.attributeRole(matricule,roleName);
    }

    @PutMapping("/removeRole/{matricule}/{roleName}")
    void removeRole(String matricule, String roleName){
        employeService.removeRole(matricule,roleName);
    }
}
