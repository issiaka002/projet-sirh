package ci.inphb.app_spring.repositories;

import ci.inphb.app_spring.entities.DetailDoc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailDocRepository extends JpaRepository<DetailDoc,Long> {
}
