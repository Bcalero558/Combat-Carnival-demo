package Fight;

import java.awt.Graphics;

public class Start_screen extends Stage{

	boolean start = false;
	public Start_screen(boolean[] pressing) {
		super(pressing);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void inGameLoop() {
		// TODO Auto-generated method stub
		if(pressing[ENTER]) 
		{
			stage[0]=stage[2];
		}
	}

	
	public void paint (Graphics g) 
	{
		// TODO Auto-generated method stub
	if(!start)
	g.drawString(" To Start Press W ", 500, 500);
	else
		g.drawString(" Welcome", 500, 500);

	}

}
