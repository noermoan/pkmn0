package zininavo.pkmn.service;

import zininavo.pkmn.models.Student;

import java.util.List;

public interface StudentService {
    Student getStudentBySurNameAndFirstNameAndFamilyName(String surName, String firstName, String familyName);
    List<Student> getStudentsByGroup(String group);
    List<Student> getAllStudents();
    Student saveStudent(Student student);
}