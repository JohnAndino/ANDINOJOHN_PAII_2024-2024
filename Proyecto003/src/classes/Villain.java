package classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

import interfaces.Dieable;
import interfaces.Drawable;
import interfaces.Movable;
import interfaces.Shootable;

public class Villain implements Drawable,Dieable,Movable,Shootable{

    private int[] aliensX;
    private int aliensY;
    private int directionAliens = 1;
    private int speedAliens = 5;
    
    public Villain(int aliens) {
    	aliensX = new int[aliens];
    	aliensY = 50;
    	//Numero de aliens dibujados
    	for (int i = 0; i < aliensX.length; i++) {
            aliensX[i] = 50 + i * 60;
        }
    }

	@Override
	public void shoot() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(ActionEvent a) {
		for (int i = 0; i < aliensX.length; i++) {
            aliensX[i] += directionAliens * speedAliens;
        }

        if (aliensX[aliensX.length - 1] > 780 - 50 || aliensX[0] < 0) {
            directionAliens *= -1;
            aliensY += 10;
        }
	}

	@Override
	public void die(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
        for (int i = 0; i < aliensX.length; i++) {
            g.fillRect(aliensX[i], aliensY, 50, 50);
        }
        
	}

	@Override
	public void move(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
