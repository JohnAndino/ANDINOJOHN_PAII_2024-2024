package container;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import classes.LifeBar;
import classes.Line;
import classes.Score;
import classes.Ship;
import classes.Villain;

public class JWindow extends JPanel{
	public int high;
	public int width;
	private KeyEvent keyEvent;
	private ActionEvent action;
	private boolean gameOver=false;
	JFrame window = new JFrame("Galaga Invaders");
	Ship ship = new Ship(375, 450);
	Villain alien = new Villain(11);
	Container container = new Container();
	
	
	public JWindow(int width, int high) {
		this.high=high;
		this.width=width;
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setSize(width, high);
        window.add(this);
        window.setVisible(true);
        this.requestFocusInWindow();
        this.moveComponent();
        this.logicComponent();
	}
	
	public void moveComponent() {
		setFocusable(true); //Espera eventos por teclado
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
            	//movimiento de la nave
            	container.move(ship,e);
                repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
        
        
        new Timer(75, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent a) {
				//Movimiento de los aliens
				container.move(alien,a);
				repaint();
			}
			
        }).start();
	}
	
	public void logicComponent() {
		new Timer(50, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent a) {
				//Disparo de la nave
            	container.shoot(ship);
            	//Evento para GameOver
            	container.die(ship, a);
				repaint();
			}
			
        }).start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Configurar el fondo en negro
        setBackground(Color.BLACK);
        
        // Dibujar una nave en la posicion que mande
        container.draw(ship,g);
        
        
        //Dibuja la vida del jugador (del 1 al 10)
        container.draw(new LifeBar(10),g);
        
     // Dibujar a los enemigos
        container.draw(alien,g);
        
     // Dibuja la línea de límite de seguridad
        container.draw(new Line(),g); 
        
        //Dibujar puntaje
        container.draw(new Score(), g);
     
    }
	
}
