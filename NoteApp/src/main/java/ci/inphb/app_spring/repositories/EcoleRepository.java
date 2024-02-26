package ci.inphb.app_spring.repositories;

import ci.inphb.app_spring.entities.Ecole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EcoleRepository extends JpaRepository<Ecole,Long> {
}
