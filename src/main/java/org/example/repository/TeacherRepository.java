package org.example.repository;

import org.example.model.entity.StudentEntity;
import org.example.model.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherEntity,Integer> {
}
