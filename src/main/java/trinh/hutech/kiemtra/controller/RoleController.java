package trinh.hutech.kiemtra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import trinh.hutech.kiemtra.entities.Role;
import trinh.hutech.kiemtra.requestentities.RequestRole;
import trinh.hutech.kiemtra.services.RoleService;

import java.util.List;

@Controller
@RequestMapping("/Roles")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping("")
    public String ShowAllroles(Model model){
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("roles", roles);
        return "Role/list";
    }
    @GetMapping("/edit/{id}")
    public String ShowroleForm(@PathVariable String id, Model model){
        Role role = roleService.getRoleById(id);
        model.addAttribute("role", role);
        return "Role/edit";
    }
    @PostMapping("/saveedit")
    public String SaveEditrole(Role requestRole){
        roleService.updateRole(requestRole);
        return "redirect:/Roles";
    }
    @GetMapping("/new")
    public String createForm(Model model){
        RequestRole role = new RequestRole();
        model.addAttribute("role", role);
        return "Role/create";
    }
    @PostMapping("/create")
    public String SaveCreaterole(RequestRole role){
        roleService.CreateRole(role);
        return "redirect:/Roles";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable String id) {
        Role role = roleService.getRoleById(id);
        long count = roleService.countByRoleID(id);
        if ( role != null && count == 0){
            roleService.deleteRole(role);
        }
        return "redirect:/Roles";
    }

    @GetMapping("/view/{id}")
    public String Viewroles(@PathVariable String id, Model model){
        Role role = roleService.getRoleById(id);;
        model.addAttribute("role", role);
        return "Role/view";
    }
}
