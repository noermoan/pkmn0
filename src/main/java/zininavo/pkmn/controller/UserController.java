package zininavo.pkmn.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import zininavo.pkmn.models.Student;
import zininavo.pkmn.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class UserController {

    private final StudentService studentService; // Удалено @Autowired

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/group")
    public List<Student> getStudentsByGroup(@PathVariable String group) {
        return studentService.getStudentsByGroup(group);
    }

    @GetMapping("")
    public Student getStudentByName(@RequestParam String surName,
                                    @RequestParam String firstName,
                                    @RequestParam String familyName) {
        return studentService.getStudentBySurNameAndFirstNameAndFamilyName(surName, firstName, familyName);
    }

    @PostMapping("")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }
}

