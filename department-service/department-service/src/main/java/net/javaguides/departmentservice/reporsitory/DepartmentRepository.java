package net.javaguides.departmentservice.reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

	Department findByDepartmentCode(String departmentCode);
}
