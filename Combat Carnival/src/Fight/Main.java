package Fight;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


public class Main extends Applet implements Runnable, KeyListener, MouseListener, MouseMotionListener
{
	int mx = -1;
	int my = -1;
	
	Rect platform = new Rect(500, 400, 100, 30);
	
	Rect floor = new Rect(0, 0, 1800, 50);
	Rect ceiling = new Rect(0, 1000, 1800, 50);
	Rect leftwall = new Rect(0, 0, 50, 1800);
	Rect rightwall = new Rect(1800, 0, 50, 1800);
	
	boolean UP_Pressed = false;
	boolean DN_Pressed = false;
	boolean LT_Pressed = false;
	boolean RT_Pressed = false;
	
	Image    offScreenImg;
	Graphics offScreenPen;
	
	String[] pose = {"dn", "up", "lt", "rt"};

	Sprite soldier = new Sprite("g", pose, 100, 740, 5, 15);

	public void run()
	{
		// Game Loop
		while(true)
		{
			//soldier.physicsOff();
			
			//if(UP_Pressed) soldier.jump(25);
			if(LT_Pressed) soldier.goLT(10);
			if(RT_Pressed) soldier.goRT(10);
									
			if(UP_Pressed) soldier.goUP(10);
			if(DN_Pressed) soldier.goDN(10);
									
	
			soldier.move();
			
			
			
			if(soldier.overlaps(floor))
			{
				soldier.bounceOff(floor);		
			}

			if(soldier.overlaps(platform))
			{
				soldier.bounceOff(platform);
			}
			if(soldier.overlaps(ceiling))
			{
				soldier.bounceOff(ceiling);
			}
			if(soldier.overlaps(leftwall))
			{
				soldier.bounceOff(leftwall);
			}
			if(soldier.overlaps(rightwall))
			{
				soldier.bounceOff(rightwall);
			}
		
			repaint();
						
			try
			{			
				Thread.sleep(15);
			}
			catch(Exception x) {};
		}
	}
	
	
	public void update(Graphics pen)
	{
		offScreenPen.clearRect(0, 0, 1920, 1200);
	
		paint(offScreenPen);
		
		pen.drawImage(offScreenImg, 0, 0, null);
	}
	
	public void paint(Graphics pen)
	{
		soldier.draw(pen);
		
		floor.draw(pen);
		ceiling.draw(pen);
	    leftwall.draw(pen);
		rightwall.draw(pen);
		
		platform.draw(pen);
	}

	
	public void init()
	{		
		offScreenImg = createImage(1920, 1200);
		offScreenPen = offScreenImg.getGraphics();
		
		addKeyListener(this);
		requestFocus();
		
		addMouseListener(this);
		
		addMouseMotionListener(this);

		
		Thread t = new Thread(this);

		t.start();
	}
	
	
	public void mouseMoved(MouseEvent e)
	{
		
	}
	
	
	
	public void mouseDragged(MouseEvent e)
	{
		int nx = e.getX();
		int ny = e.getY();
		
		int dx = nx - mx;
		int dy = ny - my;
		


		
		mx = nx;
		my = ny;
	}
	
	public void mousePressed(MouseEvent e)
	{
		mx = e.getX();
		my = e.getY();
	}
	
	public void mouseReleased(MouseEvent e)
	{
	}
	
	public void keyPressed(KeyEvent e)
	{		
		int code = e.getKeyCode();
		
		if (code == e.VK_UP   )   UP_Pressed = true;  
		if (code == e.VK_DOWN )   DN_Pressed = true;  
		if (code == e.VK_LEFT )   LT_Pressed = true;  
		if (code == e.VK_RIGHT)   RT_Pressed = true; 
		
	}
	
	public void keyReleased(KeyEvent e)
	{
		int code = e.getKeyCode();

		if (code == e.VK_UP   )   UP_Pressed = false;  
		if (code == e.VK_DOWN )   DN_Pressed = false;  
		if (code == e.VK_LEFT )   LT_Pressed = false;  
		if (code == e.VK_RIGHT)   RT_Pressed = false;  
	}
	
	
	public void keyTyped(KeyEvent e) {}
	public void mouseClicked(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}	
	public void mouseExited(MouseEvent e){}
	
	
	

	
}