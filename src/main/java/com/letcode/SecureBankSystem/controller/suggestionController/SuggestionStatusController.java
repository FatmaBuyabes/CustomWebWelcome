package com.letcode.SecureBankSystem.controller.suggestionController;

import com.letcode.SecureBankSystem.bo.guestSuggestion.CreateSuggestionRequest;
import com.letcode.SecureBankSystem.entity.GuestEntity;
import com.letcode.SecureBankSystem.service.guestSuggestion.GuestSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SuggestionStatusController {

    @Autowired
    private final GuestSuggestionService guestSuggestionService;

    public SuggestionStatusController(GuestSuggestionService guestSuggestionService) {
        this.guestSuggestionService = guestSuggestionService;
    }


    @GetMapping("/create")
    public ResponseEntity<List<GuestEntity>> createSuggestions() {
        List<GuestEntity> createSuggestions = guestSuggestionService.findAllCreatedSuggestions();
        return ResponseEntity.ok(createSuggestions);
    }

    @GetMapping("/remove")
    public ResponseEntity<List<GuestEntity>> removeSuggestions() {
        List<GuestEntity> removeSuggestions = guestSuggestionService.findAllRemovedSuggestions();
        return ResponseEntity.ok(removeSuggestions);
    }
}
