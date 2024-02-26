package ci.inphb.app_spring.web;


import ci.inphb.app_spring.entities.Conge;
import ci.inphb.app_spring.service.CongeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/conge")
public class CongeController {

    public CongeServiceImpl congeService;

    @PostMapping
    Conge saveConge(@RequestBody Conge conge){
        return congeService.saveConge(conge);

    }
    @PutMapping("/{idConge}")
    Conge updateConge(@PathVariable Long idConge, @RequestBody Conge conge){
        return congeService.updateConge(idConge,conge);
    }

    @GetMapping
    List<Conge> getAllConge(){
        return congeService.getAllConge();
    }

    @GetMapping("/{idConge}")
    Conge getConge(@PathVariable Long idConge){
        return congeService.getConge(idConge);
    }

    @DeleteMapping("/{idConge}")
    void deleteConge(@PathVariable Long idConge){
        congeService.deleteConge(idConge);
    }
}
