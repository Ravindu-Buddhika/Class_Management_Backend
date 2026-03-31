package org.example.service;

import org.example.model.dto.Student;
import org.example.model.dto.Teacher;
import org.example.model.entity.StudentEntity;
import org.example.model.entity.TeacherEntity;
import org.example.repository.StudentRepository;
import org.example.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    ArrayList<Student> all = new ArrayList<>();

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherRepository teacherRepository;

    public ArrayList<Student> getAll(){
        for(StudentEntity studentEntity : studentRepository.findAll()){
            Student student=new Student();
            student.setId(studentEntity.getId());
            student.setName(studentEntity.getName());
            all.add(student);
        }
        return all;
    }

    public void save(Student student){
        StudentEntity studentEntity=new StudentEntity();
        studentEntity.setName(student.getName());

        TeacherEntity teacher=teacherRepository.getReferenceById(student.getTeacherId());

        studentEntity.setTeacher(teacher);

        studentRepository.save(studentEntity);
    }
}
