package com.generation.school.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.school.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	public Optional<Student> findByName(String name);
}
