package Fight;

import java.awt.Graphics;

public class Sprite extends Rect
{
	
	int direction = 1;
	
	Animation[] animation;
	
	int action = 0;
	
	boolean moving = false;
	
	
	
	public Sprite(String name, String[] pose, int x, int y, int count, int duration)
	{
		super(x, y, 50, 100);
		
		animation = new Animation[pose.length];
		
		for(int i = 0; i < animation.length; i++)
		{
			animation[i] = new Animation(name + "_" + pose[i], count, duration);
		}
		
	}
	
	public void goLT(int dx)
	{
		super.goLT(dx);
		
		action = 2;
		
		moving = true;
	}
	
	public void goRT(int dx)
	{
		super.goRT(dx);

		action = 3;

		moving = true;
	}
	
	public void goUP(int dy)
	{
		super.goUP(dy);

		action = 1;
		
		moving = true;
	}
	public void goDN(int dy)
	{
		super.goDN(dy);

		action = 0;

		moving = true;
	}
	
	
	
	
	public void draw(Graphics pen)
	{
		if(!moving)
		{
			pen.drawImage(animation[action].stillImage(), x, y, w, h, null);
		}
		else
		{
			pen.drawImage(animation[action].nextImage(), x, y, w, h, null);
			
			moving = false;
		}
		
		pen.drawRect(x, y, w, h);
	}

}