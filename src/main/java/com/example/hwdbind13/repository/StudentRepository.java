package com.example.hwdbind13.repository;

import com.example.hwdbind13.model.Faculty;
import com.example.hwdbind13.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
