package com.letcode.SecureBankSystem.controller.suggestionController;

import com.letcode.SecureBankSystem.bo.guestSuggestion.CreateSuggestionRequest;
import com.letcode.SecureBankSystem.service.guestSuggestion.GuestSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/suggestions")
public class SuggestionController {

    @Autowired
    private final GuestSuggestionService guestSuggestionService;

    public SuggestionController(GuestSuggestionService guestSuggestionService) {
        this.guestSuggestionService = guestSuggestionService;
    }


    @PostMapping
    public ResponseEntity<String> handleSuggestions(@RequestBody CreateSuggestionRequest createSuggestionRequest){
        try{
            guestSuggestionService.printAndProccesSuggestions(createSuggestionRequest.getGuestSuggestionText());
            return ResponseEntity.status(HttpStatus.CREATED).body("suggestion Created");

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while creating ");
        }
    }
}
