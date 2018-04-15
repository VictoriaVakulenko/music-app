package com.dreamteam.songapp.service;

import com.dreamteam.songapp.enteties.File;
import com.dreamteam.songapp.handler.InvalidFileException;
import com.dreamteam.songapp.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileRepository fileRepository;

    @Override
    public String getFileExtension(String fileName) {
        return null;
    }

    @Override
    public boolean isValidExtension(String fileName) throws InvalidFileException {
        return false;
    }

    @Override
    public int getOpenParenthesisIndex(String baseFileName) {
        return 0;
    }

    @Override
    public String handleFileName(String fileName, String uploadDirectory) throws InvalidFileException {
        return null;
    }

    @Override
    public File uploadFile(MultipartFile file, String uploadDirectory) {
        return null;
    }

    @Override
    public void save(File uploadedFile) {

    }

    @Override
    public File findLastFile() {
        return null;
    }
}
