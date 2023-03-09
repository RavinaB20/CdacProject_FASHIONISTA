package com.app.dto;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.app.pojos.BaseEntity;
import com.app.pojos.Role;
import com.app.pojos.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
//user : one , parent , inverse : since DOES NOT FK

public class UserDto extends BaseEntity {

	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = "Blank or Invalid Password!!!!")
	private String password;
	
	private Role userRole;
	
	private Long mobileNo;
	
	private LocalDate dob;

	public UserDto() {
	}

	public UserDto(User user) {
		
		super();
		this.setId(user.getId());
		//this.userId = user.getId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.userRole = user.getUserRole();
		this.dob = user.getDob();
		this.mobileNo = user.getMobileNo();
	}
		
	public UserDto(String firstName, String lastName, 			@NotBlank(message = "Email can't be blank!") 
	@Email(message = "Invalid Email Format") 
	@Length(min = 5, max = 20, message = "Invalid Email length!!!!!!!") String email, @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = "Blank or Invalid Password!!!!") String password, LocalDate dob, Long mobileNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.userRole = Role.CUSTOMER;
		this.dob = dob;
		this.mobileNo = mobileNo;		
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "User Id " + getId() + " [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", userRole=" + userRole + ", dob=" + dob + "]";
	}

}