package ci.inphb.app_spring.repositories;

import ci.inphb.app_spring.entities.Conge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CongeRepository extends JpaRepository<Conge,Long> {
}
