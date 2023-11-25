package it.mystic.chat.service;

import it.mystic.chat.repo.CharacterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepo characterRepo;

}
