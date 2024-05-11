package net.javaguides.organizationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.javaguides.organizationservice.dto.OrganizationDto;
import net.javaguides.organizationservice.service.OrganizationService;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("api/organizations")
public class OrganizationController {
	@Autowired
	private OrganizationService organizationService;
	
	@PostMapping
	public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
		OrganizationDto savedDto=organizationService.saveOrganization(organizationDto);
		return new ResponseEntity<>(savedDto,HttpStatus.CREATED);
	}
	
	@GetMapping("{code}")
	public ResponseEntity<OrganizationDto>getOrganization(@PathVariable("code") String  organizationCode){
		OrganizationDto organizationDto=organizationService.getOrganizationByCode(organizationCode);
		return new ResponseEntity<>(organizationDto,HttpStatus.OK);
	}
	
	
	
	
	
}
