package it.mystic.chat.service;

import it.mystic.chat.model.dto.Ability;
import it.mystic.chat.model.dto.Medal;
import it.mystic.chat.model.dto.Player;
import it.mystic.chat.repo.CharacterRepo;
import it.mystic.chat.repo.MedalRepo;
import it.mystic.chat.repo.PlayerRepo;
import it.mystic.chat.util.MultipartFileConverter;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class MedalService {
    @Autowired
    private MedalRepo medalRepo;
    @Autowired
    private PlayerRepo playerRepo;

    @Autowired
    private MultipartFileConverter converter;

    public Medal create(String name) {
        Medal medal = new Medal();
        medal.setName(name);
        return medalRepo.save(medal);
    }

    public void update(Long medalId, String name) {
        Medal medal = medalRepo.getReferenceById(medalId);
        medal.setName(name);
        medalRepo.save(medal);
    }

    @SuppressWarnings("ConstantConditions")
    public void uploadImage(Long medalId, MultipartFile file) throws IOException {
        Medal medal = medalRepo.getReferenceById(medalId);
        Hibernate.initialize(medal);
        if (medal != null) {
            medal.setImageUrl(converter.saveMultipartFile(file, "medal", medalId, "jpeg"));
            medalRepo.save(medal);
        }
    }

    public Medal getById(Long medalId) {
        return  medalRepo.getReferenceById(medalId);
    }

    public void delete(Long medalId) {
        medalRepo.deleteById(medalId);
    }

    public void giveToPlayer(Long medalId, Long playerId) {
        Medal medal = medalRepo.getReferenceById(medalId);
        Player player = playerRepo.getReferenceById(playerId);
        medal.getPlayers().add(player);
        player.getMedals().add(medal);
        medalRepo.save(medal);
        playerRepo.save(player);
    }
}
