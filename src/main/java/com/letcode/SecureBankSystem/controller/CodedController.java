package com.letcode.SecureBankSystem.controller;

import com.letcode.SecureBankSystem.ob.FirewellRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController("/api/v1/") // handle api and it is the head of all in point endpoint
public class CodedController {

    ArrayList<Contact> contact = new ArrayList<>();


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
    public String addContact(@RequestBody Contact contacts) {
        for(Contact existingContact : contact){
            if(existingContact.getEmail().equals(contacts.getEmail())){
                return "Contact already exist try other email";
            }
        }
        contact.add(contacts);

                    return "Name: " + contacts.getName()
                    + "\nEmail: " + contacts.getEmail()
                    + "\nPhone: " + contacts.getPhone();

    }

    @GetMapping("/getContactDetails")
    public String getContactDetails(@RequestParam String name, String email, String phone) {
        return "Name: " + name + "\nEmail: " + email + "\nPhone: " + phone;

    }


}


