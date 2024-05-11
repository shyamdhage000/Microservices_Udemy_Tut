package net.javaguides.organizationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.organizationservice.dto.OrganizationDto;
import net.javaguides.organizationservice.entity.Organization;

public interface OrganizationReporsitory extends  JpaRepository<Organization,Long> {

	Organization findByOrganizationCode(String organizationCode);
}
