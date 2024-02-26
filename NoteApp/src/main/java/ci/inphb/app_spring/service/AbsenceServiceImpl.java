package ci.inphb.app_spring.service;

import ci.inphb.app_spring.entities.Absence;
import ci.inphb.app_spring.entities.Formation;
import ci.inphb.app_spring.exception.AbsenceNouFoundException;
import ci.inphb.app_spring.repositories.AbsenceRepository;
import ci.inphb.app_spring.repositories.ServiceRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class AbsenceServiceImpl implements AbsenceService {

    private AbsenceRepository absenceRepository;

    @Override
    public Absence saveAbsence(Absence absence) {
        return absenceRepository.save(absence);
    }

    @Override
    public Absence updateAbsence(Long idAbsence, Absence absence) {

        //Absence _absence = this.getAbsence(idAbsence);

        return null;
    }

    @Override
    public List<Absence> getAllAbsence() {
        return absenceRepository.findAll();
    }

    @Override
    public Absence getAbsence(Long idAbsence) {
        return absenceRepository.findById(idAbsence).orElseThrow(()->new AbsenceNouFoundException("Absence not found !!!"));
    }

    @Override
    public void deleteAbsence(Long idAbsence) {
        absenceRepository.deleteById(idAbsence);
    }
}
