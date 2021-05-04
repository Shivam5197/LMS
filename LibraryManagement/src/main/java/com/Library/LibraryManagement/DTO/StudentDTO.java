package com.Library.LibraryManagement.DTO;

import java.sql.Timestamp;

public class StudentDTO {

	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private Integer course;
	private String dateOfBirth;
	private Integer status;
	private Timestamp addedAt;
	private String userName;
	private String Password;
	private Integer userType;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Integer getCourse() {
		return course;
	}
	public void setCourse(Integer course) {
		this.course = course;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Timestamp getAddedAt() {
		return addedAt;
	}
	public void setAddedAt(Timestamp addedAt) {
		this.addedAt = addedAt;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"firstName\":\"" + firstName + "\", \"lastName\":\"" + lastName
				+ "\", \"email\":\"" + email + "\", \"course\":\"" + course + "\", \"dateOfBirth\":\"" + dateOfBirth
				+ "\", \"status\":\"" + status + "\", \"addedAt\":\"" + addedAt + "\", \"userName\":\"" + userName
				+ "\", \"Password\":\"" + Password + "\", \"userType\":\"" + userType + "\"}";
	}
	
}
