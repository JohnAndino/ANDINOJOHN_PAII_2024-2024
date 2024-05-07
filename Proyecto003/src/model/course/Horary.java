package model.course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controller.IDAO_Horary;

public class Horary implements IDAO_Horary{

	private int id_subject;
	private int id_alumn;
	private int id_professor;
	private String start_time;
	private String end_time;
	private String day;
	private PreparedStatement ps;

	public Horary(int id_mat, int id_alumno, int id_profesor, String start_time, String end_time, String day) {
		this.id_subject = id_mat;
		this.id_alumn = id_alumno;
		this.id_professor = id_profesor;
		this.start_time = start_time;
		this.end_time = end_time;
		this.day = day;
	}

	@Override
	public void aggregate(Connection connection, Horary horary) throws SQLException {
		ps = connection.prepareStatement("INSERT INTO horary (id_alumn, id_professor, id_subject, start_time,end_time, day) VALUES (?,?,?,?,?,?)");
		ps.setInt(3, horary.getId_subject());
		ps.setInt(1, horary.getId_alumn());
		ps.setInt(2, horary.getId_professor());
		ps.setString(4, horary.getStart_time());
		ps.setString(5, horary.getEnd_time());
		ps.setString(6, horary.getDay());
		ps.execute();
		ps.close();
		
	}

	@Override
	public Horary read(Connection connection, Horary horary, int id_horary) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Connection connection, Horary horary, int id_horary) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Connection connection, int id_horary) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createTable(Connection connection) throws SQLException {
	    String query = "CREATE TABLE IF NOT EXISTS horary ( " 
	                 + "id_alumn INT,"
	                 + "id_professor INT,"
	                 + "id_subject INT,"
	                 + "start_time VARCHAR(10)," 
	                 + "end_time VARCHAR(10)," 
	                 + "day VARCHAR(10),"
	                 + "FOREIGN KEY (id_alumn) REFERENCES Alumns(id)," 
	                 + "FOREIGN KEY (id_professor) REFERENCES Professors(id),"
	                 + "FOREIGN KEY (id_subject) REFERENCES Subject(id)" + ")";
	    connection.createStatement().executeUpdate(query);
	    System.out.println("\nLa tabla ah sido creada con exito");
	}

	public int getId_subject() {
		return id_subject;
	}

	public void setId_subject(int id_subject) {
		this.id_subject = id_subject;
	}

	public int getId_alumn() {
		return id_alumn;
	}

	public void setId_alumn(int id_alumn) {
		this.id_alumn = id_alumn;
	}

	public int getId_professor() {
		return id_professor;
	}

	public void setId_professor(int id_professor) {
		this.id_professor = id_professor;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
	

	
}
