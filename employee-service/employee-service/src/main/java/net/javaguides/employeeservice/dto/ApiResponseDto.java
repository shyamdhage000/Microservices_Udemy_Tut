package net.javaguides.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseDto {
	private EmployeeDto employee;
	private DepartmentDto department;
	private OrganizationDto organization;

}
