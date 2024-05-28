package trinh.hutech.kiemtra.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import trinh.hutech.kiemtra.entities.Role;
import trinh.hutech.kiemtra.entities.User;
import trinh.hutech.kiemtra.repositories.IUserRepository;
import trinh.hutech.kiemtra.entities.User;
import trinh.hutech.kiemtra.requestentities.RequestCreateUser;
import trinh.hutech.kiemtra.requestentities.RequestUpdateUser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;


    public User Createuser(RequestCreateUser requestCreateuser){
        try {
            User user = new User();
            user.setUsername(requestCreateuser.getUsername());
            user.setFirstname (requestCreateuser.getFirstName());
            user.setLastname(requestCreateuser.getLastName());
            user.setEmail(requestCreateuser.getEmail());
            user.setPassword(requestCreateuser.getPassword());
            user.setRole(requestCreateuser.getRole());
            userRepository.save(user);
            return user;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<User> getAllUsers(){
        return userRepository.findAllByDe(false);
    }
    public User getuserById(String id){
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("user with id " + id + " not found")
        );
    }
    public User updateuser(String id, RequestUpdateUser requestUpdateUser){
        try {
            User user = getuserById(id);
            user.setUsername(requestUpdateUser.getUsername());
            user.setFirstname (requestUpdateUser.getFirstname());
            user.setLastname(requestUpdateUser.getLastname());
            user.setEmail(requestUpdateUser.getEmail());
            user.setPassword(requestUpdateUser.getPassword());
            user.setRole(requestUpdateUser.getRole());
            return userRepository.save(user);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public User deleteuser(String id) {
        try {
            User user = getuserById(id);
            user.setIsdeleted(true);
            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
