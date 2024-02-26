package ci.inphb.app_spring.repositories;

import ci.inphb.app_spring.entities.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignantRepository extends JpaRepository<Enseignant,Long> {

    Enseignant findByEmail(String email);
}
