package view;

import java.sql.SQLException;

import model.course.Horary;
import model.course.Subject;
import model.dataBaseManager.ConectToSQL;
import model.persons.Alumns;
import model.persons.Professor;

/**
 * @author John Andino
 * 
 * 
**/
public class Main {

	public static void main(String[] args) throws SQLException {

		// Agregamos estudiantes
		Alumns alumn1 = new Alumns(1, "Rigoberto", "Perez", 19);
		Alumns alumn2 = new Alumns(2, "Andrea", "Rodriguez", 23);
		Alumns alumn3 = new Alumns(3, "Diego", "Andino", 21);
		Alumns alumn4 = new Alumns(4, "Samanta", "Cadeno", 20);
        	//Por medio de la primera instancia creo la tabla
		 alumn1.createTable(ConectToSQL.getConnection());
		 	//Lo agregamos a la db
		 alumn1.aggregate(ConectToSQL.getConnection(), alumn1);
		 alumn2.aggregate(ConectToSQL.getConnection(), alumn2);
		 alumn3.aggregate(ConectToSQL.getConnection(), alumn3);
		 alumn4.aggregate(ConectToSQL.getConnection(), alumn4);
		
		 //alumn1.update(ConectToSQL.getConnection(),alumn2, alumn2.getId()); //Actualizar
		 //alumn1.delete(ConectToSQL.getConnection(), 1); //borrar
		 //alumn1.read(ConectToSQL.getConnection(), alumn1,1); //Mostrar en consola

		// Agregamos Profesores
		Professor teacher1 = new Professor(1, "Ernesto", "Chicaiza", 35);
		Professor teacher2 = new Professor(2, "Antonio", "Garcia", 55);
	        //Por medio de la primera instancia creo la tabla
		teacher1.createTable(ConectToSQL.getConnection());
		 	//Lo agregamos a la db
		teacher1.aggregate(ConectToSQL.getConnection(), teacher1);
		teacher2.aggregate(ConectToSQL.getConnection(), teacher2);
			
		 //teacher1.update(ConectToSQL.getConnection(),teacher2, teacher2.getId()); //Actualizar
		 //teacher1.delete(ConectToSQL.getConnection(), 1); //borrar
		 //teacher1.read(ConectToSQL.getConnection(), teacher1,1); //Mostrar en consola

		// Agregampos materias
		Subject subject = new Subject(1, "Biologia", "Materia para aprender sobre  los seres vivos", 2);
		
		// Por medio de la instancia creo la tabla
		subject.createTable(ConectToSQL.getConnection());
		
		//La agrego a la DB
		subject.aggregate(ConectToSQL.getConnection(), subject);
		
		Horary horary1 = new Horary(subject.getId(), alumn1.getId(), teacher1.getId(), "9", "11", "Lunes");
		horary1.createTable(ConectToSQL.getConnection());
		horary1.aggregate(ConectToSQL.getConnection(), horary1);

	}

}
