package jframe;

import javax.swing.*;

import crudManagement.GenericOperation;
import crudManagement.IDAO_Crud;
import models.Subject;

import java.awt.*;

public class SubjectFrame {
    private JFrame frame;
    private JButton addButton, readButton, updateButton, deleteButton;
    private JTextField idField, nameField, descriptionLevel, levelField;
    private IDAO_Crud<Subject> subjectOp;

    public SubjectFrame() {
        frame = new JFrame("Materia");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana
        frame.setSize(500, 500);

        idField = new JTextField();
        nameField = new JTextField();
        descriptionLevel = new JTextField();
        levelField = new JTextField();

        addButton = new JButton("Agregar");
        readButton = new JButton("Leer");
        updateButton = new JButton("Actualizar");
        deleteButton = new JButton("Eliminar");

        subjectOp = new GenericOperation<>(Subject.class);

        addButton.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String description = nameField.getText();
            int level = Integer.parseInt(levelField.getText());
            Subject s = new Subject(id, name, description, level);
            subjectOp.create(s);
        });

        readButton.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            Subject s = subjectOp.read(id);
            nameField.setText(s.getName());
            descriptionLevel.setText(s.getName());
            levelField.setText(String.valueOf(s.getLevel()));
        });

        updateButton.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String description = nameField.getText();
            int level = Integer.parseInt(levelField.getText());
            Subject s = new Subject();
            s.setName(name);
            s.setDescription(description);
            s.setLevel(level);
            subjectOp.update(s);
        });

        deleteButton.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            Subject s = subjectOp.read(id);
            subjectOp.delete(s);
        });

        frame.getContentPane().setLayout(new GridLayout(8, 1)); // 8 filas, 1 columna
        frame.getContentPane().add(new JLabel("ID:"));
        frame.getContentPane().add(idField);
        frame.getContentPane().add(new JLabel("Nombre:"));
        frame.getContentPane().add(nameField);
        frame.getContentPane().add(new JLabel("Descripcion:"));
        frame.getContentPane().add(levelField);
        frame.getContentPane().add(new JLabel("Level:"));
        frame.getContentPane().add(levelField);
        frame.getContentPane().add(addButton);
        frame.getContentPane().add(readButton);
        frame.getContentPane().add(updateButton);
        frame.getContentPane().add(deleteButton);

        frame.setVisible(true);
    }
}
