package it.mystic.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MysticChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysticChatApplication.class, args);
    }

}
