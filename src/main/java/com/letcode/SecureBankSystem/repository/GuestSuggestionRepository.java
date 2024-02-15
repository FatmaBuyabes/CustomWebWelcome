package com.letcode.SecureBankSystem.repository;

import com.letcode.SecureBankSystem.entity.GuestEntity;
import com.letcode.SecureBankSystem.util.enums.suggestion.SuggestionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestSuggestionRepository extends JpaRepository<GuestEntity,Long> {
    List<GuestEntity> findBySuggestionsStatus(SuggestionStatus suggestionStatus);

    List<GuestEntity> findAll(SuggestionStatus suggestionStatus);


}
