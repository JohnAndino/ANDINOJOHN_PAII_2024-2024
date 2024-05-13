package jframe;

import javax.swing.*;

import crudManagement.GenericOperation;
import crudManagement.IDAO_Crud;
import models.Professor;

import java.awt.*;

public class ProfessorFrame {
    private JFrame frame;
    private JButton addButton, readButton, updateButton, deleteButton;
    private JTextField idField, nameField, lastnameField, ageField;
    private IDAO_Crud<Professor> professorOp;

    public ProfessorFrame() {
        frame = new JFrame("Profesor");
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

        professorOp = new GenericOperation<>(Professor.class);

        addButton.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String lastname = lastnameField.getText();
            int age = Integer.parseInt(ageField.getText());
            Professor p = new Professor(id, name, lastname, age);
            professorOp.create(p);
        });

        readButton.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            Professor p = professorOp.read(id);
            nameField.setText(p.getName());
            lastnameField.setText(p.getLastname());
            ageField.setText(String.valueOf(p.getAge()));
        });

        updateButton.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String lastname = lastnameField.getText();
            int age = Integer.parseInt(ageField.getText());
            Professor p = new Professor();
            p.setAge(age);
            p.setLastname(lastname);
            p.setName(name);
            professorOp.update(p);
        });

        deleteButton.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            Professor p = professorOp.read(id);
            professorOp.delete(p);
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

