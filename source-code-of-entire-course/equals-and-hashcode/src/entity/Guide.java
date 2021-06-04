package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Guide {

	//for Hibernate 4.3.x Users
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	
	// for Hibernate 5.x Users
	// if you're using Hibernate 5.x, use GenerationType.IDENTITY id generator strategy explicitly
	// for more information on "GenerationType" have a look at https://www.udemy.com/hibernate-and-jpa-fundamentals/learn/v4/questions/937412
	/*
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	*/
	
	@Column(name="staff_id", nullable=false)
	private String staffId;	
	
	private String name;
	private Integer salary;
	
	@OneToMany(mappedBy="guide")
	private Set<Student> students = new HashSet<Student>();	
	
	public Guide() {}
	public Guide(String staffId, String name, Integer salary) {
		this.staffId = staffId;
		this.name = name;
		this.salary = salary;
	}
	
	public Set<Student> getStudents() {
		return students;
	}	
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	public void addStudent(Student student) {
		students.add(student);
		student.setGuide(this);
	}
//	@Override
//	public String toString() {
//		return "Guide [id=" + id + ", staffId=" + staffId + ", name=" + name	+ ", salary=" + salary + "]";
//	}
	/*@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Guide guide = (Guide) o;

		return staffId != null ? staffId.equals(guide.staffId) : guide.staffId == null;
	}

	@Override
	public int hashCode() {
		return staffId != null ? staffId.hashCode() : 0;
	}*/
}






































