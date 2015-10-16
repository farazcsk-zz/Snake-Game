package snakegamefinal;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;


public class SnakeGameFinal implements ActionListener, KeyListener
{

	public static SnakeGameFinal snake;

	public JFrame jframe;

	public RenderPanel renderPanel;

	public Timer level1 = new Timer(20, this);
        
        public Timer level2 = new Timer(18, this);
        
        public Timer level3 = new Timer(16, this);
        
        public Timer level4 = new Timer(14, this);
        
        public Timer level5 = new Timer(12, this);
        
        public Timer level6 = new Timer(1, this);

	public ArrayList<Point> snakeBits = new ArrayList<Point>();

	public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3, GAMESCALE = 10;

	public int clicks = 0, snakeDirection = DOWN, score, tailSize = 10, time,level;

	public Point nose, food;

	public Random random;

	public boolean gameOver = false, paused;

	public Dimension frameDimension;

	public SnakeGameFinal()
	{
		frameDimension = Toolkit.getDefaultToolkit().getScreenSize();
		jframe = new JFrame("DARE TO PLAY SNAKE?");
		jframe.setVisible(true);
		jframe.setSize(800, 700);
		jframe.setResizable(false);
		jframe.setLocation(frameDimension.width / 2 - jframe.getWidth() / 2, frameDimension.height / 2 - jframe.getHeight() / 2);
		jframe.add(renderPanel = new RenderPanel());
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.addKeyListener(this);
		startGame();
	}

	public void startGame()
	{
		gameOver = false;
		paused = false;
		time = 0;
		score = 0;
                level = 1;
		tailSize = 10;
		clicks = 0;
		snakeDirection = DOWN;
		nose = new Point(0, -1);
		random = new Random();
		snakeBits.clear();
		food = new Point(random.nextInt(79), random.nextInt(66));
		level1.start();
                
                
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		renderPanel.repaint();
		clicks++;

		if (clicks % 2 == 0 && nose != null && !gameOver && !paused)
		{
			time++;

			snakeBits.add(new Point(nose.x, nose.y));

			if (snakeDirection == UP)
			{
				if (nose.y - 1 >= 0 && noTailAt(nose.x, nose.y - 1))
				{
					nose = new Point(nose.x, nose.y - 1);
				}
				else
				{
					gameOver = true;

				}
			}

			if (snakeDirection == DOWN)
			{
				if (nose.y + 1 < 67 && noTailAt(nose.x, nose.y + 1))
				{
					nose = new Point(nose.x, nose.y + 1);
				}
				else
				{
					gameOver = true;
				}
			}

			if (snakeDirection == LEFT)
			{
				if (nose.x - 1 >= 0 && noTailAt(nose.x - 1, nose.y))
				{
					nose = new Point(nose.x - 1, nose.y);
				}
				else
				{
					gameOver = true;
				}
			}

			if (snakeDirection == RIGHT)
			{
				if (nose.x + 1 < 80 && noTailAt(nose.x + 1, nose.y))
				{
					nose = new Point(nose.x + 1, nose.y);
				}
				else
				{
					gameOver = true;
				}
			}

			if (snakeBits.size() > tailSize)
			{
				snakeBits.remove(0);

			}

			if (food != null)
			{
				if (nose.equals(food))
				{
					score += 1;   //increase score
					tailSize++; //increase length
					food.setLocation(random.nextInt(79), random.nextInt(66));
                                                           
                                        switch(score){
                                            case(10):
                                                level +=1;
                                                break;                           // increase the level for each 10 points scored
                                                case(20):
                                                    level +=1;
                                                    break;
                                                    case(30):
                                                        level +=1;
                                                        break;
                                                        case(40):
                                                        level +=1;
                                                        break;
                                                            case(50):
                                                        level +=1;
                                                        break;
                                                
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                        }
                                                            
                                                            
                                                            
                                                            
                                                            
                                                            
                                                            
                                        switch(level){
                                            case(2):
                                                level1.stop();
                                                level2.start();                  //increase speed for each level
                                                break;
                                                case(3):
                                                    level2.stop();
                                                    level3.start();
                                                    break;
                                                case(4):
                                                    level3.stop();
                                                    level4.start();
                                                    break;
                                                    
                                                case(5):
                                                    level4.stop();
                                                    level5.start();
                                                    break;
                                                    case(6):
                                                    level5.stop();
                                                    level6.start();
                                                    break;
                                                    
                                                
                                        
                                        
                                        
                                        
                                        
                    
                                        }
				}
			}
		}
	}

	public boolean noTailAt(int x, int y)
	{
		for (Point point : snakeBits)
		{
			if (point.equals(new Point(x, y)))
			{
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args)
	{
		snake = new SnakeGameFinal();
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		int i = e.getKeyCode();

		if (i == KeyEvent.VK_LEFT && snakeDirection != RIGHT)
		{
			snakeDirection = LEFT;
		}

		if (i == KeyEvent.VK_RIGHT && snakeDirection != LEFT)
		{
			snakeDirection = RIGHT;
		}

		if (i == KeyEvent.VK_UP && snakeDirection != DOWN)
		{
			snakeDirection = UP;
		}

		if (i == KeyEvent.VK_DOWN && snakeDirection != UP)
		{
			snakeDirection = DOWN;
		}

		if (i == KeyEvent.VK_P)
		{
			if (gameOver)
			{
				startGame();
			}
			else
			{
				paused = !paused;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

}