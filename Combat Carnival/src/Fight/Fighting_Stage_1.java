package Fight;

import java.awt.Color;
import java.awt.Graphics;

public class Fighting_Stage_1  extends Stage{

	
////Objects /////////////////////////////////////////////   
   
	Rect[] wall = 
	{
			   new Rect (-2, 950, 50000, 100),
			   new Rect (-40 - Camera.x/1, 509 - Camera.y/1 , 60, 360),  
			   new Rect (1889-Camera.x/1, 509-Camera.y/1, 114, 360)
   };
boolean testing = false;
   cc_player p1;
	
	cc_player p2;
	
	Hitbox Hitbox1 = new Hitbox(180,310,32,105,100);
	Hitbox Hitbox2 = new Hitbox(180,310,32,105,100);
	HurtBox Hurtbox1 = new HurtBox(1000,1000,1,1);
	HurtBox Hurtbox2 = new HurtBox(1000,1000,1,1);
	
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
	
public Fighting_Stage_1(boolean[] pressing, cc_player p1, cc_player p2) 
{
	super(pressing);
	this.p1 = p1;
	this.p2 = p2;
}


@Override
	public void inGameLoop() {
		// TODO Auto-generated method stub
		Hitbox1.setHealthLocation(p1);
		Hitbox1.setHealthLocation(p2);
		
		p1.testing = testing;
		p2.testing = testing;
		testing = false;
		p1.moving= false;
		p1.attacking= false;
		p2.moving= false;
		p2.attacking= false;
		Hitbox1.hitbox_move(p1);
		Hurtbox1.hurtbox_move(p1);
		if(!Hurtbox1.hurts)
			Hurtbox1 =  new HurtBox(10000,10000,1,1);
		Hitbox2.hitbox_move(p2);
		Hurtbox2.hurtbox_move(p2);
		if(!Hurtbox2.hurts)
			Hurtbox2 =  new HurtBox(10000,10000,1,1);
		Hitbox1.Damage_taken(Hurtbox2,p1);
		Hitbox2.Damage_taken(Hurtbox1,p2);
		
		
		
		
		center.CameraMovement(p1,p2, 500);
			if(pressing[_W]) 
				p1.jump();
			
			
			if(pressing[_A]) 
			{
				if(!p1.overlaps(wall[1]))
					p1.moveLT(5);
				else
				p1.moveLT(0);
				
			}
			//if(pressing[_S]) p1.moveDN(10);
			
			if(pressing[_D]) 
				{
				if(!p1.overlaps(wall[2]))
				p1.moveRT(5);
				else
				p1.moveRT(0);
				}
			
		//attacks
			if (pressing[_R]) 
				p1.overhead_attack();
			
			if (pressing[_F]) 
				p1.basic_attack();
			
			if (pressing[_V]) 
				p1.lower_attack();
			
			p1.move();
		//////////////////////////////////////////////////////////////////////////////////
			if(pressing[UP]) p2.jump();
			

			if(pressing[LT]) 
			{
				if(!p2.overlaps(wall[1]))
					p2.moveLT(5);
				else
				p2.moveLT(0);
				
			}
			
			//if(pressing[_S]) p1.moveDN(10);
			if(pressing[RT]) 
			{
			if(!p2.overlaps(wall[2]))
			p2.moveRT(5);
			else
			p2.moveRT(0);
			}
			
		//attacks
			if (pressing[_Y]) 
				p2.overhead_attack();
			
			if (pressing[_H]) 
				p2.basic_attack();
			
			if (pressing[_N]) 
				p2.lower_attack();
			
			p2.move();
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
			
			
			if(pressing[_T]) {
			System.out.println("Rect " + (1) + " " + wall[0].toString());
			System.out.println("Rect " + (2) + " " + wall[1].toString());
			System.out.println("Rect " + (3) + " " + wall[2].toString());
			System.out.println("player " + (1) + " " + p1.toString());
			}
			
			if (p1.overlaps(wall[0])) 	
			{
				p1.airtime = false; 
				p1.pushedOutOf(wall[0]);
			}
			
			for(int i = 1; i < wall.length;i++) {
				if (p1.overlaps(wall[i])) 
			{
				p1.pushedOutOf(wall[i]);
				
			}
			}
//////////////////////////////////////////////////////////////////////////////////////////
			if (p2.overlaps(wall[0])) 	
			{
				p2.airtime = false; 
				p2.pushedOutOf(wall[0]);
			}
			
			for(int i = 1; i < wall.length;i++) {
				if (p2.overlaps(wall[i])) 
			{
				p2.pushedOutOf(wall[i]);
				
			}
			}
			if(pressing[_P]) 
			{
				if(testing == true) 
				{
				testing = false;	
				}
				if(testing == false) {
					testing = true;
				}
					
			}
	}

	
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		for(int i = 0; i<6;i++)
			Background[i].draw(g);
		
		
			for(int i =-500; i < 2000; i+=250) {
			Floor.x = i;
			Floor.draw(g);
			}
			g.setColor(Color.yellow);
			if(testing) {
			for(int i = 0; i < wall.length;i++)
			wall[i].draw(g);
			center.draw(g);
			g.setColor(Color.green);
			Hitbox1.draw(g);
			Hitbox2.draw(g);
			
			g.setColor(Color.red);
			Hurtbox1.draw(g);
			Hurtbox2.draw(g);
			}
			g.setColor(Color.green);
			
			p1.draw(g);
			p2.draw(g);
			Hitbox1.showHealth(g,p1);
			Hitbox2.showHealth(g,p2);
			g.drawString("Health: " + Hitbox2.Health, p2.x,p2.y);
			g.drawString("Health: " + Hitbox1.Health, p1.x,p1.y);
	}

}
