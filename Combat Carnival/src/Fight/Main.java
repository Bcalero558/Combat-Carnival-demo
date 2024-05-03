package Fight;
import java.awt.*;


public class Main extends Base
{
		 boolean leftOfScreen = true;
		   
			
		   cc_player p1 = new cc_player("default", 616 -Camera.x, 350 - Camera.y, 10 ,140,320, leftOfScreen);
		   cc_player p2 = new cc_player("default", 1496 -Camera.x, 350 - Camera.y, 10 ,140,320, !leftOfScreen);
		   
		  Start_screen start = new Start_screen(pressing);
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







	}