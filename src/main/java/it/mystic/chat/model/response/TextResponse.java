package it.mystic.chat.model.response;

import java.util.List;

public record TextResponse(
        String title,
        String body,
        List<EssentialData> paragraphs
) {
}
