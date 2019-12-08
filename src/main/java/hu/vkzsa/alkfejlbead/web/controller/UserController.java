package hu.vkzsa.alkfejlbead.web.controller;

import hu.vkzsa.alkfejlbead.entity.User;
import hu.vkzsa.alkfejlbead.repository.UserRepository;
import hu.vkzsa.alkfejlbead.entity.AuthenticatedUser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired 
    private AuthenticatedUser authenticatedUser;

    @PostMapping("register")
    public ResponseEntity<User> register(@RequestBody final User user) {
        //User oUser = userRepository.findByEmail(user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //user.setRoles(User.roles.ROLE_USER);
        return ResponseEntity.ok(userRepository.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<User> login() {
      return ResponseEntity.ok(authenticatedUser.getUser());
    } 

    @RequestMapping("/login")
    public boolean login(@RequestBody User user) {
        return
          user.getUserName().equals("user") && user.getPassword().equals("password");
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }
 
    @PostMapping("/users")
    void addUser(@RequestBody User user) {
        userRepository.save(user);
    }
}