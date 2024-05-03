package Fight;

import java.awt.*;

public class ImageLayer {
	public Image image; 
	int x ,y ,z;
	boolean background;
	public ImageLayer(String filename, int x, int y, int z, boolean back)
	{
	image = Toolkit.getDefaultToolkit().getImage(filename);
	this.x = x;
	this.y = y;
	this.z = z;

	this.background = back;
	}
	public void draw(Graphics g) 
	{
	if (background)
		for(int i = 0; i <10;i++) 
		{
	
		g.drawImage(image, x + i*1920 - Camera.x / z , y - Camera.y / z,1920, 1080 , null);
		
		}
	else
		g.drawImage(image, x - Camera.x/z, y - Camera.y/z,null);
	}
}
