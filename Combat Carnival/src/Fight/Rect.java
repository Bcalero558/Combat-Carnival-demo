package Fight;

import java.awt.*;

// creates a rectangle
public class Rect 
{
//// variables ////////////////////////////////	
	int x;
	int y;
	
	int old_x;
	int old_y;
	
	int w;
	int h;
	
	boolean held = false;
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
///////////////////////////////////////////

//move rectangle///////////////////////////
	public void moveBy(int dx, int dy) 
	{
		old_x = x;
		old_y = y;
		   x += dx;
		   y += dy;
		
	}


	public void moveLT(int dx)	
	{
	// keeps old values
	old_x = x;
	// moves object			
	   x -=dx;
	}
	public void moveRT(int dx)	
	{
	// keeps old values
	old_x = x;
	// moves object			
	   x +=dx;
	}
	public void moveDN(int dy)	
	{
	// keeps old values
	old_y = y;
	// moves object			
	   y +=dy;
	}
	public void moveUP(int dy)	
	{
	// keeps old values
	old_y = y;
	// moves object			
	   y -=dy;
	}
	public void pushedOutOf(Rect r)
	{
		if(fromUp(r)) 	  pushBackUp(r);
		if(fromDown(r))   pushBackDown(r);
		if(fromLeft(r))   pushBackLeft(r);		
		if(fromRight(r))  pushBackRight(r);
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
	
	public boolean fromLeft(Rect r) {
		
		//reverses the symbol used in the overlap checker
		if((old_x  +  w) < r.x)
			{
		
			return true;
			}
		else
			return false;
	}
	public boolean fromRight(Rect r) {
		
		
		if(( (r.x+r.w) <   old_x))
			{
		
			return true;
			}
		else
			return false;
	}
	public boolean fromUp(Rect r) {
		
		
		if(((old_y  +  h) < r.y))
			{
		
			return true;
			}
		else
			return false;
	}
	public boolean fromDown(Rect r) {
		
		
		if((r.y+r.h) <   old_y)
			{
		
			return true;
			}
		else
			return false;
	}
	
	public boolean overlaps(Rect r) {
				
		return (x  +  w) >= r.x  && // left
				
			   (r.x+r.w) >=   x  && // right
			  
			   (y  +  h) >= r.y  &&  // up
			  
			   (r.y+r.h) >=   y ;   // down
		
		
	}
	
// checks if it is inside certain area
	public boolean contains(int mx, int my)
	{
		return (mx >= x    )  &&
			   (mx <= x + w)  &&
			   (my >= y    )  &&
			   (my <= y + h);
	}
//////////////////////////////////////////////////////////////////////

///////// pushes rectangle back if collides////////////////////////////
	public void pushBackLeft(Rect r) {
	  // equation to check left reversed
		x = r.x - w - 1;
	}
	public void pushBackRight(Rect r) {
	   x =r.x+r.w + 1;
	}
	public void pushBackUp(Rect r) {
		 y = r.y - h - 1;
	}
	public void pushBackDown(Rect r) {
	   y =r.y+r.h + 1;
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
