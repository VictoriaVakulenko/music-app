package com.dreamteam.songapp.service;

import com.dreamteam.songapp.enteties.File;
import com.dreamteam.songapp.handler.InvalidFileException;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    String getFileExtension(String fileName);
    boolean isValidExtension(String fileName) throws InvalidFileException;
    int getOpenParenthesisIndex(String baseFileName);
    String handleFileName(String fileName, String uploadDirectory) throws InvalidFileException;
    File uploadFile(MultipartFile file, String uploadDirectory);
    void save(File uploadedFile);
    File findLastFile();

}
