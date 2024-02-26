package ci.inphb.app_spring.repositories;

import ci.inphb.app_spring.entities.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationRepository extends JpaRepository<Formation,Long> {
}
