package com.letcode.SecureBankSystem.service.guestSuggestion;

import com.letcode.SecureBankSystem.entity.GuestEntity;
import com.letcode.SecureBankSystem.repository.GuestSuggestionRepository;
import com.letcode.SecureBankSystem.util.enums.suggestion.SuggestionStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestSuggestionService implements SuggestionProcessor {

    private final GuestSuggestionRepository guestSuggestionRepository;

    public GuestSuggestionService(GuestSuggestionRepository guestSuggestionRepository) {
        this.guestSuggestionRepository = guestSuggestionRepository;
    }

   public List<GuestEntity> printAndProccesSuggestions(){
        return  guestSuggestionRepository.findAll();
   }

    public List<GuestEntity> findAllCreatedSuggestions(){
        return  guestSuggestionRepository.findAll(SuggestionStatus.CREATE);
    }

    public List<GuestEntity> findAllRemovedSuggestions(){
        return  guestSuggestionRepository.findAll(SuggestionStatus.REMOVE);
    }



    @Override
    public void getSuggestionRate() {

    }

    @Override
    public void processSugesstion(String suggestionText) {

    }

}
