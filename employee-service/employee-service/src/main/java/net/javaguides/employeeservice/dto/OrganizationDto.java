package net.javaguides.employeeservice.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {
	
	private Long id;
	private String organizationName;
	private String organizationDescription;
	private String organizationCode;
	private LocalDateTime organizationCreatedDate;

}

