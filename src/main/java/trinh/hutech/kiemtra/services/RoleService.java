package trinh.hutech.kiemtra.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Roledetails.RolenameNotFoundException;
import org.springframework.stereotype.Service;
import trinh.hutech.kiemtra.entities.Role;
import trinh.hutech.kiemtra.entities.Role;
import trinh.hutech.kiemtra.repositories.IRoleRepository;
import trinh.hutech.kiemtra.repositories.IRoleRepository;


import java.util.List;

@Service
public class RoleServices  {
    @Autowired
    private IRoleRepository roleRepository;
    
    public Role CreateRole(Role roleCreate){
        try {
            Role Role = new Role();
            Role.setRole_name(roleCreate.getRole_name());
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

    public Role updateRole(String id, Role requestUpdateRole){
        try {
            Role Role = getRoleById(id);
            Role.setRole_name(requestUpdateRole.getRole_name());
            roleRepository.save(Role);
            return roleRepository.save(Role);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
