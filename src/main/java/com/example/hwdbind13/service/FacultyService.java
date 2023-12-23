package com.example.hwdbind13.service;

import com.example.hwdbind13.model.Faculty;
import com.example.hwdbind13.repository.FacultyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FacultyService {

    private final Logger logger = LoggerFactory.getLogger(FacultyService.class);

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty add(String name, String color) {
        logger.info("Was invoked method add");
        Faculty newFaculty = new Faculty(name, color);
        newFaculty = facultyRepository.save(newFaculty);
        return newFaculty;
    }

    public Faculty get(long id) {
        logger.info("Was invoked method get");
        return facultyRepository.findById(id).get();
    }

    public Faculty update(long id, String name, String color) {
        logger.info("Was invoked method update");
        Faculty facultyForUpdate = facultyRepository.findById(id).get();
        facultyForUpdate.setName(name);
        facultyForUpdate.setColor(color);
        return facultyRepository.save(facultyForUpdate);
    }

    public Faculty delete(long id) {
        logger.info("Was invoked method delete");
        Faculty facultyForDelete = facultyRepository.findById(id).get();
        facultyRepository.deleteById(id);
        return facultyForDelete;
    }

    public String getLongestName() {
//        return facultyRepository.findAll().stream()
//                .map(Faculty::getName)
//                .sorted((name1, name2) -> -1 * (name1.length() - name2.length()))
//                .toList()
//                .get(0);

        return facultyRepository.findAll().stream()
                .map(Faculty::getName)
                .max((name1, name2) -> name1.length() - name2.length())
                .get();

//        Вернуть лист с самыми длинными именами:
//        List<Faculty> facultyList = facultyRepository.findAll();
//        int maxLength = facultyList.stream()
//                .map(Faculty::getName)
//                .max((name1, name2) -> name1.length() - name2.length())
//                .map(String::length)
//                .get();
//
//        return facultyList.stream()
//                .map(Faculty::getName)
//                .filter(name -> name.length() == maxLength)
//                .collect(Collectors.toList());
    }
}
