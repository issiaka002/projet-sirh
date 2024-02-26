package ci.inphb.app_spring.web;


import ci.inphb.app_spring.entities.Grade;
import ci.inphb.app_spring.service.GradeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/grade")
public class GradeController {

    public GradeService gradeService;

    @PostMapping
    Grade saveConge(@RequestBody Grade grade){
        return gradeService.saveConge(grade);
    }

    @PutMapping("/{idGrade}")
    Grade updateConge(@PathVariable Long idGrade, @RequestBody Grade grade){
        return gradeService.updateConge(idGrade,grade);
    }

    @GetMapping
    List<Grade> getAllGrade(){
        return gradeService.getAllGrade();
    }

    @GetMapping("/{idGrade}")
    Grade getGrade(@PathVariable Long idGrade){
        return gradeService.getGrade(idGrade);
    }

    @DeleteMapping("/{idGrade}")
    void deleteGrade(@PathVariable Long idGrade){
        gradeService.deleteGrade(idGrade);
    }
}
