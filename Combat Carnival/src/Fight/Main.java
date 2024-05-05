package Fight;
import java.awt.*;
import java.awt.event.MouseEvent;


public class Main extends Base
{			
		
		 boolean leftOfScreen = true;
		   Rect[] buttons = { 
				   new Rect(608, 622, 726, 264),
				   new Rect(630, 354, 690, 190)
		   };
			
		   cc_player p1 = new cc_player("default", 616 -Camera.x, 300 - Camera.y, 10 ,280,640, leftOfScreen);
		   cc_player p2 = new cc_player("default", 1496 -Camera.x, 300 - Camera.y, 10 ,280,640, !leftOfScreen);
		   
		  Start_screen start = new Start_screen(pressing,buttons);
		  Fighting_Stage_1 fight =  new Fighting_Stage_1(pressing, p1,p2);
		  
		 
		  public void init() 
		  {
			  super.init();
			  Stage.stage[0] = Stage.stage[1];
		  }
		
		public void gameLoop() {
			Stage.stage[0].inGameLoop();
		}

		
		public void paint(Graphics g) 
		{
			Stage.stage[0].paint(g);
		}


		public void mouseDragged(MouseEvent e)
		{
			int nx = e.getX();
			int ny = e.getY();
			
			int dx = nx - mx;
			int dy = ny - my;
		
			
			mx = nx;
			my = ny;
		}
		
		public void mousePressed(MouseEvent e)
		{
			mx = e.getX();
			my = e.getY();
			
			if(buttons[0].contains(mx,  my))  buttons[0].clicked = true;
			
			
			if(buttons[1].contains(mx,  my))  buttons[1].clicked = true;
			
		}
		
		
		public void mouseReleased(MouseEvent e)
		{
			for(int i = 0; i< buttons.length;i++) {
			buttons[i].dropped();
		
			
			buttons[i].dropped();
			
			}
			}




	}