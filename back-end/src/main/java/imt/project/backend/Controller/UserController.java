package imt.project.backend.Controller;

import imt.project.backend.Entity.User_info;
import imt.project.backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/test")
    public String test(){
        return "test";
    }

    @GetMapping("/user/all")
    public List<User_info> getAllUser(){
        return this.userRepository.findAll();
    }

    //get user_info by id
    @GetMapping("/user/{id}")
    public ResponseEntity<User_info> getUserById(@PathVariable(value = "id") Long userId) throws Exception {
        User_info user_info = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found"));
        return ResponseEntity.ok().body(user_info);
    }

    // save user_info
    @PostMapping("/user")
    public User_info createUser(@RequestBody User_info user_info){
        return this.userRepository.save(user_info);
    }

    // update user_info
    @PutMapping("/user/{id}")
    public ResponseEntity<User_info> updateUser(@PathVariable(value = "id") Long userId, @RequestBody User_info user_patch) throws Exception {
        User_info user_info = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found"));

        user_info.setUser_id(user_patch.getUser_id());
        user_info.setUser_name(user_patch.getUser_name());
        user_info.setUser_password(user_patch.getUser_password());

        return ResponseEntity.ok(this.userRepository.save(user_info));
    }

    // delete employee

    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long userId) throws Exception {
        User_info user_info = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found"));

        userRepository.delete(user_info);
        Map<String, Boolean> responce = new HashMap<>();

        responce.put("deleted", Boolean.TRUE);

        return responce;
    }
}
