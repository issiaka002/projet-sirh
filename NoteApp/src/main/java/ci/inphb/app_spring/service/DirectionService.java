package ci.inphb.app_spring.service;

import ci.inphb.app_spring.entities.Direction;

import java.util.List;

public interface DirectionService {

    Direction saveDirection(Direction direction);
    Direction updateDirection(Long idDirection, Direction direction);
    List<Direction> getAllDirection();
    Direction getDirection(Long idDirection);
    void deleteDirection(Long idDirection);


}
