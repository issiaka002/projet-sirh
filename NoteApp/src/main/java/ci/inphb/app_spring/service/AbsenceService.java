package ci.inphb.app_spring.service;

import ci.inphb.app_spring.entities.Absence;

import java.util.List;

public interface AbsenceService {

    Absence saveAbsence(Absence absence);
    Absence updateAbsence(Long idAbsence, Absence absence);
    List<Absence> getAllAbsence();
    Absence getAbsence(Long idAbsence);
    void deleteAbsence(Long idAbsence);
}
