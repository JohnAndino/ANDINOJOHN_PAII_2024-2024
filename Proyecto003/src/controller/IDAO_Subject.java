package controller;

import java.sql.Connection;
import java.sql.SQLException;

import model.course.Subject;

public interface IDAO_Subject {
	
	public void aggregate(Connection connection, Subject subject) throws SQLException;

	public Subject read(Connection connection, Subject subject, int id_subject) throws SQLException;

	public void update(Connection connection,  Subject subject, int id_subject)throws SQLException;

	public void delete(Connection connection, int id_subject)throws SQLException;
	
	public void createTable(Connection connection) throws SQLException;

}
