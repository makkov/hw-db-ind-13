package com.example.hwdbind13.repository;

import com.example.hwdbind13.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByAgeBetween(Integer min, Integer max);
}
