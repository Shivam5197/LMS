package com.Library.LibraryManagement.Serviceimpl;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;

import com.Library.LibraryManagement.Entity.Books;
import com.Library.LibraryManagement.Entity.Student;
import com.Library.LibraryManagement.Service.StudentService;
import com.Library.LibraryManagement.Utils.Constants;

@Repository
public class StudentServiceImpl implements StudentService {

	private static final Logger LOGGER = LogManager.getLogger(StudentServiceImpl.class);

	private EntityManager entityManage;
	
	public StudentServiceImpl (){
		
	}
	
	@Autowired
	public StudentServiceImpl(EntityManager entityManager) {
		this.entityManage = entityManager;
	}
	
	@Override
	@Transactional
	public void SaveStudent(Student student) {
//		LOGGER.info("DETAILS YOU ENTERED ::::::::::::::: " + student);
		try {
			if(student !=null) {
				if(student.getDateOfBirth()!=null&&
						student.getCourse()!=null &&
						student.getFirstName()!=null &&
						student.getLastName()!=null &&
						student.getEmail()!=null && student.getUserName()  !=null &&
						student.getPassword() !=null && student.getUserType() !=null) {
					student.setStatus(Constants.StudentStatus.ACTIVE);
					student.setPassword(new BCryptPasswordEncoder().encode(student.getPassword()));
					student.setUserType(student.getUserType());
					student.setAddedAt(new java.sql.Timestamp(System.currentTimeMillis()));

					entityManage.merge(student);
				}else {
					LOGGER.info("Please Enter the Missing Data");
				}
			}else {
				LOGGER.info("This is Empty Student......Please fill data in It");	
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info("The Exectption occureed in Save Student Service Impl");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Student> getListOfStudent(Student studentModel) {
		List<Student> students =null;
		try {
			
			StringBuilder stringBuild = new StringBuilder("SELECT s FROM Student s WHERE s.id !=0 AND s.status="+Constants.StudentStatus.ACTIVE);
			if(studentModel !=null) {
				if(studentModel.getId()!=null) {
					stringBuild.append("AND s.id =:id");
				}
				if(studentModel.getCourse()!=null) {
					stringBuild.append("AND s.course =:course");
				}
				if(studentModel.getFirstName()!=null) {
					stringBuild.append("AND s.firstName =:firstName");
				}
				if(studentModel.getLastName()!=null) {
					stringBuild.append("AND s.lastName =:lastName");
				}
				if(studentModel.getEmail()!=null) {
					stringBuild.append("AND s.email =:email");
				}
				if(studentModel.getDateOfBirth()!=null) {
					stringBuild.append("AND s.dateOfBirth =:dateOfBirth");
				}
				if(studentModel.getStatus()!=null) {
					stringBuild.append("AND s.status =:status");
				}
				if(studentModel.getAddedAt()!=null) {
					stringBuild.append("AND s.addedAt =:addedAt");
				}
				if(studentModel.getUserName()!=null) {
					stringBuild.append("AND s.userName =:userName");
				}
				if(studentModel.getPassword()!=null) {
					stringBuild.append("AND s.password =:password");
				}
				if(studentModel.getUserType()!=null) {
					stringBuild.append("AND s.userType =:userType");
				}
			}else {
				throw new Exception("Model is null  ===================" );
			}
			Query query = entityManage.createQuery(stringBuild.toString());
			
			if(studentModel !=null) {
				if(studentModel.getId()!=null) {
					query.setParameter("id", studentModel.getId());
				}
				if(studentModel.getCourse()!=null) {
					query.setParameter("course", studentModel.getCourse());
				}
				if(studentModel.getFirstName()!=null) {
					query.setParameter("firstName", studentModel.getFirstName());
				}
				if(studentModel.getLastName()!=null) {
					query.setParameter("lastName", studentModel.getLastName());
				}
				if(studentModel.getEmail()!=null) {
					query.setParameter("email", studentModel.getEmail());
				}
				if(studentModel.getDateOfBirth()!=null) {
					query.setParameter("dateOfBirth", studentModel.getDateOfBirth());
				}
				if(studentModel.getStatus()!=null) {
					query.setParameter("status", studentModel.getStatus());
				}
				if(studentModel.getAddedAt()!=null) {
					query.setParameter("addedAt", studentModel.getAddedAt());
				}
				if(studentModel.getUserName()!=null) {
					query.setParameter("userName", studentModel.getUserName());
				}
				if(studentModel.getPassword()!=null) {
					query.setParameter("password", studentModel.getPassword());
				}
				if(studentModel.getUserType()!=null) {
					query.setParameter("userType", studentModel.getUserType());
				}
			}
			students = query.getResultList();
		}catch(Exception exe) {
			exe.printStackTrace();
		}
		LOGGER.info("Students are Returned  : " + students);
		return students;
	}
	
	@Override
	@Transactional
	public Student getStudentByID(Integer id) {
		Student student =null;
		try {
			if(id!=null) {
				student = entityManage.find(Student.class,id);
			}
		}catch(Exception e) {
			e.printStackTrace();
			LOGGER.info("Exception occiured in Get by ID method ");
		}
		return student;
	}

	@Override
	@Transactional
	public void softDeleteStudent(Integer id) {
		Student student =null;
		try {
			if(id!=null) {
				student = entityManage.find(Student.class,id);
				student.setStatus(Constants.StudentStatus.DEACTIVATED);
			}
		}catch(Exception e) {
			e.printStackTrace();
			LOGGER.info("Exception occiured in Get by ID method ");
		}
	}

	@Override
	@Transactional
	public void issueBook(Student student, Books book) {
		try {
			if(book !=null && student !=null) {
				book.getStudents().add(student);
				book.setBookInStock(book.getBookInStock()-1);
			}
			entityManage.merge(book);
		}catch(IllegalStateException ix) {
			LOGGER.info("You already have this Book ISsued");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public void returnBok(Student student, Books book) {
		try {
				 if(student !=null && book !=null) {
		             Student entityStudent = entityManage.getReference( Student.class, student.getId());
		             Books entityBook = entityManage.getReference( Books.class, book.getId());
//		             entityStudent.removeBook(entityBook);
		             entityBook.removeBook(entityStudent);
		             book.setBookInStock(book.getBookInStock()+1);
				 }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	@Transactional
	public Boolean checkifUserNameExists (String studentUserName) throws NoResultException {
		LOGGER.info("Inside CheckUserNAme MEthod");
		Boolean istrue= false;
		try {
			if(studentUserName !=null) {
				Query query = entityManage.createQuery("SELECT s FROM Student s WHERE s.userName =: studentUser ");
				query.setParameter("studentUser", studentUserName);
				Object stundent = 	query.getSingleResult();
				Student stuuserName = (Student) stundent;
				if(stuuserName.getUserName().equals(studentUserName)) {
					LOGGER.info("Username Exists in the DB +++++++++++++++++++++");
					istrue = true;
				}else {
					istrue = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info("Exception in CheckMEthod +++++++++++ " + e.getMessage());
		}
		return istrue;
	}

	
}
