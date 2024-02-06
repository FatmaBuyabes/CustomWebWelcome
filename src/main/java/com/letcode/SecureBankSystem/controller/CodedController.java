package com.letcode.SecureBankSystem.controller;

import com.letcode.SecureBankSystem.bo.CreateContactRequest;
import com.letcode.SecureBankSystem.bo.FirewellRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController   // handle api and it is the head of all in point endpoint

public class CodedController {

    List<CreateContactRequest> contacts = new ArrayList<>();  // the list is the parent and the array list is a sub-class


    @GetMapping("/sayHi")

    public String sayHi() {
        return "Welcome to Coded";

    }


    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Hello " + name + " !";
    }

    @PostMapping("/farewell")
    public String farewell(@RequestBody FirewellRequest farewellRequest) {
        return "Goodbye " + farewellRequest.getName() + " !";

    }

    @PostMapping("/addContact")
    public ResponseEntity<String> addContact(@RequestBody CreateContactRequest createContactRequest) {
        for (int i = 0; i < contacts.size(); i++) {  // to check the email exist
            if (contacts.get(i).getEmail() == createContactRequest.getEmail()) {
                return ResponseEntity.badRequest().body("Contact already exist");
            }
        }
        contacts.add(createContactRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);


    }

    @GetMapping("/getContactDetails")
    public ResponseEntity<?> getContactDetails(@RequestParam String name) {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println(contacts.get(i).getName());
        }
        return ResponseEntity.ok(contacts);

    }
}







