package jframe;

import javax.swing.*;
import java.awt.*;
import crudManagement.GenericOperation;
import crudManagement.IDAO_Crud;
import models.Professor;
import models.Schedule;
import models.Student;
import models.Subject;

public class ScheduleFrame {
    private JFrame frame;
    private JButton addButton, readButton, updateButton, deleteButton;
    private JTextField idField, subjectIdField, studentIdField, professorIdField, startTimeField, endTimeField, dayField;
    private IDAO_Crud<Schedule> scheduleOp;
    private IDAO_Crud<Subject> subjectOp;
    private IDAO_Crud<Student> studentOp;
    private IDAO_Crud<Professor> professorOp;

    public ScheduleFrame() {
        // Crear el frame
        frame = new JFrame("Horario");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana
        frame.setSize(500, 500);

        // Crear los campos de texto
        idField = new JTextField();
        subjectIdField = new JTextField();
        studentIdField = new JTextField();
        professorIdField = new JTextField();
        startTimeField = new JTextField();
        endTimeField = new JTextField();
        dayField = new JTextField();

        // Crear los botones
        addButton = new JButton("Agregar");
        readButton = new JButton("Leer");
        updateButton = new JButton("Actualizar");
        deleteButton = new JButton("Eliminar");

        // Crear las operaciones
        scheduleOp = new GenericOperation<>(Schedule.class);
        subjectOp = new GenericOperation<>(Subject.class);
        studentOp = new GenericOperation<>(Student.class);
        professorOp = new GenericOperation<>(Professor.class);

        // Añadir los listeners a los botones
        addButton.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            Subject subject = subjectOp.read(Integer.parseInt(subjectIdField.getText()));
            Student student = studentOp.read(Integer.parseInt(studentIdField.getText()));
            Professor professor = professorOp.read(Integer.parseInt(professorIdField.getText()));
            String startTime = startTimeField.getText();
            String endTime = endTimeField.getText();
            String day = dayField.getText();
            Schedule s = new Schedule(id, subject, student, professor, startTime, endTime, day);
            scheduleOp.create(s);
        });

        readButton.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            Schedule s = scheduleOp.read(id);
            subjectIdField.setText(String.valueOf(s.getSubject().getId()));
            studentIdField.setText(String.valueOf(s.getStudent().getId()));
            professorIdField.setText(String.valueOf(s.getProfessor().getId()));
            startTimeField.setText(s.getStartTime());
            endTimeField.setText(s.getEndTime());
            dayField.setText(s.getDay());
        });

        updateButton.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            Subject subject = subjectOp.read(Integer.parseInt(subjectIdField.getText()));
            Student student = studentOp.read(Integer.parseInt(studentIdField.getText()));
            Professor professor = professorOp.read(Integer.parseInt(professorIdField.getText()));
            String startTime = startTimeField.getText();
            String endTime = endTimeField.getText();
            String day = dayField.getText();
            Schedule s = new Schedule();
            s.setDay(day);
            s.setEndTime(endTime);
            s.setProfessor(professor);
            s.setStartTime(startTime);
            s.setStudent(student);
            s.setSubject(subject);
            scheduleOp.update(s);
        });

        deleteButton.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            Schedule s = scheduleOp.read(id);
            scheduleOp.delete(s);
        });

        // Añadir los campos de texto y botones al frame
        frame.getContentPane().setLayout(new GridLayout(16, 1)); // 16 filas, 1 columna
        frame.getContentPane().add(new JLabel("ID:"));
        frame.getContentPane().add(idField);
        frame.getContentPane().add(new JLabel("ID de la materia:"));
        frame.getContentPane().add(subjectIdField);
        frame.getContentPane().add(new JLabel("ID del estudiante:"));
        frame.getContentPane().add(studentIdField);
        frame.getContentPane().add(new JLabel("ID del profesor:"));
        frame.getContentPane().add(professorIdField);
        frame.getContentPane().add(new JLabel("Hora de inicio:"));
        frame.getContentPane().add(startTimeField);
        frame.getContentPane().add(new JLabel("Hora de fin:"));
        frame.getContentPane().add(endTimeField);
        frame.getContentPane().add(new JLabel("Día:"));
        frame.getContentPane().add(dayField);
        frame.getContentPane().add(addButton);
        frame.getContentPane().add(readButton);
        frame.getContentPane().add(updateButton);
        frame.getContentPane().add(deleteButton);

        // Hacer visible el frame
        frame.setVisible(true);
    }
}
