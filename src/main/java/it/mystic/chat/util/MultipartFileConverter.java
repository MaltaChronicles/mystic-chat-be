package it.mystic.chat.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class MultipartFileConverter {
    @Value("${upload.dir}")
    private String uploadDir;

    public String saveMultipartFile(MultipartFile file, String type, Long fileId, String extension) throws IOException {
        byte[] imageData = file.getBytes();

        String typeDir;
        switch (extension) {
            case "jpeg" -> typeDir = "img/" + type;
            case "mp3" -> typeDir = "mp3/" + type;
            default -> typeDir = type;
        }

        String dir = uploadDir + typeDir + "/";
        Path uploadPath = Paths.get(dir);
        checkFolderExists(uploadPath);

        String fileName = fileId + "." + extension;
        Path filePath = uploadPath.resolve(fileName);
        Files.write(filePath, imageData);

        return dir + fileName;
    }

    private void checkFolderExists(Path uploadPath) throws IOException {
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
    }
}
