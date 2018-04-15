package com.dreamteam.songapp.enteties;

import javax.persistence.*;
import java.nio.file.Path;
import java.nio.file.Paths;

@Entity
@Table(name = "files")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "file_directory")
    private String fileDirectory;
    @Column(name = "file_extension")
    private String fileExtension;
    @Transient
    private String fileBaseName;

    public File(){}

    public File(String fileName, String fileDirectory, String fileExtension, String fileBaseName) {
        this.fileName = fileName;
        this.fileDirectory = fileDirectory;
        this.fileExtension = fileExtension;
        this.fileBaseName = fileBaseName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDirectory() {
        return fileDirectory;
    }

    public void setFileDirectory(String fileDirectory) {
        this.fileDirectory = fileDirectory;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getFileBaseName() {
        return fileBaseName;
    }

    public void setFileBaseName(String fileBaseName) {
        this.fileBaseName = fileBaseName;
    }

    public Path getPathFile(){
        if(fileName == null || fileDirectory == null){
            return null;
        }
        return Paths.get(fileDirectory, fileName);
    }
}
