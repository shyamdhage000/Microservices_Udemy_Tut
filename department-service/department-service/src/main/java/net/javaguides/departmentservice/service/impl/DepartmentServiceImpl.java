package net.javaguides.departmentservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.reporsitory.DepartmentRepository;
import net.javaguides.departmentservice.service.DepartmentService;

@Service
public class DepartmentServiceImpl  implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		//convert dept dto to jpa entiry
		Department department=new Department(
				departmentDto.getId(),
				departmentDto.getDepartmentName(),
				departmentDto.getDepartmentDesc(),
				departmentDto.getDepartmentCode());
	Department savedDepartment=	departmentRepository.save(department);
	DepartmentDto departmentDto2=new  DepartmentDto(
			savedDepartment.getId(),
			savedDepartment.getDepartmentName(),
			savedDepartment.getDepartmentDesc(),
			savedDepartment.getDepartmentCode());
		
		return departmentDto2;
	}

	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) {
		Department department=departmentRepository.findByDepartmentCode(departmentCode);
		DepartmentDto dept=new DepartmentDto(
				department.getId(),
				department.getDepartmentName(),
				department.getDepartmentDesc(),
				department.getDepartmentCode());
		return dept;
	}

}
