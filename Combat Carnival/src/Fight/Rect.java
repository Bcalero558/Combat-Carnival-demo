package Fight;

import java.awt.*;

// creates a rectangle
public class Rect 
{
	boolean clicked = false;
//// variables ////////////////////////////////	
	int x, y, w, h;

	
	double vx = 10;
	double vy = 10;
	double ay = g;
	static double g = 1.5;
	static double f = .6;
	

	
	boolean airtime = false;
	boolean held = false;
	
	public void physicsOff()
	{
		vx = 0;
		vy = 0;
		
		ay = 0;
	}
///////////////////////////////////////////////////	

//////constructor///////////////////////////////////
	public Rect (int x, int y, int w, int h) 
	{
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
////////////////////////////////////////////////////////
	
///draws shape///////////
	public void draw(Graphics g) 
	{
		g.drawRect(x, y, w, h);
	}
	
	public void drawStill(Graphics g) 
	{
		g.drawRect(x - Camera.x, y-Camera.y, w, h);
	}
///////////////////////////////////////////

//move rectangle///////////////////////////
	public void setVelocity(double vx, double vy)
	{
		this.vx = vx;
		this.vy = vy;
	}
	
	public void moveBy(int dx, int dy) 
	{
		
		   x += dx;
		   y += dy;
		
	}


	public void moveLT(int dx)	
	{
	   this.vx = -dx;
	}
	public void moveRT(int dx)	
	{
		this.vx = +dx;
	}
	public void moveDN(int dy)	
	{
		this.vy = +dy;
	}
	public void moveUP(int dy)	
	{
		this.vy = -dy;
	}
	public void jump() 
	{
		if(airtime == false) {
		vy = -30;
		airtime = true;
		}
	}
	
	public void move() 
	{
		x += vx;
		y += vy + g/2;
		
		vy += g;

	}
	
	
///////////////////////////////////////////////
	
//change the size///////////////////////////
	public void resizeBy(int dw, int dh) 
	{
		
		w += dw;
		h += dh;
		
	}
////////////////////////////////////////////
	
////////collision detection/////////////////////
	public boolean isLeftOf(Rect r)
	{
		return x + w < r.x;
	}
	
	public boolean isRightOf(Rect r)
	{
		return r.x + r.w < x;
	}
	
	public boolean isUp(Rect r)
	{
		return y + h < r.y;
	}
	
	public boolean isDown(Rect r)
	{
		return r.y + r.h < y;
	}
	
	public boolean fromLeft(Rect r)
	{	
		return x - vx + w < r.x;
	}
	
	public boolean fromRight(Rect r) 
	{
		return r.x + r.w < x - vx;
	}
	
	public boolean fromUp(Rect r) 
	{		
		return y - vy + h < r.y;
	}
	
	public boolean fromDown(Rect r) 
	{	
		return r.y + r.h < y - vy;
	}
	
	public boolean overlaps(Rect r) {
				
		return (x + w >= r.x      ) &&				
				   (x     <= r.x + r.w) &&
				   (y + h >= r.y      ) &&			   
				   (y     <= r.y + r.h);

		
		
	}
	
// checks if it is inside certain area
	public boolean contains(int mx, int my)
	{
		return (mx >= x    )  &&
			   (mx <= x + w)  &&
			   (my >= y    )  &&
			   (my <= y + h);
	}
	
	public void pushedOutOf(Rect r)
	{
		if(fromUp(r)) 	  pushBackUp(r);
		if(fromDown(r))   pushBackDown(r);
		if(fromLeft(r))   pushBackLeft(r);		
		if(fromRight(r))  pushBackRight(r);
		vx *= f;
		
		if(Math.abs(vx) <= 1)  vx = 0;
	}
//////////////////////////////////////////////////////////////////////

///////// pushes rectangle back if collides////////////////////////////
	public void bounceOff(Rect r)
	{
		if(fromUp(r)  || fromDown(r))    vy = -vy;
		if(fromLeft(r) || fromRight(r))  vx = -vx;
	}
	public void pushBackLeft(Rect r) {
	  // equation to check left reversed
		x = r.x - w - 1;
		
	}
	public void pushBackRight(Rect r) {
	   x = r.x + r.w + 1;
	}
	public void pushBackUp(Rect r) {
		 y = r.y - h - 1;
		 vy = 0;
	}
	public void pushBackDown(Rect r) {
	   y = r.y + r.h + 1;
	}
////////////////////////////////////////////////////////////////////////////
	
// mouse detection //////
	public void grabbed()
	{
		held = true;
	}
	
	public void dropped()
	{
		held = false;
	}
////////////////////////////////////////////////////////////////////
	public String toString()
	{
		return "new Rect(" + x + ", " + y + ", " + w + ", " + h + "),";
	}
}
