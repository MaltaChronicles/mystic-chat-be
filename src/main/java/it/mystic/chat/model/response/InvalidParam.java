package it.mystic.chat.model.response;

public record InvalidParam (
    String param,
    String message
){}
