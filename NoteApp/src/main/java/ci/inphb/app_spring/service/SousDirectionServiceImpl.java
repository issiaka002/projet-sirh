package ci.inphb.app_spring.service;

import ci.inphb.app_spring.entities.Direction;
import ci.inphb.app_spring.entities.SousDirection;
import ci.inphb.app_spring.exception.SousDirectionNotFoudException;
import ci.inphb.app_spring.repositories.SousDirectionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class SousDirectionServiceImpl implements SousDirectionService {

    private SousDirectionRepository sousDirectionRepository;
    private DirectionService directionService;

    @Override
    public SousDirection saveSousDirection(SousDirection sousdirection) {
        return sousDirectionRepository.save(sousdirection);
    }

    @Override
    public SousDirection updateSousDirection(Long idSousDirection, SousDirection sousdirection) {
        SousDirection _sousDirection = this.getSousDirection(idSousDirection);
        _sousDirection.setLibelle(_sousDirection.getLibelle());
        return sousDirectionRepository.save(_sousDirection);
    }

    @Override
    public List<SousDirection> getAllSousDirection() {
        return sousDirectionRepository.findAll();
    }

    @Override
    public SousDirection getSousDirection(Long idSousDirection) {
        return sousDirectionRepository.findById(idSousDirection).orElseThrow(()->new SousDirectionNotFoudException("Sous direction not found !!!"));
    }

    @Override
    public void deleteSousDirection(Long idSousDirection) {
        sousDirectionRepository.deleteById(idSousDirection);
    }

    @Override
    public void affectToDirection(Long idSousDirection, Long idDirection) {
        SousDirection sousDirection = this.getSousDirection(idSousDirection);
        Direction direction = directionService.getDirection(idDirection);
        sousDirection.setDirection(direction);
        direction.getSousDirections().add(sousDirection);

        directionService.saveDirection(direction);
        sousDirectionRepository.save(sousDirection);
    }
}
