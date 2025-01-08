package zininavo.pkmn.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import zininavo.pkmn.entity.StudentEntity;
import zininavo.pkmn.entityrepository.StudentEntityRepository;
import zininavo.pkmn.models.Student;

import java.util.List;

@Component
@RequiredArgsConstructor
public final class StudentDao {
    private StudentEntityRepository studentEntityRepository;

    public StudentEntity getBySurNameAndFirstNameAndFamilyName(String surName, String firstName, String familyName) {
        return studentEntityRepository.findBySurNameAndFirstNameAndFamilyName(surName, firstName, familyName)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
    }

    public List<StudentEntity> getByGroup(String group) {
        return studentEntityRepository.findByGroup(group);
    }

    public List<StudentEntity> getAll() {
        return studentEntityRepository.findAll();
    }

    public StudentEntity saveStudent(StudentEntity studentEntity) {
        return studentEntityRepository.save(studentEntity);
    }

    public boolean studentExists(Student student) {
        return studentEntityRepository.findBySurNameAndFirstNameAndFamilyNameAndGroup(
                student.getSurName(),
                student.getFirstName(),
                student.getFamilyName(),
                student.getGroup()).isPresent();
    }
}

