package net.javaguides.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import net.javaguides.employeeservice.dto.DepartmentDto;
import net.javaguides.employeeservice.dto.OrganizationDto;

//Used to call another MS manually 
//@FeignClient(url="http://localhost:8080", value="Department-Service")

//it will call automatically instance of Dept service which is Up or running
@FeignClient(name="Department-Service")
public interface ApiClient {
	@GetMapping("/api/departments/{departmentCode}")
 DepartmentDto getDepartment(@PathVariable String departmentCode);
	
}

//@FeignClient(name="Organization-Service")
// interface OrgFeignClient {
//	
//	@GetMapping("/api/organizations/{organizationCode}")
//	OrganizationDto getOrganization(@PathVariable String organizationCode);
//
//}