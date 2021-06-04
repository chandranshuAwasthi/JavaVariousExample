
package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Guide;
import entity.Student;

import java.util.Set;

public class NPlus1SelectsProblemClient {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();

			/*//Adding data to guide and student table by adding a Guide and associating a Student with it
			Guide guide = new Guide("2000DO10777", "David Crow", 3000);
			Student student = new Student("2014RG50347", "Rahul Singh");
			guide.addStudent(student);
			em.persist(guide);

            */ //Adding data to guide and student table by adding a Guide and associating a Student with it
			//Guide guide = new Guide("2000DO10777", "David Crow", 3000);
			/*Student student = new Student("2014RG50347", "Rahul Singh");
			Guide guide = new Guide("2000DO10777", "David Crow", 3000);
			guide.addStudent(student);
			em.persist(guide);*/
			// Finding the guide and adding student and persist

//			Guide guide= em.find(Guide.class,53l);
//			Set<Student> setOfStudent = guide.getStudents();
//			Student student = new Student("2014RG50397", "MEDHA MISHRA");
//			guide.addStudent(student);
//			em.persist(guide);


			//finding and merging
			Guide guide= em.find(Guide.class,53l);
			Set<Student> setOfStudent = guide.getStudents();
			Student student=null;
			for(Student stud:setOfStudent){
				if("2014RG50347".equalsIgnoreCase(stud.getEnrollmentId())){
					student=stud;
				}
			}
            student.setEnrollmentId("2014RG50347chan");

			//Student student = new Student("2014RG50397", "MEDHA MISHRA");
			//guide.addStudent(student);
			//em.persist(guide);



			//Loading all the student objects
			/*
			Query query = em.createQuery("select student from Student student");
			List<Student> students = query.getResultList();	

			for (Student student : students) {
				System.out.println(student.getName() + ": " + student.getEnrollmentId());
			}  
			*/

			//Loading all the students with their associated Guide objects with the Student objects selectively (whenever you need to load them eagerly)
			/*
			Query query = em.createQuery("select student from Student student left join fetch student.guide");
			List<Student> students = query.getResultList();	

			for (Student student : students) {
				//students who do not have a guide will not be loaded
				if(student.getGuide() != null) {				
					System.out.println(student.getName() + ": " + student.getEnrollmentId() + ": " + student.getGuide().getName());
				}
			}  		
			*/

			txn.commit();			
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}

	}
}














