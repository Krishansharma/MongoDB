package com.example.demo.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.demo.entity.Student;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student createStudent(Student student) {
		return studentRepository.save(student);
		//return null;
	}

	@Override
	public Student getStudentById(String id) {
		// TODO Auto-generated method stub
		 Optional<Student> studentOpt = studentRepository.findById(id);
		 if(!studentOpt.isPresent()) {
			 new UserNotFoundException("Student with id: "+id+" Not Found");
		 }
		 return studentOpt.get();
	}

	@Override
	public List<Student> getAllStudents() {
		 List<Student> students = studentRepository.findAll();
		 if(ObjectUtils.isEmpty(students)) {
			 return new ArrayList<Student>();
		 }
		return students;
	}

	@Override
	public void deleteStudentById(String id) {
		studentRepository.deleteById(id);
		
	}

	@Override
	public List<Student> getStudentsByName(String name) {
		return studentRepository.findByName(name);
	}

	@Override
	public List<Student> getStudentByNameAndEmail(String name, String email) {
		return studentRepository.findByNameAndEmail(name,email);
	}

	@Override
	public List<Student> getStudentByNameOrEmail(String name, String email) {
		return studentRepository.findByNameOrEmail(name,email);
	}

	@Override
	public List<Student> getAllStudentsWithPagination(int pageNo, int pageSize) {
		Pageable pageable=PageRequest.of(pageNo-1, pageSize);
		Page<Student> findAll = studentRepository.findAll(pageable);
		return findAll.getContent();
	}

	@Override
	public List<Student> getAllStudentsWithSorting() {
		Sort sort = Sort.by(Sort.Direction.ASC,"name");
		return studentRepository.findAll(sort);
	}

	@Override
	public List<Student> getAllStudentsByDepartmentName(String departmentName) {
		return studentRepository.findByDepartmentDepartmentName(departmentName);
	}

	@Override
	public List<Student> getAllStudentsbyEmailLike(String email) {
		return studentRepository.findByEmailIsLike(email);
	}

	@Override
	public List<Student> getAllStudentsbyNameStartWith(String name) {
		return studentRepository.findByNameStartsWith(name);
	}
}
