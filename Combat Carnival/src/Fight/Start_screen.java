package Fight;

import java.awt.*;


public class Start_screen extends Stage{
	boolean Startscreen;
	Image background = Toolkit.getDefaultToolkit().getImage("Combat Carnival/UI/Start_Screen/StartScreen.png");
	cc_player p1;
	cc_player p2;
	Image[] letters;
	

	
	boolean start = false;
	Rect[] buttons;
	public Start_screen(boolean[] pressing,Rect[] buttons, Image[] letters) {
		super(pressing);
		this.buttons = buttons;	
		this.letters = letters;
	}
	

	@Override
	public void inGameLoop() {
		// TODO Auto-generated method stub
	
		
		if(Startscreen) {
			Startscreen = false;
			stage[0]=stage[2];
		}
		
		if(buttons[1].clicked) 
		{
			Startscreen=true;
			buttons[1].clicked = false;
			
		}
		if(buttons[0].clicked) 
		{
			
		}
		
	}

	
	public void paint (Graphics g) 
	{
		// TODO Auto-generated method stub
	if(!start)
	g.drawImage(background, 0, 0,1920,1080, null);
	}

}
