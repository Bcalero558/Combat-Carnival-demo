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
	public void CameraMovement(Rect r1,Rect r2,int distance) 
	{
	if ((x - distance <= r1.x)&&(x - distance <= r2.x))  
		moveCameraR = true;
	else
		moveCameraR = false;
	
	if ((x + distance >= r1.x+r1.w)&&(x + distance >= r1.x+r1.w))  
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
