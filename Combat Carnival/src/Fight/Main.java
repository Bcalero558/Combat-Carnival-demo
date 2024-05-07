package Fight;
import java.awt.*;
import java.awt.event.MouseEvent;


public class Main extends Base
{			
		
			Image [] Letters = 
				{
					Toolkit.getDefaultToolkit().getImage("Combat Carnival/Ui/Letters/Letter 1.png"),
					Toolkit.getDefaultToolkit().getImage("Combat Carnival/Ui/Letters/Letter 2.png"),
					Toolkit.getDefaultToolkit().getImage("Combat Carnival/Ui/Letters/Letter 3.png"),
					Toolkit.getDefaultToolkit().getImage("Combat Carnival/Ui/Letters/Letter 4.png"),
					Toolkit.getDefaultToolkit().getImage("Combat Carnival/Ui/Letters/Letter 5.png"),
					Toolkit.getDefaultToolkit().getImage("Combat Carnival/Ui/Letters/Letter 6.png"),
					Toolkit.getDefaultToolkit().getImage("Combat Carnival/Ui/Letters/Letter 7.png"),
					Toolkit.getDefaultToolkit().getImage("Combat Carnival/Ui/Letters/Letter 8.png"),
					Toolkit.getDefaultToolkit().getImage("Combat Carnival/Ui/Letters/Letter 9.png"),
					Toolkit.getDefaultToolkit().getImage("Combat Carnival/Ui/Letters/Letter 10.png"),
					Toolkit.getDefaultToolkit().getImage("Combat Carnival/Ui/Letters/Letter 11.png"),
					Toolkit.getDefaultToolkit().getImage("Combat Carnival/Ui/Letters/Letter 12.png"),
					Toolkit.getDefaultToolkit().getImage("Combat Carnival/Ui/Letters/Letter 13.png"),
					Toolkit.getDefaultToolkit().getImage("Combat Carnival/Ui/Letters/Letter 14.png"),
					Toolkit.getDefaultToolkit().getImage("Combat Carnival/Ui/Letters/Letter 15.png"),
					Toolkit.getDefaultToolkit().getImage("Combat Carnival/Ui/Letters/Letter 16.png"),
					Toolkit.getDefaultToolkit().getImage("Combat Carnival/Ui/Letters/Letter 17.png"),
					Toolkit.getDefaultToolkit().getImage("Combat Carnival/Ui/Letters/Letter 18.png"),
					Toolkit.getDefaultToolkit().getImage("Combat Carnival/Ui/Letters/Letter 19.png"),
					Toolkit.getDefaultToolkit().getImage("Combat Carnival/Ui/Letters/Letter 20.png"),
					Toolkit.getDefaultToolkit().getImage("Combat Carnival/Ui/Letters/Letter 21.png"),
					Toolkit.getDefaultToolkit().getImage("Combat Carnival/Ui/Letters/Letter 22.png"),
					Toolkit.getDefaultToolkit().getImage("Combat Carnival/Ui/Letters/Letter 23.png"),
					Toolkit.getDefaultToolkit().getImage("Combat Carnival/Ui/Letters/Letter 24.png"),
					Toolkit.getDefaultToolkit().getImage("Combat Carnival/Ui/Letters/Letter 25.png"),
					Toolkit.getDefaultToolkit().getImage("Combat Carnival/Ui/Letters/Letter 26.png"),
					Toolkit.getDefaultToolkit().getImage("Combat Carnival/Ui/Letters/Letter 27.png"),
					Toolkit.getDefaultToolkit().getImage("Combat Carnival/Ui/Letters/Letter 28.png"),
				
				}; 
		
					
			boolean Startscreen = false;
			boolean Fightscreen = false;
			
	
		   Rect[] buttons = { 
				   new Rect(608, 622, 726, 264),
				   new Rect(630, 354, 690, 190)
		   };
			
		
		   
		  
		  
		  Start_screen start = new Start_screen(pressing,buttons,null);
		  Fighting_Stage_1 fight = new Fighting_Stage_1(pressing,Letters);
		 
		  public void init() 
		  {
			  super.init();
			  Stage.stage[0] = Stage.stage[1];
			  
		
		  }
		
		public void gameLoop() 
		{
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