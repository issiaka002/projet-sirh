package ci.inphb.app_spring.repositories;

import ci.inphb.app_spring.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade,Long> {

    Grade findByTitre(String titre);
}
