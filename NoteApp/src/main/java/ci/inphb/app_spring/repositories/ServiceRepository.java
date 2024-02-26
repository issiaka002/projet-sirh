package ci.inphb.app_spring.repositories;

import ci.inphb.app_spring.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service,Long> {
    Service findByLibelle(String libelle);
}
