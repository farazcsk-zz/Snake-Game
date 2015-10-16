
package snakegamefinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

@SuppressWarnings("serial")

public class RenderPanel extends JPanel
{

	

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		SnakeGameFinal snake = SnakeGameFinal.snake;

		g.setColor(Color.blue);
		
		g.fillRect(0, 0, 800, 700);

		g.setColor(Color.red);

		for (Point point : snake.snakeBits)
		{
			g.fillRect(point.x * SnakeGameFinal.GAMESCALE, point.y * SnakeGameFinal.GAMESCALE, SnakeGameFinal.GAMESCALE, SnakeGameFinal.GAMESCALE);
		}
		
		g.fillRect(snake.nose.x * SnakeGameFinal.GAMESCALE, snake.nose.y * SnakeGameFinal.GAMESCALE, SnakeGameFinal.GAMESCALE, SnakeGameFinal.GAMESCALE);
		
		g.setColor(Color.green);
		
		g.fillRect(snake.food.x * SnakeGameFinal.GAMESCALE, snake.food.y * SnakeGameFinal.GAMESCALE, SnakeGameFinal.GAMESCALE, SnakeGameFinal.GAMESCALE);
		
		String string = "Score: " + snake.score + ",Snake Length: " + snake.tailSize + ", Time: " + snake.time / 20 +", Level: " + snake.level;
		
		g.setColor(Color.white);
		
		g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), 10);

		string = "You have failed to beat snake. But you survived for " + snake.time + " Seconds. ";

		if (snake.gameOver)
		{
			g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) snake.frameDimension.getHeight() / 4);
		}

		string = "Paused!";

		if (snake.paused && !snake.gameOver)
		{
			g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) snake.frameDimension.getHeight() / 4);
		}
                if(snake.level==5){
                    // hidden easter egg :)
                    string ="MADE BY FARAZ KHAN.";
                    g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) snake.frameDimension.getHeight() / 4);
                    string="";
                    g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) snake.frameDimension.getHeight() / 4);
                    string ="MADE BY FARAZ KHAN.";
                    g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) snake.frameDimension.getHeight() / 4);
                    string="";
                    g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) snake.frameDimension.getHeight() / 4);
                    string ="MADE BY FARAZ KHAN.";
                    
                    
                    
                }
                if(snake.score==49){
                    // hidden easter egg :)
                    string ="I am really sorry about this.....";
                    g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) snake.frameDimension.getHeight() / 4);
                   
                    
                    
                    
                }
	}
}

