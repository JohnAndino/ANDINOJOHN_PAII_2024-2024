package models;

public class Schedule {

	private int id;

	private Subject subject;

	private Student student;

	private Professor professor;

	private String startTime;

	private String endTime;

	private String day;
	
	public Schedule() {
		// TODO Auto-generated constructor stub
	}

	public Schedule(int id, Subject subject, Student student, Professor professor, String startTime, String endTime,
			String day) {
		super();
		this.id = id;
		this.subject = subject;
		this.student = student;
		this.professor = professor;
		this.startTime = startTime;
		this.endTime = endTime;
		this.day = day;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", subject=" + subject + ", student=" + student + ", professor=" + professor
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", day=" + day + "]";
	}
	

}
