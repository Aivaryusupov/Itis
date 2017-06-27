package ru.yusupov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yusupov.dto.UserDataForRegistrationDto;
import ru.yusupov.models.User;
import ru.yusupov.service.UsersService;

import java.util.List;

/**
 * 23.06.2017
 * SecurityController
 *
 * @author Aivar Yusupov
 * @version v0.1
 */
@RestController
public class SecurityController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/users")
    public ResponseEntity<UserDataForRegistrationDto> signUp(@RequestBody UserDataForRegistrationDto user) {
        return new ResponseEntity<>(usersService.registerUser(user), HttpStatus.OK);
    }

//    @PostMapping("/login")
//    public ResponseEntity<Object> login(@RequestHeader("password") String password,
//                                        @RequestHeader("login") String login) {
//        String token = usersService.login(password, login);
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Auth-Token", token);
//        return new ResponseEntity<>(null, headers, HttpStatus.OK);
//    }


    @RequestMapping(value = "/login", produces = "text/plain")
    public String login() {
        System.out.println(" *** MainRestController.login");
        return "There is nothing special about login here, just use Authorization: Basic, or provide secure token.\n" +
                "For testing purposes you can use headers X-Username and X-Password instead of HTTP Basic Access Authentication.\n" +
                "THIS APPLIES TO ANY REQUEST protected by Spring Security (see filter-mapping).\n\n" +
                "Realize, please, that Authorization request (or the one with testing X-headers) must be POST, otherwise they are ignored.";
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(usersService.getUsers(), HttpStatus.ACCEPTED);
    }
}
