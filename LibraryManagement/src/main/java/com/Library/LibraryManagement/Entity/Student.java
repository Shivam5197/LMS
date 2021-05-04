package com.Library.LibraryManagement.Entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.Library.LibraryManagement.DTO.StudentDTO;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="student_email")
	private String email;
	@Column(name="student_course")
	private Integer course;
	@Column(name="date_of_birth")
	private String dateOfBirth;
	@Column(name="student_status")
	private Integer status;
	@Column(name="added_at")
	private Timestamp addedAt;
	@Column(name="user_name")
	private String userName;
	@Column(name="password")
	private String password;
	@Column(name="user_type")
	private Integer userType;
	
	@ManyToMany(mappedBy = "students",fetch = FetchType.EAGER)
	private List<Books> books;
	
	public Student() {
	//Empty Constructor	
	}

	public Student(String firstName,Integer userType ,String userName,String Password,String lastName, 
			String email, Integer course,String dateOfBirth,Integer status,Timestamp addedAt) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.course = course;
		this.dateOfBirth = dateOfBirth;
		this.status = status;
		this.addedAt = addedAt;
		this.userName = userName;
		this.userType =userType;
	}

	public Student(StudentDTO userDto) {
		this.email =userDto.getEmail();
		this.userName =userDto.getUserName();
	}
	
	
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

	public List<Books> getBooks() {
		return books;
	}

	public void setBooks(List<Books> books) {
		this.books = books;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public void removeBook(Books boo) {
		this.books.remove(boo);
		boo.getStudents().remove(this);
	}

	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"firstName\":\"" + firstName + "\", \"lastName\":\"" + lastName
				+ "\", \"email\":\"" + email + "\", \"course\":\"" + course + "\", \"dateOfBirth\":\"" + dateOfBirth
				+ "\", \"status\":\"" + status + "\", \"addedAt\":\"" + addedAt + "\", \"userName\":\"" + userName
				+ "\", \"Password\":\"" + password + "\", \"userType\":\"" + userType + "\"}";
	}

}
