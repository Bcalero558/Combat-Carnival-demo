package Fight;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


public class Main extends Applet implements Runnable, KeyListener, MouseListener, MouseMotionListener
{
//base variables/////
boolean W_pressed = false;
boolean A_pressed = false;
boolean S_pressed = false;
boolean D_pressed = false;
 Thread t = new Thread (this);
    int mx;
    int my;
 ///////////////////////////////////////////////////////
   
////Objects /////////////////////////////////////////////    
    Rect2[] wall = 
	{
			   new Rect2 (10,10,10,10),
			   new Rect2 (10,10,10,10),  
			   new Rect2 (20,10,10,10)
   };
   Rect p1 = new Rect (20,10,10,10);
Image Background = Toolkit.getDefaultToolkit().getImage("Combat Carnival/background/10.png");
///////////////////////////////////////////////////////////////////////


//Initializes anything used in program//////////////
	public void init() 
	{
		addKeyListener(this);
		addMouseListener(this);
		requestFocus();
		t.start();
	}
//////////////////////////////////////
	
///runs program///////////////////////
	public void run() 
	{
		/* game loop */
		while (true) 
		{
			if(W_pressed) p1.moveBy(0, -1);
			if(A_pressed) p1.moveBy(-1, 0);
			if(S_pressed) p1.moveBy(0, 1);
			if(D_pressed) p1.moveBy(1, 0);
			for(int i = 0; i < wall.length;i++) {
			if (p1.overlaps(wall[i])) {
				if(p1.fromLeft(wall[i]))
					p1.pushBackLeft(wall[i]);
		
				if(p1.fromRight(wall[i]))
					p1.pushBackRight(wall[i]);
			
				if(p1.fromUp(wall[i]))
					p1.pushBackUp(wall[i]);
		
				if(p1.fromDown(wall[i]))
					p1.pushBackDown(wall[i]);
			}
			}			/* makes it so program runs with frame rate rather than infinite speed */
			try 
			{
				t.sleep(16);
			}catch(Exception x) {};
			repaint();
		}
	}
////////////////////////////////////////////
	
////// draws what happens////////////////////
	public void paint(Graphics g) 
	{
		g.setColor(Color.yellow);
		for(int i = 0; i < wall.length;i++)
		wall[i].draw(g);
		
		g.setColor(Color.green);
		p1.draw(g);
	}
/////////////////////////////////////////////////

//////keyboard commands/////////////////////
public void keyTyped(KeyEvent e) 
{
	
}

public void keyPressed(KeyEvent e) 
{
	int key = e.getKeyCode();
	if (key == e.VK_W) W_pressed = true;
	
	if (key == e.VK_A) A_pressed = true;
	
	if (key == e.VK_S) S_pressed = true;
	
	if (key == e.VK_D) D_pressed = true;

}

public void keyReleased(KeyEvent e) 
{
int key = e.getKeyCode();
	
	if (key == e.VK_W) W_pressed = false;
	
	if (key == e.VK_A) A_pressed = false;
	
	if (key == e.VK_S) S_pressed = false;
	
	if (key == e.VK_D) D_pressed = false;

}
///////////////////////////////////////////////

////////removes flickering//////////
public void update(Graphics g)
{
	g.drawImage(Background,0,0,1920,1080,null);
	paint(g);
	
}
///////////////////////////////////////////////

/////mouse actions/////////////////////////////////////////
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mousePressed(MouseEvent e) {
	// checks the mouse location when button is pressed
mx = e.getX();
my = e.getY();
	System.out.println( mx + " , " + my );
	
	for(int i = 0; i < wall.length;i++) {
	if(wall[i].contains(mx, my)) wall[i].grab();
	
	if (wall[i].resizer.contains(mx, my)) wall[i].resizer.grab();
}
}

@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseDragged(MouseEvent e)
{
	
	int nx = e.getX();
	int ny = e.getY();
	int dx = nx - mx;
	int dy = ny - my;
	for(int i = 0; i < wall.length;i++)
	{
		
	if(wall[i].resizer.held)
	{
		wall[i].resizeBy(dx,dy);
	
	}
	else if(wall[i].held)
	{
		wall[i].moveBy(dx,dy);
	}
	mx=nx;
	my=ny;
	
	}
}

@Override
public void mouseMoved(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
/////////////////////////////////////////////////////////////////////////////

}