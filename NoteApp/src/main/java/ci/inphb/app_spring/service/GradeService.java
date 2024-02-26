package ci.inphb.app_spring.service;

import ci.inphb.app_spring.entities.Grade;

import java.util.List;

public interface GradeService {

    Grade saveConge(Grade grade);
    Grade updateConge(Long idGrade, Grade grade);
    List<Grade> getAllGrade();
    Grade getGrade(Long idGrade);
    void deleteGrade(Long idGrade);
}
