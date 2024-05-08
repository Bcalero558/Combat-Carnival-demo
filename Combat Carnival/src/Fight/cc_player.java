package Fight;

import java.awt.*;

public class cc_player extends Rect
{
	int distanceFromPlayer;
	String []pose = {
			"Idle","Walk", "Jump",
			"Jab","Cross","Overhead","Lower",
			"Hurt","Dead"
		};

	Animation[] animationL;
	Animation[] animationR;
	int action = 0;
	boolean moving = false;
	boolean forward;
	boolean attacking = false;
	int timer = 100;
	int delay = 100;
	
	double coolDown = 1200;
	double lastTime = 0;
	
	public boolean testing = false;
	boolean player1;
	
	public cc_player(String name,int x, int y,int duration, int w, int h, boolean p1) {
		super(x, y, w, h);
		this.player1 = p1;
		if(p1)
		this.forward = true;
		else
		this.forward = false;
		animationL = new Animation[pose.length];
		animationR = new Animation[pose.length];
		for(int i = 0; i < animationL.length;i++) 
		{
		// idle
			if(i == 0 || i == 8) {
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
public void damaged(Hitbox hit) 
{
	if(hit.isHurt)
		action = 7;
}
	public Image action_taken(int i) 
	{
		if(!forward)
		return animationL[i].nextImage();
		else
		return animationR[i].nextImage();
		
	}
	public Image Death() 
	{
		if(!forward)
		return animationL[8].stillImage(9);
		else
		return animationR[8].stillImage(9);
		
	}
	
		public void dies(Hitbox box) {
			moving = true;
			if(box.isDead());{
			action = 8;
			if(forward)
				this.vx = +10;

			if(!forward)
				this.vx = -10;
		
			}
			}
		public void chase(Rect player, Rect ai, int dx)
		{
			moving = true;
			distanceFromPlayer = Math.abs(player.x - ai.x);
			// Chases the player if player is within range
			if(distanceFromPlayer <= 350) 
			{
				if(isLeftOf(player)) {  
					forward = true;
					moveRT(dx); 
				}
				if(isRightOf(player)) { 
					forward = false;
					moveLT(dx);
				}
				
			}
		}
	public void draw(Graphics g) 
	{
		if (testing == true)
			g.drawRect(x, y, w, h);
		if(!moving)
		action = 0;
			if(airtime && !attacking)
				action = 2;
			if(action == 5) {
				g.drawImage(action_taken(action),x,y-13,w+20,h+47,null);
			}
			else if(action == 8) 
			{
				while(delay!=0) {
					g.drawImage(action_taken(action),x,y,w,h,null);
					delay --;
				}
				g.drawImage(Death(),x,y,w,h,null);
			}
			else
			g.drawImage(action_taken(action),x,y,w,h,null);
	}


}
