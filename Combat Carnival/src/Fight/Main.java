package Fight;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


public class Main extends Base
{

////Objects /////////////////////////////////////////////    
	
    Rect[] wall = 
	{
			   new Rect (-2, 869, 1919, 100),
			   new Rect (-1, 509, 60, 360),  
			   new Rect (1805, 509, 114, 360)
   };
   Rect p1 = new Rect (616, 700, 70, 160);
Image Background = Toolkit.getDefaultToolkit().getImage("Combat Carnival/background/10.png");
Image Floor = Toolkit.getDefaultToolkit().getImage("Combat Carnival/background/floor.PNG");
///////////////////////////////////////////////////////////////////////
	
///runs program///////////////////////
	public void run() 
	{
		/* game loop */
		while (true) 
		{
			if(W_pressed) p1.jump();
			if(!p1.overlaps(wall[1]))
			if(A_pressed) p1.moveLT(10);
			//if(S_pressed) p1.moveDN(10);
			if(!p1.overlaps(wall[2]))
			if(D_pressed) p1.moveRT(10);
			p1.move();
		/*	if(H_pressed) {
			System.out.println("Rect " + (1) + " " + wall[0].toString());
			System.out.println("Rect " + (2) + " " + wall[1].toString());
			System.out.println("Rect " + (3) + " " + wall[2].toString());
			System.out.println("player " + (1) + " " + p1.toString());
			}
			*/
			if (p1.overlaps(wall[0])) 	{p1.airtime = false; p1.pushedOutOf(wall[0]);}
			
			for(int i = 1; i < wall.length;i++) {
				if (p1.overlaps(wall[i])) 
			{
				p1.pushedOutOf(wall[i]);
				
			}
			}
						/* makes it so program runs with frame rate rather than infinite speed */
			try 
			{
				t.sleep(16);
			}catch(Exception x) {};
			repaint();
		}
	}
////////////////////////////////////////////
	
////// draws what happens////////////////////
	public void paint(Graphics g) 
	{
		g.drawImage(Background, 0, 0, null);
		for(int i =0; i < 1919; i+=250) {
		g.drawImage(Floor, i, 869, null);
		}
		g.setColor(Color.yellow);
		for(int i = 0; i < wall.length;i++)
		wall[i].draw(g);
		
		g.setColor(Color.green);
		p1.draw(g);
	}
/////////////////////////////////////////////////

}