package controller;

import java.sql.Connection;
import java.sql.SQLException;

import model.persons.Person;

public interface IDAO_Person {
	
	public void aggregate(Connection connection, Person person) throws SQLException;
	public void delete(Connection connection, int id_person)throws SQLException;
	public Person read(Connection connection, Person person, int id_person) throws SQLException;
	public void update(Connection connection,  Person person, int id_person)throws SQLException;	
	public void createTable(Connection connection) throws SQLException;


}
