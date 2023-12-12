package it.mystic.chat.mapper;

import it.mystic.chat.model.dao.TextDao;
import it.mystic.chat.model.dao.TextParagraphDao;
import it.mystic.chat.model.dto.Text;
import it.mystic.chat.model.dto.TextParagraph;
import it.mystic.chat.model.response.EssentialData;
import it.mystic.chat.model.response.TextResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class TextMapper {
    public Text daoToDto(TextDao textDao) {
        if(Objects.isNull(textDao))
            return null;
        return new Text(
                null,
                textDao.type(),
                textDao.title(),
                textDao.body(),
                null
        );
    }

    public TextResponse dtoToResponse(Text text) {
        if(Objects.isNull(text))
            return null;
        return new TextResponse(
                text.getTitle(),
                text.getBody(),
                paragraphsToMap(text.getParagraphs())
        );
    }

    private List<EssentialData> paragraphsToMap(List<TextParagraph> paragraphs) {
        if(Objects.isNull(paragraphs))
            return null;
        return paragraphs.stream().map(paragraph -> {
           return new EssentialData(paragraph.getParagraphId(), paragraph.getTitle());
        }).toList();
    }

    public List<EssentialData> dtoListToMap(List<Text> textList){
        return textList.stream().map(text -> {
           return new EssentialData(
                   text.getTextId(),
                   text.getTitle()
           );
        }).toList();
    }

    public TextParagraph paragraphDaoToDto(TextParagraphDao textParagraphDao, Text text) {
        return new TextParagraph(
                null,
                textParagraphDao.title(),
                textParagraphDao.body(),
                text
        );
    }
}
