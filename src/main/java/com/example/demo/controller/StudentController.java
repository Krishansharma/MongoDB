package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/student")
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable String id) {
		return studentService.getStudentById(id);
	}
	@GetMapping("/studentByName/{name}")
	public List<Student> getStudentByName(@PathVariable String name) {
		return studentService.getStudentsByName(name);
	}
	@GetMapping("/studentByNameAndEmail")
	public List<Student> getStudentByNameAndEmail(@RequestParam String name,@RequestParam String email) {
		return studentService.getStudentByNameAndEmail(name,email);
	}
	@GetMapping("/studentByNameOrEmail")
	public List<Student> getStudentByNameOrEmail(@RequestParam String name,@RequestParam String email) {
		return studentService.getStudentByNameOrEmail(name,email);
	}
	@GetMapping("/student")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	@DeleteMapping("/student/{id}")
	public void deleteStudentById(@PathVariable String id) {
		 studentService.deleteStudentById(id);
	}
	
	@GetMapping("/student/withPagination")
	public List<Student> getAllStudentsWithPagination(@RequestParam int pageNo,@RequestParam int pageSize) {
		return studentService.getAllStudentsWithPagination(pageNo,pageSize);
	}
	
	@GetMapping("/student/allWithSorting")
	public List<Student> getAllStudentsWithSorting() {
		return studentService.getAllStudentsWithSorting();
	}
	
	@GetMapping("/student/byDepartmentName")
	public List<Student> getAllStudentsbyDepartmentName(@RequestParam String departmentName) {
		return studentService.getAllStudentsByDepartmentName(departmentName);
	}
	@GetMapping("/student/emailLike")
	public List<Student> getAllStudentsbyEmailLike(@RequestParam String email) {
		return studentService.getAllStudentsbyEmailLike(email);
	}
	
	@GetMapping("/student/nameStartWith")
	public List<Student> getAllStudentsbyNameStartWith(@RequestParam String name) {
		return studentService.getAllStudentsbyNameStartWith(name);
	}
}
