package com.anatoliivoloshyn.cinemawebapp.entity;

import java.io.Serializable;
import java.util.Objects;

public class Language implements Serializable {
    private long languageId;

    private String language;

    public Language() {
    }

    public Language(long languageId) {
        this.languageId = languageId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Language language1 = (Language) o;
        return languageId == language1.languageId &&
                Objects.equals(language, language1.language);
    }

    @Override
    public int hashCode() {

        return Objects.hash(languageId, language);
    }

    @Override
    public String toString() {
        return "Language{" +
                "languageId=" + languageId +
                ", language='" + language + '\'' +
                '}';
    }
}
