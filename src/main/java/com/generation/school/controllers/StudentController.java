package com.generation.school.controllers;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.school.entities.Student;
import com.generation.school.services.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentController {

	@Autowired
	public StudentService studentService;

	@GetMapping
	public ResponseEntity<List<Student>> findAll() {

		return ResponseEntity.ok(studentService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> findById(@PathVariable(value = "id") Long id) {
		return studentService.findById(id).map(response -> ResponseEntity.ok(response))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@PostMapping
	public ResponseEntity<Student> post(@Valid @RequestBody Student student) {
		return studentService.saveStudent(student)
				.map(response -> ResponseEntity.status(HttpStatus.CREATED).body(response))
				.orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());

	}

	        
	@PutMapping
	public ResponseEntity<Student> updateStudent(@Valid @RequestBody Student student) {
		SimpleEntry<Optional<Student>, Boolean> result = studentService.updateStudent(student);
	    Optional<Student> updatedStudent = result.getKey();
	    boolean isConflict = result.getValue();

	    if (updatedStudent.isPresent()) {
	        return ResponseEntity.ok(updatedStudent.get());
	    } else if (isConflict) {
	        return ResponseEntity.status(HttpStatus.CONFLICT).build();
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	}
	    	    	
	
	  
	  @ResponseStatus(HttpStatus.NO_CONTENT)
	  @DeleteMapping("/{id}") public void delete(@PathVariable(value = "id") Long id) {
	  Optional<Student> student= studentService.findById(id);
	  
	  if(student.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	  
	  studentService.deleteById(id); }
	 

}
