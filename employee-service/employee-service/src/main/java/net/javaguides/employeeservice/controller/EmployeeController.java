package net.javaguides.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.employeeservice.dto.ApiResponseDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("addEmployee")
	public ResponseEntity<EmployeeDto> saveEmplpoyee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto empDto=employeeService.saveEmployee(employeeDto);
		return new ResponseEntity<>(empDto, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ApiResponseDto> getEmplpoyee(@PathVariable Long id){
		ApiResponseDto apiDto=employeeService.getEmployeeById(id);
		
		return new ResponseEntity<>(apiDto, HttpStatus.OK);
	}
}
