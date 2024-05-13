package jframe;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private JFrame frame;
    private JButton studentButton, professorButton, subjectButton, scheduleButton;

    public MainFrame() {
    	
        frame = new JFrame("Conextion to MySQL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        studentButton = new JButton("Estudiante");
        professorButton = new JButton("Profesor");
        subjectButton = new JButton("Materia");
        scheduleButton = new JButton("Horario");

        studentButton.addActionListener(e -> {
            new StudentFrame();
        });
        professorButton.addActionListener(e -> {
            new ProfessorFrame();
        });
        subjectButton.addActionListener(e -> {
            new SubjectFrame();
        });
        scheduleButton.addActionListener(e -> {
            new ScheduleFrame();
        });

        frame.getContentPane().setLayout(new GridLayout(4, 1)); // 4 filas, 1 columna
        frame.getContentPane().add(studentButton);
        frame.getContentPane().add(professorButton);
        frame.getContentPane().add(subjectButton);
        frame.getContentPane().add(scheduleButton);

        frame.setVisible(true);
    }
}

