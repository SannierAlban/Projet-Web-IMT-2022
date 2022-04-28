package imt.project.backend.Controller;

import imt.project.backend.Entity.UserInfo;
import imt.project.backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public List<UserInfo> getAllUser(){
        return this.userRepository.findAll();
    }

    @GetMapping("/user/authentication")
    public UserInfo getIdFromUserNameAndPassword(@RequestParam("user_name") String userName, @RequestParam("user_password")String userPassword) throws Exception {
        List<UserInfo> userInfos = new ArrayList<>();
        userInfos = userRepository.findUserInfosByUserNameAndUserPassword(userName, userPassword);

        if(userInfos.size() != 1){
            throw new Exception("pb");

        }

        return userInfos.get(0);
    }


    //get user_info by id
    @GetMapping("/user/{id}")
    public ResponseEntity<UserInfo> getUserById(@PathVariable(value = "id") Long userId) throws Exception {
        UserInfo user_info = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found"));
        return ResponseEntity.ok().body(user_info);
    }

    // save user_info
    @PostMapping("/user")
    public UserInfo createUser(@RequestBody UserInfo user_info){
        return this.userRepository.save(user_info);
    }

    // update user_info
    @PutMapping("/user/{id}")
    public ResponseEntity<UserInfo> updateUser(@PathVariable(value = "id") Long userId, @RequestBody UserInfo user_patch) throws Exception {
        UserInfo user_info = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found"));

        user_info.setUserId(user_patch.getUserId());
        user_info.setUserName(user_patch.getUserName());
        user_info.setUserPassword(user_patch.getUserPassword());

        return ResponseEntity.ok(this.userRepository.save(user_info));
    }

    // delete employee

    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long userId) throws Exception {
        UserInfo user_info = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found"));

        userRepository.delete(user_info);
        Map<String, Boolean> responce = new HashMap<>();

        responce.put("deleted", Boolean.TRUE);

        return responce;
    }
}
