package net.javaguides.organizationservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.javaguides.organizationservice.dto.OrganizationDto;
import net.javaguides.organizationservice.entity.Organization;
import net.javaguides.organizationservice.mapper.OrganizationMapper;
import net.javaguides.organizationservice.repository.OrganizationReporsitory;
import net.javaguides.organizationservice.service.OrganizationService;

@Service
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	private OrganizationReporsitory organizationReporsitory;

	@Override
	public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
		// convert DTO into Jpa
		Organization organization=OrganizationMapper.mapToOrganization(organizationDto);
		Organization savedOrganization= organizationReporsitory.save(organization);
		return OrganizationMapper.mapToOrganizationDto(savedOrganization);
		
		 
	}

	@Override
	public OrganizationDto getOrganizationByCode(String organizationCode) {
		Organization organization=organizationReporsitory.findByOrganizationCode(organizationCode);
		OrganizationDto orgDto=OrganizationMapper.mapToOrganizationDto(organization);
		return orgDto;
	}

}
