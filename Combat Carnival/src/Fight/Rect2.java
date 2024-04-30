package Fight;
import java.awt.*;

public class Rect2 extends Rect {
	Rect resizer;	
//constructor//////////////////////////////////////
	public Rect2(int x, int y, int w, int h) {
		super(x, y, w, h);
		
		
		resizer = new Rect(x + w - 10,y + h - 10,10,10);
	}
///////////////////////////////////////////////////////////

////draw rect /////////////////////////////////////////////////
	public void draw(Graphics g)
	{
		super.draw(g);
		
		resizer.draw(g);
		
	}
////////////////////////////////////////////////////////////////
	
	public void moveBy(int dx, int dy)
	{
		super.moveBy(dx, dy);
		resizer.moveBy(dx, dy);
	}
	
	public void resizeBy(int dw, int dh) {
		
		super.resizeBy(dw,dh);
		resizer.moveBy(dw, dh);
	
	}
	


}
