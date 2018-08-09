package com.anatoliivoloshyn.cinemawebapp.entity;

public class Language {
    private long languageId;

    private String language;

    public Language() {
    }

    public Language(long languageId, String language) {
        this.languageId = languageId;
        this.language = language;
    }

    public long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(long languageId) {
        this.languageId = languageId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
