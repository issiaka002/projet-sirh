package ci.inphb.app_spring.repositories;

import ci.inphb.app_spring.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Long> {

    Employe findByMatricule(String matricule);
}
