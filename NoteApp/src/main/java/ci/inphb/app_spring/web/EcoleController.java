package ci.inphb.app_spring.web;


import ci.inphb.app_spring.entities.Ecole;
import ci.inphb.app_spring.service.EcoleServie;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/ecole")
public class EcoleController {

    public EcoleServie ecoleService;

    @PostMapping
    Ecole saveEcole(@RequestBody Ecole ecole){
        return ecoleService.saveEcole(ecole);
    }

    @PutMapping("/{idEcole}")
    Ecole updateEcole(@PathVariable Long idEcole,@RequestBody Ecole ecole){
        return ecoleService.updateEcole(idEcole,ecole);
    }

    @GetMapping
    List<Ecole> getAllEcole(){
        return ecoleService.getAllEcole();
    }

    @GetMapping("/{idEcole}")
    Ecole getEcole(@PathVariable Long idEcole){
        return ecoleService.getEcole(idEcole);
    }

    @DeleteMapping("/{idEcole}")
    void deleteEcole(@PathVariable Long idEcole){
        ecoleService.deleteEcole(idEcole);
    }
}
