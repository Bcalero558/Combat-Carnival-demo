package Fight;

import java.awt.*;
import java.awt.event.*;

public class test extends Base 
{

	boolean leftOfScreen = true;
	boolean testing = false;
	
	String []pose = {
			"Idle","Walk", "Jump",
			"Jab","Cross","Overhead","Lower",
			"Hurt"
		};
	cc_player p1 = new cc_player("default", 0, 0, 9 ,70,160,leftOfScreen);
	cc_player p2 = new cc_player("default", 0, 0, 9 ,70,160,!leftOfScreen);
	
	Rect2 sampleHitBox = new Rect2 (p1.x+100,p1.y,20,20);
	Rect2 sampleHurtBox = new Rect2 (p1.x,p1.y,20,20);
	Hitbox Hitbox = new Hitbox(p1.x+180,p1.y+310,32,105);
	
	
	
	public void gameLoop() {
		p1.moving= false;
		p1.attacking = false;
		Hitbox.hitbox_move(p1);
		if(pressing[_W]) p1.jump();
		if(pressing[_W]) p1.jump();
		if(pressing[_A]) p1.moveLT(5);
		if (pressing[_T]) 
			p1.overhead_attack();
		if (pressing[_G]) 
			p1.basic_attack();
		
		if (pressing[_B]) 
			p1.lower_attack();
		if (pressing[_L]) 
			testing = true;
		//if(pressing[_S]) p1.moveDN(10);
		if(pressing[_D])  p1.moveRT(5);
		
	}
	public void paint(Graphics g) {
		
		g.setColor(Color.black);
		p1.draw(g);
		g.setColor(Color.green);
		sampleHitBox.draw(g);
		if(testing )
		Hitbox.draw(g);
		g.drawString("HitBox Cord: x = " + sampleHitBox.x + " , y = "  + sampleHitBox.y + " , width = "  + sampleHitBox.w + " , height = "  + sampleHitBox.h , 300, 50);
		g.drawString("HitBox Cord: x = " + Hitbox.x + " , y = "  + Hitbox.y + " , width = "  + Hitbox.w + " , height = "  + Hitbox.h , 300, 150);
		g.setColor(Color.red);
		sampleHurtBox.draw(g);
		g.drawString("HurtBox Cord: x = " + sampleHurtBox.x + " , y = "  + sampleHurtBox.y+ " , width = "  + sampleHurtBox.y+ " , height = "  + sampleHurtBox.h , 300, 100);
	}
	public void mouseDragged(MouseEvent e)
	{
		int nx = e.getX();
		int ny = e.getY();
		
		int dx = nx - mx;
		int dy = ny - my;
		
		if(sampleHitBox.resizer.held)  sampleHitBox.resizeBy(dx,  dy);
		else
		if(sampleHitBox.held)  sampleHitBox.moveBy(dx, dy);
		
		if(sampleHurtBox.resizer.held)  sampleHurtBox.resizeBy(dx,  dy);
		else
		if(sampleHurtBox.held)  sampleHurtBox.moveBy(dx, dy);
		
		mx = nx;
		my = ny;
	}
	
	public void mousePressed(MouseEvent e)
	{
		mx = e.getX();
		my = e.getY();
		
		if(sampleHitBox.contains(mx,  my))  sampleHitBox.grabbed();
		if(sampleHitBox.resizer.contains(mx,  my))  sampleHitBox.resizer.grabbed();
		
		if(sampleHurtBox.contains(mx,  my))  sampleHurtBox.grabbed();
		if(sampleHurtBox.resizer.contains(mx,  my))  sampleHurtBox.resizer.grabbed();
	}
	
	public void mouseReleased(MouseEvent e)
	{
		sampleHitBox.dropped();
		sampleHitBox.resizer.dropped();
		
		sampleHurtBox.dropped();
		sampleHurtBox.resizer.dropped();
	}
}
	