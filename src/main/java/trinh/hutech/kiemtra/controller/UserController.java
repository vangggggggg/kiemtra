package trinh.hutech.kiemtra.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import trinh.hutech.kiemtra.entities.Role;
import trinh.hutech.kiemtra.entities.User;
import trinh.hutech.kiemtra.requestentities.RequestCreateUser;
import trinh.hutech.kiemtra.requestentities.RequestUpdateUser;
import trinh.hutech.kiemtra.services.RoleService;
import trinh.hutech.kiemtra.services.UserService;

import java.util.List;

@Controller
@RequestMapping("/Users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @GetMapping("")
    public String ShowAllUsers(Model model){
        List<User> Users = userService.getAllUsers();
        model.addAttribute("Users", Users);
        return "User/list";
    }
    @GetMapping("/edit/{id}")
    public String ShowUserForm(@PathVariable String id, Model model){
        User User = userService.getuserById(id);
        model.addAttribute("User", User);
        model.addAttribute("Roles", roleService.getAllRoles());
        return "User/edit";
    }
    @PostMapping("/saveedit")
    public String SaveEditUser(RequestUpdateUser requestUpdateUser){
        userService.updateuser(requestUpdateUser.getId(),requestUpdateUser);
        return "redirect:/Users";
    }
    @GetMapping("/new")
    public String createForm(Model model){
        RequestCreateUser User = new RequestCreateUser();
        model.addAttribute("User", User);
        model.addAttribute("Roles", roleService.getAllRoles());
        return "User/create";
    }
    @PostMapping("/create")
    public String SaveCreateUser(RequestCreateUser requestCreateUser){
        userService.Createuser(requestCreateUser);
        return "redirect:/Users";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable String id) {
        if ( userService.getuserById(id) != null){
            userService.deleteuser(id);
        }
        return "redirect:/Users";
    }
    @GetMapping("/view/{id}")
    public String Viewroles(@PathVariable String id, Model model){
        User user = userService.getuserById(id);
        model.addAttribute("user", user);
        return "User/view";
    }
}
