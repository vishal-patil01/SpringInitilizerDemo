package com.spriginitializerdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @RequestMapping(value = {"", "/", "sayhello"})
    public String sayHello() {
        return "Hello World !!!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World !!!";
    }

    @GetMapping("/param/hello")
    public String hello(@RequestParam(value = "fName") String fName) {
        return "Hello " + fName;
    }

    @GetMapping("multi/param/hello")
    public String hello(@RequestParam(value = "fName") String fName, @RequestParam(value = "lName") String lName) {
        return "Hello " + fName + " " + lName;
    }

    @PostMapping("/post")
    public String hello(@RequestBody User user) {
        return "Hello " + user.getFirstName() + " " + user.getLastName();
    }

    @PutMapping("/put/{firstName}")
    public String sayHello(@PathVariable String firstName, @RequestParam(value = "lastName") String lastName) {
        return "Hello " + firstName + " " + lastName;
    }

    @PutMapping("/put/updatehello")
    public ResponseEntity<User> updateHello(@RequestBody User user) {
        User newUser = new User();
        newUser.setFirstName("Vishal");
        newUser.setLastName("Rajput");
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }
}
