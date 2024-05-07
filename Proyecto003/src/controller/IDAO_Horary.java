package controller;

import java.sql.Connection;
import java.sql.SQLException;

import model.course.Horary;

public interface IDAO_Horary {
	
	public void aggregate(Connection connection, Horary schedule) throws SQLException;

	public Horary read(Connection connection, Horary schedule, int id_schedule) throws SQLException;

	public void update(Connection connection,  Horary schedule, int id_schedule)throws SQLException;

	public void delete(Connection connection, int id_schedule)throws SQLException;
	
	public void createTable(Connection connection) throws SQLException;

}
