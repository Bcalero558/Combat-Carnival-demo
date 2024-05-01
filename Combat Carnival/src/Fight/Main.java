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
boolean H_pressed = false;
 Thread t = new Thread (this);
    int mx = -1;
    int my = -1;
    Image    offScreenImg;
	Graphics offScreenG;
 ///////////////////////////////////////////////////////
   
////Objects /////////////////////////////////////////////    
    Rect[] wall = 
	{
			   new Rect (-2, 869, 1919, 100),
			   new Rect (-1, 509, 60, 360),  
			   new Rect (1805, 509, 114, 360)
   };
   Rect p1 = new Rect (616, 700, 70, 160);
Image Background = Toolkit.getDefaultToolkit().getImage("Combat Carnival/background/10.png");
///////////////////////////////////////////////////////////////////////


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
			if(W_pressed) p1.jump();
			if(!p1.overlaps(wall[1]))
			if(A_pressed) p1.moveLT(10);
			//if(S_pressed) p1.moveDN(10);
			if(!p1.overlaps(wall[2]))
			if(D_pressed) p1.moveRT(10);
			p1.move();
		/*	if(H_pressed) {
			System.out.println("Rect " + (1) + " " + wall[0].toString());
			System.out.println("Rect " + (2) + " " + wall[1].toString());
			System.out.println("Rect " + (3) + " " + wall[2].toString());
			System.out.println("player " + (1) + " " + p1.toString());
			}
			*/
			if (p1.overlaps(wall[0])) 	{p1.airtime = false; p1.pushedOutOf(wall[0]);}
			
			for(int i = 1; i < wall.length;i++) {
				if (p1.overlaps(wall[i])) 
			{
				p1.pushedOutOf(wall[i]);
				
			}
			}
						/* makes it so program runs with frame rate rather than infinite speed */
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
		g.drawImage(Background, 0, 0, null);
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
	// checks the mouse location when button is pressed
/*mx = e.getX();
my = e.getY();
	System.out.println( mx + " , " + my );
	
	for(int i = 0; i < wall.length;i++) {
	if(wall[i].contains(mx, my)) wall[i].grabbed();
	
	if (wall[i].resizer.contains(mx, my)) wall[i].resizer.grabbed();

}
*/
}

@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
/*
	for(int i = 0; i < wall.length;i++) {
	wall[i].dropped();
	wall[i].resizer.dropped();
	}
*/
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
	/*
	int nx = e.getX();
	int ny = e.getY();
	
	int dx = nx - mx;
	int dy = ny - my;
	for(int i = 0; i < wall.length;i++) {
	if(wall[i].resizer.held)  wall[i].resizeBy(dx,  dy);
	else
	if(wall[i].held)  wall[i].moveBy(dx, dy);
	}
	mx = nx;
	my = ny;
*/
}
	


@Override
public void mouseMoved(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
/////////////////////////////////////////////////////////////////////////////

}