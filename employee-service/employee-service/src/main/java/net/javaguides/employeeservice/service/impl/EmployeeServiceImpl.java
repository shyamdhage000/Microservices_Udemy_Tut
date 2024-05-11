package net.javaguides.employeeservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import net.javaguides.employeeservice.dto.ApiResponseDto;
import net.javaguides.employeeservice.dto.DepartmentDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.dto.OrganizationDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.ApiClient;
import net.javaguides.employeeservice.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
//	@Autowired
//	private RestTemplate  restTemplate;
	
	@Autowired
	private WebClient webClient;
	
	@Autowired
	private ApiClient apiClient;
	
	

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employee) {
		Employee emp=new Employee(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail(),
				employee.getDepartmentCode(),
				employee.getOrganizationCode());
		
		Employee savedEmployee= employeeRepository.save(emp);
		
		EmployeeDto empDto=new EmployeeDto(
				savedEmployee.getId(),
				savedEmployee.getFirstName(),
				savedEmployee.getLastName(),
				savedEmployee.getEmail(),
				savedEmployee.getDepartmentCode(),
				savedEmployee.getOrganizationCode());
		return empDto;
	}

	@Override
	@CircuitBreaker(name="${spring.application.name}", fallbackMethod = "getDefaultDepartment")

	public ApiResponseDto getEmployeeById(Long id) {
		Employee employee= employeeRepository.findById(id).get();
		
		/* Call using Rest Template
	ResponseEntity<DepartmentDto>responseEntity=	restTemplate.getForEntity("http://localhost:8080/api/departments/getDepartment/" +employee.getDepartmentCode(),DepartmentDto.class);
		DepartmentDto departmentDto=responseEntity.getBody();*/
		
		/* call using WEb Client
		 *
	DepartmentDto departmentDto=	webClient.get()
			.uri("http://localhost:8080/api/departments/getDepartment/" +employee.getDepartmentCode())
			.retrieve()
			.bodyToMono(DepartmentDto.class)
			.block();
		 */
		
		//call using openfeign client
		DepartmentDto departmentDto= apiClient.getDepartment(employee.getDepartmentCode());
		
		
		// call using WEb Client
		 
	OrganizationDto organizationDto=	webClient.get()
			.uri("http://localhost:8083/api/organizations/"+employee.getOrganizationCode())
			.retrieve()
			.bodyToMono(OrganizationDto.class)
			.block();
		 
		
		
		EmployeeDto empDto=new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail(),
				employee.getDepartmentCode(),
				employee.getDepartmentCode());
	
		ApiResponseDto apiResponse=new ApiResponseDto();
		apiResponse.setEmployee(empDto);
		apiResponse.setDepartment(departmentDto);
		apiResponse.setOrganization(organizationDto);
		return apiResponse;
	}
	
	public ApiResponseDto getDefaultDepartment(Long id) {
Employee employee= employeeRepository.findById(id).get();


		DepartmentDto departmentDto=new DepartmentDto();
		departmentDto.setDepartmentName("R&D Dept");
		departmentDto.setDepartmentCode("R&D");
		departmentDto.setDepartmentDesc("Research & Development");
		
		EmployeeDto empDto=new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail(),
				employee.getDepartmentCode(),
				employee.getDepartmentCode());
	
		ApiResponseDto apiResponse=new ApiResponseDto();
		apiResponse.setEmployee(empDto);
		apiResponse.setDepartment(departmentDto);
		return apiResponse;
	}

}
