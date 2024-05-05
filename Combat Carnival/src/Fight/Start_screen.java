package Fight;

import java.awt.Graphics;

public class Start_screen extends Stage{
	
	ImageLayer background = new ImageLayer("Combat Carnival/UI/Start_Screen/StartScreen.png",0,0,1,true) ; 
	boolean start = false;
	Rect[] buttons;
	public Start_screen(boolean[] pressing,Rect[] buttons) {
		super(pressing);
		this.buttons = buttons;	

	}

	@Override
	public void inGameLoop() {
		// TODO Auto-generated method stub
	
		
		
		
		if(buttons[1].clicked) 
		{
			stage[0]=stage[2];
		}
		if(buttons[0].clicked) 
		{
			
		}
		
	}

	
	public void paint (Graphics g) 
	{
		// TODO Auto-generated method stub
	if(!start)
	background.draw(g);
	for(int i =0; i < buttons.length;i++)
		buttons[i].draw(g);

	}

}
