package ci.inphb.app_spring.service;

import ci.inphb.app_spring.entities.Ecole;
import ci.inphb.app_spring.exception.EcoleNotFoundException;
import ci.inphb.app_spring.repositories.EcoleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class EcoleServieImpl implements EcoleServie {

    private EcoleRepository ecoleRepository;

    @Override
    public Ecole saveEcole(Ecole ecole) {
        return ecoleRepository.save(ecole);
    }

    @Override
    public Ecole updateEcole(Long idEcole, Ecole ecole) {
        Ecole _ecole = this.getEcole(idEcole);
        _ecole.setNomEcole(ecole.getNomEcole());
        return ecoleRepository.save(_ecole);
    }

    @Override
    public List<Ecole> getAllEcole() {
        return ecoleRepository.findAll();
    }

    @Override
    public Ecole getEcole(Long idEcole) {
        return ecoleRepository.findById(idEcole).orElseThrow(()->new EcoleNotFoundException("Ecole not found !!!"));
    }

    @Override
    public void deleteEcole(Long idEcole) {
        ecoleRepository.deleteById(idEcole);
    }
}
