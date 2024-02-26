package ci.inphb.app_spring.repositories;

import ci.inphb.app_spring.entities.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsenceRepository extends JpaRepository<Absence,Long> {
}
