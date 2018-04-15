package com.dreamteam.songapp.repository;

import com.dreamteam.songapp.enteties.File;
import org.springframework.data.repository.CrudRepository;

public interface FileRepository extends CrudRepository<File, Long> {

    File findFileByOrderByIdDesc();

}
