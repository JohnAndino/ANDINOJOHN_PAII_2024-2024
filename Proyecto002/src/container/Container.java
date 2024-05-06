package container;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import interfaces.Dieable;
import interfaces.Drawable;
import interfaces.Movable;
import interfaces.Shootable;

public class Container {
	
	public void draw(Drawable dr, Graphics g) {
		dr.draw(g);
	}
	public void shoot(Shootable sh) {
		sh.shoot();
	}
	public void die(Dieable dl, ActionEvent e) {
		dl.die(e);
	}
	public void move(Movable mv, KeyEvent e) {
		mv.move(e);
	}
	public void move(Movable mv, ActionEvent a) {
		mv.move(a);
	}
}
