package com.letcode.SecureBankSystem.bo.guestSuggestion;

public class CreateSuggestionRequest {

    private Long id;

    private int rate;

    private String guestSuggestionText;

    public String getSuggestionStatus() {
        return suggestionStatus;
    }

    public void setSuggestionStatus(String suggestionStatus) {
        this.suggestionStatus = suggestionStatus;
    }

    private String suggestionStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getGuestSuggestionText() {
        return guestSuggestionText;
    }

    public void setGuestSuggestionText(String guestSuggestion) {
        this.guestSuggestionText = guestSuggestion;
    }


}
