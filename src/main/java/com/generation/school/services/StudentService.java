package com.generation.school.services;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.school.entities.Student;
import com.generation.school.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> findAll() {
		List<Student> student = studentRepository.findAll();
		return student;
	}

	public Optional<Student> findById(Long id) {
		Optional<Student> student = studentRepository.findById(id);
		return student;
	}

	
	public Optional<Student> saveStudent(Student student) {

		if (studentRepository.findByName(student.getName()).isPresent()) {
			return Optional.empty();
		}
		return Optional.of(studentRepository.save(student));
	}

	
	
	public SimpleEntry<Optional<Student>, Boolean> updateStudent(Student student) {
	    Optional<Student> studentById = studentRepository.findById(student.getId());
	    Optional<Student> studentByName = studentRepository.findByName(student.getName());

	    if (studentById.isPresent()) {
	        if (studentByName.isPresent() && !studentById.get().getId().equals(studentByName.get().getId())) {
	            return new SimpleEntry<>(Optional.empty(), true); // Indica um conflito
	        }
	        return new SimpleEntry<>(Optional.ofNullable(studentRepository.save(student)), false);
	    }
	    return new SimpleEntry<>(Optional.empty(), false); // Indica que o estudante não foi encontrado
	}

	
	public void deleteById(Long id) {

		if (studentRepository.findById(id).isPresent()) {
			studentRepository.deleteById(id);
		}
	}

}
