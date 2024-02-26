package ci.inphb.app_spring.service;

import ci.inphb.app_spring.entities.Conge;
import ci.inphb.app_spring.exception.CongeNotFoundException;
import ci.inphb.app_spring.repositories.CongeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class CongeServiceImpl implements CongeService {

    private CongeRepository congeRepository;

    @Override
    public Conge saveConge(Conge conge) {
        return congeRepository.save(conge);
    }

    @Override
    public Conge updateConge(Long idConge, Conge conge) {
        return null;
    }

    @Override
    public List<Conge> getAllConge() {
        return congeRepository.findAll();
    }

    @Override
    public Conge getConge(Long idConge) {
        return congeRepository.findById(idConge).orElseThrow(()->new CongeNotFoundException("Conge Not found !!!"));
    }

    @Override
    public void deleteConge(Long idConge) {
        congeRepository.deleteById(idConge);
    }
}
