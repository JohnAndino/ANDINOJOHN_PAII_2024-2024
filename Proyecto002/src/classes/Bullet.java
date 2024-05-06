package classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

import interfaces.Drawable;
import interfaces.Movable;
 
public class Bullet implements Drawable, Movable {
    private int bulletX, bulletY;
    private ArrayList<int[]> balas = new ArrayList<>();
 
    public Bullet(int bulletX, int bulletY) {
        this.bulletX = bulletX;
        this.bulletY = bulletY;
    }

	@Override
	public void move(KeyEvent e) {
		switch (e.getKeyCode()) {
        case KeyEvent.VK_SPACE: // Disparar con la tecla de espacio
            balas.add(new int[]{bulletX + 20, bulletY});
            break;
		}
	}

	@Override
	public void move(ActionEvent a) {
		
	}

	@Override
	public void draw(Graphics g) {
		// Dibujar balas (elipses blancas pequeñas)
		g.setColor(Color.WHITE);
        for (int[] bala : balas) {
            g.fillOval(bala[0], bala[1], 10, 15);
        }
	}
}