package imt.project.backend.Service;

import imt.project.backend.Entity.User_info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    /**
    @Autowired
    private UserRepository userRepository;

    public List<User_info> getUsers(){
        List<User_info> users_info = new ArrayList<>();
        userRepository.findAll().forEach(users_info::add);
        return users_info;
    }
    **/
}
