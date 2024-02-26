package ci.inphb.app_spring.web;

import ci.inphb.app_spring.entities.RoleUser;
import ci.inphb.app_spring.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/role")
public class RoleController {

    public RoleService roleService;

    @PostMapping
    RoleUser saveRole(@RequestBody RoleUser role){
        return roleService.saveRole(role);
    }

    @PutMapping("/{idRole}")
    RoleUser updateRole(@PathVariable Long idRole,@RequestBody RoleUser role){
        return roleService.updateRole(idRole,role);
    }

    @DeleteMapping("/{idRole}")
    void deleteRole(@PathVariable Long idRole){
        roleService.deleteRole(idRole);
    }

    @GetMapping
    List<RoleUser> getAllRole(){
        return roleService.getAllRole();
    }

    @GetMapping("/{idRole}")
    RoleUser getRoleById(@PathVariable Long idRole){
        return roleService.getRoleById(idRole);
    }

    @GetMapping("/name/{nameRole}")
    RoleUser getRoleByName(@PathVariable String nameRole){
        return roleService.getRoleByName(nameRole);
    }
}
