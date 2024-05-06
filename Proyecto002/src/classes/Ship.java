package classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import container.JWindow;
import interfaces.Dieable;
import interfaces.Drawable;
import interfaces.Movable;
import interfaces.Shootable;

public class Ship implements Drawable,Movable,Shootable,Dieable{
	
	private int naveX;
    private int naveY;
    private ArrayList<int[]> balas = new ArrayList<>();
    
    public Ship(int naveX, int naveY) {
    	this.naveX=naveX;
    	this.naveY=naveY;
    }

	@Override
	public void die(ActionEvent e) {
		if (naveY < 600 * 0.67) {
            naveX = -100; // Mueve la nave fuera de la pantalla
            ((Timer)e.getSource()).stop(); // Detiene el Timer
            JOptionPane.showMessageDialog(null, "Game Over");
        }
	}

	@Override
	public void shoot() {
		Iterator<int[]> iter = balas.iterator();
        while (iter.hasNext()) {
            int[] bala = iter.next();
            bala[1] -= 10;
            if (bala[1] < 0) {
                iter.remove();
            }
        }
	}

	@Override
	public void move(KeyEvent e) {
		switch (e.getKeyCode()) {
        case KeyEvent.VK_A: // Mover a la izquierda con la tecla 'A'
            naveX = Math.max(naveX - 20, 0);
            break;
        case KeyEvent.VK_D: // Mover a la derecha con la tecla 'D'
            naveX = Math.min(naveX + 20, 800 - 50);
            break;
        case KeyEvent.VK_W: // Mover hacia arriba con la tecla 'W'
            naveY = Math.max(naveY - 20, 0);
            break;
        case KeyEvent.VK_S: // Mover hacia abajo con la tecla 'S'
            naveY = Math.min(naveY + 20, 600 - 50);
            break;
        case KeyEvent.VK_SPACE: // Disparar con la tecla de espacio
            balas.add(new int[]{naveX + 20, naveY});
            break;
		}
	}

	@Override
	public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        int[] xPoints = {naveX, naveX + 15, naveX + 30};
        int[] yPoints = {naveY + 30, naveY, naveY + 30};
        g.fillPolygon(xPoints, yPoints, 3);
        
     // Dibujar balas (elipses blancas pequeñas)
        for (int[] bala : balas) {
            g.fillOval(bala[0], bala[1], 10, 15);
        }
	}

	@Override
	public void move(ActionEvent a) {
		// TODO Auto-generated method stub
		
	}

}
