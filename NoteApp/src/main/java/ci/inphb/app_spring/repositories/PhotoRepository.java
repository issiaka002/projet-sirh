package ci.inphb.app_spring.repositories;

import ci.inphb.app_spring.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo,Long> {
}
