package jframe;

import javax.swing.*;

import crudManagement.GenericOperation;
import crudManagement.IDAO_Crud;
import models.Student;

import java.awt.*;

public class StudentFrame {
    private JFrame frame;
    private JButton addButton, readButton, updateButton, deleteButton;
    private JTextField idField, nameField, lastnameField, ageField;
    private IDAO_Crud<Student> studentOp;

    public StudentFrame() {
        frame = new JFrame("Estudiante");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana
        frame.setSize(500, 500);

        idField = new JTextField();
        nameField = new JTextField();
        lastnameField = new JTextField();
        ageField = new JTextField();

        addButton = new JButton("Agregar");
        readButton = new JButton("Leer");
        updateButton = new JButton("Actualizar");
        deleteButton = new JButton("Eliminar");

        studentOp = new GenericOperation<>(Student.class);

        addButton.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String lastname = lastnameField.getText();
            int age = Integer.parseInt(ageField.getText());
            Student s = new Student(id, name, lastname, age);
            studentOp.create(s);
        });

        readButton.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            Student s = studentOp.read(id);
            nameField.setText(s.getName());
            lastnameField.setText(s.getLastname());
            ageField.setText(String.valueOf(s.getAge()));
        });

        updateButton.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String lastname = lastnameField.getText();
            int age = Integer.parseInt(ageField.getText());
            Student s = new Student();
            s.setAge(age);
            s.setLastname(lastname);
            s.setName(name);
            studentOp.update(s);
        });

        deleteButton.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            Student s = studentOp.read(id);
            studentOp.delete(s);
        });

        frame.getContentPane().setLayout(new GridLayout(9, 1)); // 9 filas, 1 columna
        frame.getContentPane().add(new JLabel("ID:"));
        frame.getContentPane().add(idField);
        frame.getContentPane().add(new JLabel("Nombre:"));
        frame.getContentPane().add(nameField);
        frame.getContentPane().add(new JLabel("Apellido:"));
        frame.getContentPane().add(lastnameField);
        frame.getContentPane().add(new JLabel("Edad:"));
        frame.getContentPane().add(ageField);
        frame.getContentPane().add(addButton);
        frame.getContentPane().add(readButton);
        frame.getContentPane().add(updateButton);
        frame.getContentPane().add(deleteButton);

        frame.setVisible(true);
    }
}

