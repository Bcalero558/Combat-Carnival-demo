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
   Rect p1 = new Rect (616 -Camera.x, 700 - Camera.y, 70, 160);
ImageLayer Background = new ImageLayer("Combat Carnival/background/10.png",0,0,1);
ImageLayer Floor = new ImageLayer("Combat Carnival/background/floor.PNG",0,869,2);
///////////////////////////////////////////////////////////////////////
	
///runs program///////////////////////
	public void gameLoop() 
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
		
	}
////////////////////////////////////////////
	
////// draws what happens////////////////////
	public void paint(Graphics g) 
	{
		Background.draw(g);
		
		for(int i =0; i < 1919; i+=250) {
		Floor.x = i;
		Floor.draw(g);
		}
		g.setColor(Color.yellow);
		for(int i = 0; i < wall.length;i++)
		wall[i].draw(g);
		
		g.setColor(Color.green);
		p1.draw(g);
	}
/////////////////////////////////////////////////

}