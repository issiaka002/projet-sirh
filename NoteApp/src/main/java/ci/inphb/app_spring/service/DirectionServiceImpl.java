package ci.inphb.app_spring.service;

import ci.inphb.app_spring.entities.Direction;
import ci.inphb.app_spring.exception.DirectionNotFoundException;
import ci.inphb.app_spring.repositories.DirectionRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class DirectionServiceImpl implements DirectionService {

    private DirectionRepository directionRepository;

    @Override
    public Direction saveDirection(Direction direction) {
        return directionRepository.save(direction);
    }

    @Override
    public Direction updateDirection(Long idDirection, Direction direction) {
        Direction _direction = this.getDirection(idDirection);
        _direction.setLibelle(direction.getLibelle());
        return directionRepository.save(_direction);
    }

    @Override
    public List<Direction> getAllDirection() {
        return directionRepository.findAll();
    }

    @Override
    public Direction getDirection(Long idDirection) {
        return directionRepository.findById(idDirection).orElseThrow(()->new DirectionNotFoundException("Direction not found !!!"));
    }

    @Override
    public void deleteDirection(Long idDirection) {
        directionRepository.deleteById(idDirection);
    }
}
