package ci.inphb.app_spring.service;

import ci.inphb.app_spring.entities.Direction;
import ci.inphb.app_spring.entities.SousDirection;

import java.util.List;

public interface SousDirectionService {

    SousDirection saveSousDirection(SousDirection sousdirection);
    SousDirection updateSousDirection(Long idSousDirection, SousDirection sousdirection);
    List<SousDirection> getAllSousDirection();
    SousDirection getSousDirection(Long idSousDirection);
    void deleteSousDirection(Long idSousDirection);

    void affectToDirection(Long idSousDirection, Long idDirection);

}
