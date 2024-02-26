package ci.inphb.app_spring.repositories;

import ci.inphb.app_spring.entities.PersonnelAdministratif;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonnelAdminRepository extends JpaRepository<PersonnelAdministratif,Long> {

    PersonnelAdministratif findByEmail(String email);

}
