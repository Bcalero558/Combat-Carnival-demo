package Fight;

import java.awt.*;

public class cc_player extends Rect
{
	String []pose = {
			"Idle","Walk", "Jump",
			"Jab","Cross","Overhead","Lower",
			"Hurt"
		};
	boolean testing = true;
	Animation[] animationL;
	Animation[] animationR;
	int action = 0;
	boolean moving = false;
	boolean forward;
	boolean attacking = false;

	public cc_player(String name,int x, int y,int duration, int w, int h, boolean forward) {
		super(x, y, w, h);
		this.forward = forward;
		animationL = new Animation[pose.length];
		animationR = new Animation[pose.length];
		for(int i = 0; i < animationL.length;i++) 
		{
		// idle
			if(i == 0) {
				animationL[i] = new Animation("Combat Carnival",name,"left", pose[i],10,duration);
				animationR[i] = new Animation("Combat Carnival",name,"Right", pose[i],10,duration);
			}
			
		// walk and under attack
			if(i == 1 ||i == 6 ) {
				animationL[i] = new Animation("Combat Carnival",name,"left", pose[i],8,duration);
				animationR[i] = new Animation("Combat Carnival",name,"Right", pose[i],8,duration);
			}
		// jump
			if(i == 2) {
				animationL[i] = new Animation("Combat Carnival",name,"left", pose[i],3,duration);
				animationR[i] = new Animation("Combat Carnival",name,"Right", pose[i],3,duration);
			}
		// cross
			if(i == 4) {
				animationL[i] = new Animation("Combat Carnival",name,"left", pose[i],7,duration);
				animationR[i] = new Animation("Combat Carnival",name,"Right", pose[i],7,duration);
			}
		//overhead and jab
			if(i == 5|| i == 3) {
				animationL[i] = new Animation("Combat Carnival",name,"left", pose[i],4,duration-4);
				animationR[i] = new Animation("Combat Carnival",name,"Right", pose[i],4,duration-4);
			}
			//take damage
			if(i == 7) {
				animationL[i] = new Animation("Combat Carnival",name,"left", pose[i],4,duration);
				animationR[i] = new Animation("Combat Carnival",name,"Right", pose[i],4,duration);
			}
		}
	}

	public void moveLT(int dx)	
	{
		if(!attacking) {
	   this.vx = -dx;
	   moving = true;
		forward = false;
		action = 1 ;
		}
	}
	public void moveRT(int dx)	
	{
		if(!attacking) {
		this.vx = +dx;
		moving = true;
		forward = true;
		action = 1;
		
		}
	}
public void overhead_attack() 
{

		
	action = 5;
	moving = true;
	attacking = true;
}
public void lower_attack() 
{

		
	action = 6;
	moving = true;
	attacking = true;
	
}
public void basic_attack() 
{
	action = 3;
	moving = true;
	attacking = true;
}
	public Image action_taken(int i) 
	{
		if(!forward)
		return animationL[i].nextImage();
		else
		return animationR[i].nextImage();
		
	}
	public void draw(Graphics g) 
	{
		if (testing == true)
			g.drawRect(x, y, w, h);
		if(!moving)
		action = 0;
			if(airtime && !attacking)
				action = 2;
			if(action == 5)
				g.drawImage(action_taken(action),x,y-13,w+10,h+37,null);
			else
			g.drawImage(action_taken(action),x,y,w,h,null);
	}


}
