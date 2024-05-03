package Fight;
import java.awt.*;
public class Animation 
{
private Image[] image;
private int next;
private int duration;
private int delay;
// animation is saved in folder may want to make more games in the same game if i get bored
public Animation (String game,String charecter,String direction, String pose, int count, int duration ) 
{
	image = new Image[count];
	
	for(int i =0; i < count; i++)
		image[i]= Toolkit.getDefaultToolkit().getImage(game + "/" +charecter + "/" + direction+"/"+ pose+ "/_" + i + ".png");
	
		this.duration= duration;
		delay = duration;
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// cycle images
public Image nextImage() 
{
	if(delay == 0)
	{
	next++;
	
	if (next == image.length) next = 0;
	
	
	delay = duration;
}
	delay--;
	return image[next];
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
