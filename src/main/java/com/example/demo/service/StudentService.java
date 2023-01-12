package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {

	Student createStudent(Student student);

	Student getStudentById(String id);

	List<Student> getAllStudents();

	void deleteStudentById(String id);

	List<Student> getStudentsByName(String name);

	List<Student> getStudentByNameAndEmail(String name, String email);

	List<Student> getStudentByNameOrEmail(String name, String email);

	List<Student> getAllStudentsWithPagination(int pageNo, int pageSize);

	List<Student> getAllStudentsWithSorting();

	List<Student> getAllStudentsByDepartmentName(String departmentName);

	List<Student> getAllStudentsbyEmailLike(String email);

	List<Student> getAllStudentsbyNameStartWith(String name);

}
