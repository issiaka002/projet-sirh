package ci.inphb.app_spring.repositories;

import ci.inphb.app_spring.entities.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleUserRepository extends JpaRepository<RoleUser,Long> {
    RoleUser findByLibelle(String libelle);
}
