package classes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import interfaces.Drawable;

public class Score implements Drawable{
	
	private int score = 0;
	
	public void increaseScore(int points) {
        score += points;
    }
 

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Score: " + score, 600, 30);
	}

}
