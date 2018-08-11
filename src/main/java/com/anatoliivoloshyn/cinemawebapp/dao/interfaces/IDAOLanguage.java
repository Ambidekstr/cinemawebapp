package com.anatoliivoloshyn.cinemawebapp.dao.interfaces;

import com.anatoliivoloshyn.cinemawebapp.entity.Language;

import java.util.List;

public interface IDAOLanguage {
    List<Language> findAllLanguages();
    Language findLanguage(String language);
    boolean addLanguage(Language language);
    boolean deleteLanguage(Language language);
}
