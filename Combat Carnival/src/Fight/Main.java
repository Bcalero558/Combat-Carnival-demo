package Fight;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


public class Main extends Base
{

////Objects /////////////////////////////////////////////    
	Animation animation = new Animation("Combat Carnival", "default", "Left", "Idle", 9, 5);
    Rect[] wall = 
	{
			   new Rect (-2, 869, 50000, 100),
			   new Rect (-40 - Camera.x/1, 509 - Camera.y/1 , 60, 360),  
			   new Rect (1889-Camera.x/1, 509-Camera.y/1, 114, 360)
   };
   Rect p1 = new Rect (616 -Camera.x, 700 - Camera.y, 70, 160);
   CameraFocus center = new CameraFocus (972, 708,70,160);
ImageLayer[] Background = 
		{ 
		new ImageLayer("Combat Carnival/background/6.png",-500,0,10,true),
		new ImageLayer("Combat Carnival/background/2.png",-500,0,4,true),
		new ImageLayer("Combat Carnival/background/3.png",-500,0,3,true),
		new ImageLayer("Combat Carnival/background/4.png",-500,0,2,true),
		new ImageLayer("Combat Carnival/background/7.png",250,-200,10,true),
		new ImageLayer("Combat Carnival/background/5.png",-500,0,1,true)
		};
ImageLayer Floor = new ImageLayer("Combat Carnival/background/floor.PNG",0,869,5,false);
///////////////////////////////////////////////////////////////////////
	
///runs program///////////////////////
	public void gameLoop() 
	{
		center.CameraMovement(p1, 500);
			if(pressing[_W]) p1.jump();
			if(!p1.overlaps(wall[1]))
			if(pressing[_A]) p1.moveLT(5);
			
			//if(pressing[_S]) p1.moveDN(10);
			if(!p1.overlaps(wall[2]))
			if(pressing[_D])  p1.moveRT(5);
			p1.move();
			
			if(center.moveCameraL) 
			{
				Camera.moveLT(15); 
				center.moveLT(15);
			
												}
			
			if(center.moveCameraR) 
			{ 
				Camera.moveRT(15);
				center.moveRT(15);
				
			}
			
			
			if(pressing[_H]) {
			System.out.println("Rect " + (1) + " " + wall[0].toString());
			System.out.println("Rect " + (2) + " " + wall[1].toString());
			System.out.println("Rect " + (3) + " " + wall[2].toString());
			System.out.println("player " + (1) + " " + p1.toString());
			}
			
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
	for(int i = 0; i<6;i++)
		Background[i].draw(g);
	
		
		for(int i =-500; i < 2000; i+=250) {
		Floor.x = i;
		Floor.draw(g);
		}
		g.setColor(Color.yellow);
		for(int i = 0; i < wall.length;i++)
		wall[i].draw(g);
		center.draw(g);
		g.setColor(Color.green);
		p1.draw(g);
		g.drawImage(animation.nextImage(), 616, 700, null);
	}
/////////////////////////////////////////////////

}