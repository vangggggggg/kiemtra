package trinh.hutech.kiemtra.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trinh.hutech.kiemtra.entities.Role;
import trinh.hutech.kiemtra.entities.User;
import trinh.hutech.kiemtra.repositories.IRoleRepository;
import trinh.hutech.kiemtra.repositories.IUserRepository;
import trinh.hutech.kiemtra.requestentities.RequestRole;


import java.util.List;

@Service
public class RoleService {
    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private IUserRepository userRepository;

    public Role CreateRole(RequestRole requestRole){
        try {
            Role Role = new Role();
            Role.setRole_name(requestRole.getName());
            roleRepository.save(Role);
            return Role;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }
    public Role getRoleById(String id){
        return roleRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Role with id " + id + " not found")
        );
    }

    public Role updateRole(Role role){
        try {
            Role Role = getRoleById(role.getRole_id());
            Role.setRole_name(role.getRole_name());
            roleRepository.save(Role);
            return roleRepository.save(Role);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public Role deleteRole(Role Role) {
        try {
            roleRepository.delete(Role);
            return Role;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public long countByRoleID(String roleName) {
        return roleRepository.countByRoleID(roleName);
    }
}
