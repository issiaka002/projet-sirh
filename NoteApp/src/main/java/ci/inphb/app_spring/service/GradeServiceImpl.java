package ci.inphb.app_spring.service;

import ci.inphb.app_spring.entities.Grade;
import ci.inphb.app_spring.exception.GradeNotFoundException;
import ci.inphb.app_spring.exception.ServicesNotFoundException;
import ci.inphb.app_spring.repositories.GradeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class GradeServiceImpl implements GradeService {

    private GradeRepository gradeRepository;

    @Override
    public Grade saveConge(Grade grade) {
        return gradeRepository.save(grade);
    }

    @Override
    public Grade updateConge(Long idGrade, Grade grade) {
        Grade _grade = this.getGrade(idGrade);
        _grade.setTitre(grade.getTitre());
        return null;
    }

    @Override
    public List<Grade> getAllGrade() {
        return gradeRepository.findAll();
    }

    @Override
    public Grade getGrade(Long idGrade) {
        return gradeRepository.findById(idGrade).orElseThrow(()-> new GradeNotFoundException("Grade not found !!!"));
    }

    @Override
    public void deleteGrade(Long idGrade) {
        gradeRepository.deleteById(idGrade);
    }
}
