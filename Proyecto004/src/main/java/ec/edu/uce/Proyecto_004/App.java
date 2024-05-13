package ec.edu.uce.Proyecto_004;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import crudManagement.IDAO_Crud;
import jframe.MainFrame;
import crudManagement.GenericOperation;
import models.Professor;
import models.Schedule;
import models.Student;
import models.Subject;

/**
 * 
 * @author John Andino
 * 
 */
public class App {
	public static void main(String[] args) {
//		IDAO_Crud<Student> studentOp = new GenericOperation<>(Student.class);
//		IDAO_Crud<Professor> professorOp = new GenericOperation<>(Professor.class);
//		IDAO_Crud<Subject> subjectOp = new GenericOperation<>(Subject.class);
//		IDAO_Crud<Schedule> ScheduleOp = new GenericOperation<>(Schedule.class);
//
//		// create student
//		Student s = new Student(103, "John", "Andino", 23);
//		studentOp.create(s);
//
//		// read student
//		s = studentOp.read(101);
//		System.out.println(s);
//
//		// update student
//		s.setAge(24);
//		studentOp.update(s);
//		System.out.println(s);
//
//		// delete student
//		studentOp.delete(s);
//
//		((GenericOperation<Student>) studentOp).close();
//		
//		// Crete Professor
//		Professor p2 = new Professor(1000, "Diego", "Almaro", 33);
//		professorOp.create(p2);
//
//		// read professor
//		p2 = professorOp.read(101);
//		System.out.println(p2);
//
//		((GenericOperation<Professor>) professorOp).close();
		MainFrame app = new MainFrame();
	}
}
