package com.generation.school.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;




@Entity
@Table(name = "tb_student")
@Data
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "It is necessary to inform the studend name!")
	private String name;
	
	@NotNull(message = "Please, inform the age!")
	private int age;
	
	@NotNull(message = "Please, inform the grade for the first semester!")
	private float firstSemesterGrade;
	
	@NotNull(message = "Please, inform the grade for the second semester!")
	private float secondSemesterGrade;
	
	@NotBlank(message = "It is necessary to inform the teacher name!")
	private String teacherName;
	
	@NotNull(message = "Please, inform the classroom number!")
	private int classroomNumber;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getFirstSemesterGrade() {
		return firstSemesterGrade;
	}

	public void setFirstSemesterGrade(float firstSemesterGrade) {
		this.firstSemesterGrade = firstSemesterGrade;
	}

	public float getSecondSemesterGrade() {
		return secondSemesterGrade;
	}

	public void setSecondSemesterGrade(float secondSemesterGrade) {
		this.secondSemesterGrade = secondSemesterGrade;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public int getClassroomNumber() {
		return classroomNumber;
	}

	public void setClassroomNumber(int classroomNumber) {
		this.classroomNumber = classroomNumber;
	}


	
	
	
}
