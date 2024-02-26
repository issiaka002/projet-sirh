package ci.inphb.app_spring.repositories;

import ci.inphb.app_spring.entities.Direction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectionRepository extends JpaRepository<Direction,Long> {

    Direction findByLibelle(String libelle);
}
