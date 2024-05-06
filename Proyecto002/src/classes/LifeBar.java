package classes;

import java.awt.Color;
import java.awt.Graphics;

import interfaces.Drawable;

public class LifeBar implements Drawable{
	
	private int[] barX;
    private int barY;
    
    public LifeBar(int life) {
    	barX = new int[life];
    	barY = 20;
    	//Numero de aliens dibujados
    	for (int i = 0; i < barX.length; i++) {
    		barX[i] = 20 + i * 15;
        }
    }

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.RED);
        for (int i = 0; i < barX.length; i++) {
            g.fillRect(barX[i], barY, 10, 10);
        }
	}

}
