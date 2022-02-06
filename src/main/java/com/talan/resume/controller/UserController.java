package com.talan.resume.controller;

import com.talan.resume.model.User;
import com.talan.resume.service.UserRequest;
import com.talan.resume.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/resume")
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> createUser (@RequestBody UserRequest request){
        if(userService.create(request)!= null) {
            return new ResponseEntity<>("resume added" , HttpStatus.OK);
        }
        return new ResponseEntity<>("resume already exists" , HttpStatus.CONFLICT);
    }

    @GetMapping("/all")
    public List<User> getAll () {
        return userService.findAllUsers();

    }

    @GetMapping("/{id}")
    public Optional<User> findById (@PathVariable Long id) {

        return userService.findUserById(id);

    }

    @PutMapping ("update/{id}")
    public User updateUser (@RequestBody UserRequest newUser , @PathVariable Long id) {
        User oldUser = userService.findUserById(id).get();
        oldUser.setFirstName(newUser.getFirstName());
        oldUser.setLastName(newUser.getLastName());
        oldUser.setDateOfBirth(newUser.getDateOfBirth());
        oldUser.setCity(newUser.getCity());
        oldUser.setCountry(newUser.getCountry());
        oldUser.setPhone(newUser.getPhone());
        oldUser.setEmail(newUser.getEmail());
        oldUser.setAddress(newUser.getAddress());
        oldUser.setGraduation(newUser.getGraduation());
        oldUser.setUniversity(newUser.getUniversity());
        oldUser.setDegree(newUser.getDegree());
        oldUser.setCompanyName(newUser.getCompanyName());
        oldUser.setJobPosition(newUser.getJobPosition());
        oldUser.setFromDate(newUser.getFromDate());
        oldUser.setToDate(newUser.getToDate());
        oldUser.setSkills(newUser.getSkills());
        oldUser.setMotivation(newUser.getMotivation());

        return userService.save(oldUser);

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity <String> deleteById (@PathVariable Long id) {
        userService.deleteUserById((id));
        return new ResponseEntity<>("resume deleted" , HttpStatus.OK);
    }
}


