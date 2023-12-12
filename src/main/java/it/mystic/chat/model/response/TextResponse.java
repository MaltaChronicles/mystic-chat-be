package it.mystic.chat.model.response;

import it.mystic.chat.model.dto.TextParagraph;
import it.mystic.chat.model.enums.TextType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.List;
import java.util.Map;

public record TextResponse(
        String title,
        String body,
        List<EssentialData> paragraphs
) {}
