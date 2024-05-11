package net.javaguides.organizationservice.mapper;

import net.javaguides.organizationservice.dto.OrganizationDto;
import net.javaguides.organizationservice.entity.Organization;

public class OrganizationMapper {
	
	public static OrganizationDto mapToOrganizationDto(Organization organization) {
		OrganizationDto organizationDto=new OrganizationDto();
		organizationDto.setId(organization.getId());
		organizationDto.setOrganizationName(organization.getOrganizationName());
		organizationDto.setOrganizationCode(organization.getOrganizationCode());
		organizationDto.setOrganizationCreatedDate(organization.getOrganizationCreatedDate());
		organizationDto.setOrganizationDescription(organization.getOrganizationDescription());
		return organizationDto;
	}
	
	public static Organization mapToOrganization(OrganizationDto organizationDto) {
		Organization organization=new Organization();
		organization.setId(organizationDto.getId());
		organization.setOrganizationName(organizationDto.getOrganizationName());
		organization.setOrganizationCode(organizationDto.getOrganizationCode());
		organization.setOrganizationCreatedDate(organizationDto.getOrganizationCreatedDate());
		organization.setOrganizationDescription(organizationDto.getOrganizationDescription());
		return organization;
	}

}
