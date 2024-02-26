package ci.inphb.app_spring.service;

import ci.inphb.app_spring.entities.RoleUser;

import java.util.List;

public interface RoleService {

    RoleUser saveRole(RoleUser role);
    RoleUser updateRole(Long idRole, RoleUser role);
    void deleteRole(Long idRole);
    List<RoleUser> getAllRole();
    RoleUser getRoleById(Long idRole);
    RoleUser getRoleByName(String nameRole);
}
