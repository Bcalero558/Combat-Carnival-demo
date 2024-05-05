package Fight;

import java.awt.Graphics;

public class CameraFocus extends Rect {
boolean moveCameraL = false;
boolean moveCameraR = false;
	public CameraFocus(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	public void draw(Graphics g) 
	{
		g.drawRect(x - Camera.x, y-Camera.y, w, h);
	}
	
	//checks how far is a rect from the focus of the camera
	public boolean moveRight(Rect r1,int distance) 
	{
		return x - distance <= r1.x;
	}
	
	public boolean moveLeft(Rect r1,int distance) 
	{
		return x + distance >= r1.x+r1.w;
	}
	public void CameraMovement(Rect r1,Rect r2,int distance) 
	{
	if ((this.moveRight(r1, distance))&&!this.moveLeft(r2, distance)) { 
		moveCameraR = true;
		
	}
	else 
		moveCameraR=false;
	
	if (this.moveLeft(r1, distance)&&!(this.moveRight(r2,distance)))  
		moveCameraL = true;
	
	else 
		moveCameraL=false;
	
	if ((this.moveRight(r2, distance))&&!this.moveLeft(r1, distance)) { 
		moveCameraR = true;
		
	}
	else 
		moveCameraR=false;
	
	if (this.moveLeft(r2, distance)&&!(this.moveRight(r1,distance)))  
		moveCameraL = true;
	
	else 
		moveCameraL=false;

		
	}
	public  void moveLT(int dx)	
	{
	   x -= dx;
	}
	public  void moveRT(int dx)	
	{
		x += dx;
	}
	public  void moveDN(int dy)	
	{
		y -= dy;
	}
	public  void moveUP(int dy)	
	{
		y += dy;
	}
}
