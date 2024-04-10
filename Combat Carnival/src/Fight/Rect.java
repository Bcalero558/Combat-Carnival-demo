package Fight;
import java.awt.*;
public class Rect {

//size and location
int x;
int y;
int w;
int h;

//velocity
double vx = 0;
double vy = 0;

//acceleration
double ay = G;

//gravity
static double G = .7;
//friction
static double F = .6;

//
boolean held = false;

//Constructor

public Rect (int x, int y, int w,int h) 
{
	//takes outside variables and brings them inside
	this.x = x;
	this.y = y;
	this.w = w;
	this.h = h;
}

// sets all physics variables to zero
	public void physicsOff()
	{
		vx = 0;
		vy = 0;
		
		ay = 0;
	}
	
	// sets the velocity of movements	
	public void setVelocity(double vx, double vy)
	{
		this.vx = vx;
		this.vy = vy;
	}
	
	// checks if a rectangle  is touched
	public void grabbed()
	{
		held = true;
	}
	
	//checks if rectangle is let go
	public void dropped()
	{
		held = false;
	}
	
	// changes velocity to go towards the left direction
	public void goLT(int vx)
	{
		this.vx = -vx;		
	}
	
	// velocity goes right
	public void goRT(int vx)
	{
		
		this.vx = +vx;		
	}
	
	// increases velocity upwards
	public void goUP(int vy)
	{
		this.vy = -vy;
	}
	
	// increases velocity downward
	public void goDN(int vy)
	{
		this.vy = +vy;
	}
	
	//static increase of velocity upward
	public void jump(int h)
	{
		vy = -h;		
	}
	
	// changes coordinates in respect to velocity
	public void move()
	{
		x += vx;
		y += vy + G/2;
		
		vy += G;
	}
	
	//movement regardless of velocity of rectangle position
	public void moveBy(int dx, int dy)
	{
		x += dx;
		y += dy;
	}
	
	// change the size of rectangle
	public void resizeBy(int dw, int dh)
	{
		w += dw;
		
		h += dh;
	}
	
	//basic Ai to chase objects
	public void chase(Rect r, int dx)
	{
		if(isLeftOf(r))   goRT(dx); 
		if(isRightOf(r))  goLT(dx); 
		if(isAbove(r))    goDN(dx); 
		if(isBelow(r))    goUP(dx);
		
		move();
	}
	
	// basic ai to evade objects
	public void evade(Rect r, int dx)
	{
		if(isLeftOf(r))   goLT(dx); 
		if(isRightOf(r))  goRT(dx); 
		if(isAbove(r))    goUP(dx); 
		if(isBelow(r))    goDN(dx); 
		
		move();
	}
	
	//collision detectors
	
	//checks left
	public boolean isLeftOf(Rect r)
	{
		return x + w < r.x;
	}
	
	//checks right
	public boolean isRightOf(Rect r)
	{
		return r.x + r.w < x;
	}
	
	//checks above
	public boolean isAbove(Rect r)
	{
		return y + h < r.y;
	}
	
	//checks below
	public boolean isBelow(Rect r)
	{
		return r.y + r.h < y;
	}
	
	
	//checks if inside object
	public boolean contains(int mx, int my)
	{
		return (mx >= x    )  &&
			   (mx <= x + w)  &&
			   (my >= y    )  &&
			   (my <= y + h);
	}
	
	//checks if there is an overlap
	public boolean overlaps(Rect r)
	{
		return (x + w >= r.x      ) &&				
			   (x     <= r.x + r.w) &&
			   (y + h >= r.y      ) &&			   
			   (y     <= r.y + r.h);
	}
	
	// keeps one rectangle outside another
	public void pushedOutOf(Rect r)
	{
		if(cameFromAbove(r)) 	pushbackUpFrom(r);
		if(cameFromBelow(r))    pushbackDownFrom(r);
		if(cameFromLeftOf(r))   pushbackLeftFrom(r);		
		if(cameFromRightOf(r))	pushbackRightFrom(r);
		
		vx *= F;
		
		if(Math.abs(vx) <= 1)  vx = 0;
	}
	
	// allows for bouncing off in collision
	public void bounceOff(Rect r)
	{
		if(cameFromAbove(r)  || cameFromBelow(r))    vy = -vy;
		if(cameFromLeftOf(r) || cameFromRightOf(r))  vx = -vx;
	}
	
	public boolean cameFromLeftOf(Rect r)
	{
		return x - vx + w < r.x;
	}
	
	public boolean cameFromRightOf(Rect r)
	{
		return r.x + r.w < x - vx;
	}
	
	public boolean cameFromAbove(Rect r)
	{
		return y - vy + h < r.y;
	}
	
	public boolean cameFromBelow(Rect r)
	{
		return r.y + r.h < y - vy;
	}
	
	public void pushbackLeftFrom(Rect r)
	{
		x = r.x - w - 1;
	}
	
	public void pushbackRightFrom(Rect r)
	{
		x = r.x + r.w + 1;
	}
	
	public void pushbackUpFrom(Rect r)
	{
		y = r.y - h - 1;
		
		vy = 0;
	}
	
	public void pushbackDownFrom(Rect r)
	{
		y = r.y + r.h + 1;
	}
	
	// draws the rectangle
	public void draw(Graphics pen)
	{
		pen.drawRect(x, y, w, h);
	}
	
	// turns rectangle location into string
	public String toString()
	{
		return "new Rect(" + x + ", " + y + ", " + w + ", " + h + "),";
	}

}









