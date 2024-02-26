package ci.inphb.app_spring.service;

import ci.inphb.app_spring.exception.RoleUserNotFoundException;
import ci.inphb.app_spring.entities.RoleUser;
import ci.inphb.app_spring.repositories.RoleUserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private RoleUserRepository roleUserRepository;

    @Override
    public RoleUser saveRole(RoleUser role) {
        return roleUserRepository.save(role);
    }

    @Override
    public RoleUser updateRole(Long idRole, RoleUser role) {
        RoleUser _role = this.getRoleById(idRole);
        _role.setLibelle(role.getLibelle());
        return _role;
    }

    @Override
    public void deleteRole(Long idRole) {
        roleUserRepository.deleteById(idRole);
    }

    @Override
    public List<RoleUser> getAllRole() {
        return roleUserRepository.findAll();
    }

    @Override
    public RoleUser getRoleById(Long idRole) {
        return roleUserRepository.findById(idRole).orElseThrow(()-> new RoleUserNotFoundException("Role not found !!!"));
    }

    @Override
    public RoleUser getRoleByName(String nameRole) {
        return roleUserRepository.findByLibelle(nameRole);
    }
}
