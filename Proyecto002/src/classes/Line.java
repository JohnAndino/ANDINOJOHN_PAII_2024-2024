package classes;

import java.awt.Color;
import java.awt.Graphics;

import container.JWindow;
import interfaces.Drawable;

public class Line implements Drawable{

	@Override
	public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.drawLine(0, (int)(600 * 0.67), 800, (int)(600 * 0.67));
	}

}
