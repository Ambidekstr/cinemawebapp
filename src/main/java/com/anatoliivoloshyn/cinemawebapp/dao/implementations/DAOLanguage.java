package com.anatoliivoloshyn.cinemawebapp.dao.implementations;

import com.anatoliivoloshyn.cinemawebapp.dao.interfaces.IDAOLanguage;
import com.anatoliivoloshyn.cinemawebapp.entity.Language;

import java.util.List;

public class DAOLanguage implements IDAOLanguage {
    @Override
    public List<Language> findAllLanguages() {
        return null;
    }

    @Override
    public Language findLanguage(String language) {
        return null;
    }

    @Override
    public boolean addLanguage(Language language) {
        return false;
    }

    @Override
    public boolean deleteLanguage(Language language) {
        return false;
    }
}
