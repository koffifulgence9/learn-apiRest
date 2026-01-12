package com.atos.apifulgence.student;

import com.atos.apifulgence.person.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/V1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;

    @GetMapping
    public ResponseEntity<List<StudentEntity>> getAllStudents() {
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<StudentEntity> createStudent(@RequestBody StudentEntity student) {
        StudentEntity studentCreated = studentRepository.save(student);
        return new ResponseEntity<>(studentCreated, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable Long id) {
        Optional<StudentEntity> student = studentRepository.findById(id);
        return student.map(studentEntity -> new ResponseEntity<>(studentEntity, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        Optional<StudentEntity> student = studentRepository.findById(id);
        if(student.isPresent()){
            studentRepository.delete(student.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("{id}")
    public ResponseEntity<StudentEntity> updateStudent(@PathVariable Long id, @RequestBody StudentEntity studentDetails){
        Optional<StudentEntity> student = studentRepository.findById(id);
        if(student.isPresent()){
            StudentEntity studentEntity = student.get();
            studentEntity.setName(studentDetails.getName());
            studentEntity.setCity(studentDetails.getCity());
            studentEntity.setPhoneNumber(studentDetails.getPhoneNumber());
            studentEntity.setEmail(studentDetails.getEmail());
            StudentEntity updatedStudent = studentRepository.save(studentEntity);
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
