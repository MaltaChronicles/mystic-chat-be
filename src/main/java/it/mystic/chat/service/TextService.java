package it.mystic.chat.service;

import it.mystic.chat.mapper.TextMapper;
import it.mystic.chat.model.dao.TextDao;
import it.mystic.chat.model.dao.TextParagraphDao;
import it.mystic.chat.model.dto.text.Text;
import it.mystic.chat.model.dto.text.TextParagraph;
import it.mystic.chat.model.enums.TextType;
import it.mystic.chat.model.response.EssentialData;
import it.mystic.chat.model.response.TextResponse;
import it.mystic.chat.repo.text.TextParagraphRepo;
import it.mystic.chat.repo.text.TextRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextService {
    @Autowired
    private TextRepo textRepo;
    @Autowired
    private TextParagraphRepo textParagraphRepo;
    @Autowired
    private TextMapper textMapper;

    public TextResponse create(TextDao textDao) {
        Text text = textMapper.daoToDto(textDao);
        return textMapper.dtoToResponse(textRepo.save(text));
    }

    public void update(Long textId, TextDao textDao) {
        Text text = textRepo.getReferenceById(textId);
        text.setTitle(textDao.title());
        text.setBody(textDao.body());
        textRepo.save(text);
    }

    public List<EssentialData> getByType(TextType type) {
        return textMapper.dtoListToMap(textRepo.getByType(type));
    }

    public TextResponse getById(Long textId) {
        return textMapper.dtoToResponse(textRepo.getReferenceById(textId));
    }

    public String getParagraphById(Long paragraphId) {
        return textParagraphRepo.getReferenceById(paragraphId).getBody();
    }

    public void delete(Long textId) {
        textRepo.deleteById(textId);
    }

    public void addParagraph(Long textId, TextParagraphDao textParagraphDao) {
        Text text = textRepo.getReferenceById(textId);
        TextParagraph textParagraph = textMapper.paragraphDaoToDto(textParagraphDao, text);
        textParagraphRepo.save(textParagraph);
    }

    public void updateParagraph(Long paragraphId, TextParagraphDao textParagraphDao) {
        TextParagraph textParagraph = textParagraphRepo.getReferenceById(paragraphId);
        textParagraph.setTitle(textParagraphDao.title());
        textParagraph.setBody(textParagraphDao.body());
        textParagraphRepo.save(textParagraph);
    }

    public void removeParagraph(Long paragraphId) {
        textParagraphRepo.deleteById(paragraphId);
    }
}
