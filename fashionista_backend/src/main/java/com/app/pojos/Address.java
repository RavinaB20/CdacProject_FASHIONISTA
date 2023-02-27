package com.app.pojos;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class Address {
	
	@Column(name="full_name", length=50)
	private String fullName;
	
	
	private Integer pincode;
	
	@Column(length = 20)
	private String state;
	
	@Column(length = 20)
	private String city;
	
	//house no, buildig no, company, apartment
	@Column(length = 100)
	private String houseNo;
	
	@Column(length = 100)
	private String area;

	@Column(name = "created_on")
	//@CreationTimestamp
	private LocalDateTime createdOn;
	
	@Column(name = "updated_on")
	//@UpdateTimestamp
	private LocalDateTime updatedOn;
	
}
