package it.mystic.chat.service;

import it.mystic.chat.mapper.MedalMapper;
import it.mystic.chat.model.dto.Medal;
import it.mystic.chat.model.dto.player.Player;
import it.mystic.chat.model.response.MedalResponse;
import it.mystic.chat.repo.MedalRepo;
import it.mystic.chat.repo.player.PlayerRepo;
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
    @Autowired
    private MedalMapper medalMapper;

    public MedalResponse create(String name) {
        Medal medal = medalMapper.daoTo(name);
        return medalMapper.dtoToResponse(medalRepo.save(medal));
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

    public MedalResponse getById(Long medalId) {
        return medalMapper.dtoToResponse(medalRepo.getReferenceById(medalId));
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
