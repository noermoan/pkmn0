package zininavo.pkmn.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zininavo.pkmn.dao.StudentDao;
import zininavo.pkmn.entity.StudentEntity;
import zininavo.pkmn.models.Student;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    @Autowired
    private final StudentDao studentDao;

    @Override
    public Student getStudentBySurNameAndFirstNameAndFamilyName(String surName, String firstName, String familyName) {
        StudentEntity studentEntity = studentDao.getBySurNameAndFirstNameAndFamilyName(surName, firstName, familyName);
        return Student.fromEntity(studentEntity);
    }

    @Override
    public List<Student> getStudentsByGroup(String group) {
        return studentDao.getByGroup(group).stream().map(Student::fromEntity).toList();
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAll().stream().map(Student::fromEntity).toList();
    }

    @Override
    public Student saveStudent(Student student) {
        if (studentDao.studentExists(student)) {
            throw new IllegalArgumentException("Студент уже есть в базе данных");
        }
        return Student.fromEntity(studentDao.saveStudent(StudentEntity.toEntity(student)));
    }
}
