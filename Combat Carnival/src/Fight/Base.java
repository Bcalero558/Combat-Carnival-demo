package Fight;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


public class Base extends Applet implements Runnable, KeyListener, MouseListener, MouseMotionListener
{
//base variables/////
boolean W_pressed = false;
boolean A_pressed = false;
boolean S_pressed = false;
boolean D_pressed = false;
boolean H_pressed = false;
 Thread t = new Thread (this);
    int mx = -1;
    int my = -1;
    Image    offScreenImg;
	Graphics offScreenG;
 ///////////////////////////////////////////////////////
   
public void gameLoop () {
	
}
//Initializes anything used in program//////////////
	public void init() 
	{
		offScreenImg = createImage(1920, 1200);
		offScreenG = offScreenImg.getGraphics();
		
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
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
			
		// adds code
			gameLoop();
			
			repaint();
			try 
			{
				t.sleep(16);
			}catch(Exception x) {};
			
		}
	}
////////////////////////////////////////////
	
////// draws what happens////////////////////
	public void paint(Graphics g) 
	{
		
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
	
	if (key == e.VK_H) H_pressed = true;

}

public void keyReleased(KeyEvent e) 
{
int key = e.getKeyCode();
	
	if (key == e.VK_W) W_pressed = false;
	
	if (key == e.VK_A) A_pressed = false;
	
	if (key == e.VK_S) S_pressed = false;
	
	if (key == e.VK_D) D_pressed = false;
	
	if (key == e.VK_H) H_pressed = false;

}
///////////////////////////////////////////////

////////removes flickering//////////
public void update(Graphics g)
{
	offScreenG.clearRect(0, 0, 1920, 1200);
	
	paint(offScreenG);
	
	g.drawImage(offScreenImg, 0, 0, null);	
}
///////////////////////////////////////////////

/////mouse actions/////////////////////////////////////////
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mousePressed(MouseEvent e) {

mx = e.getX();
my = e.getY();
	System.out.println( mx + " , " + my );

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
	
	mx = nx;
	my = ny;
}
	


@Override
public void mouseMoved(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
/////////////////////////////////////////////////////////////////////////////

}