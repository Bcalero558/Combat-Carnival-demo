package Fight;

import java.awt.*;

public class Hitbox extends Rect {
	
	Image[] UI ; 
	
	
	
	boolean player1;
	int Health;
	int duration = 50;
	int delay = duration;
	boolean isHurt = false;
	public Hitbox(int x, int y, int w, int h, int Health ) {
		super(x, y, w, h);
		this.Health = Health;
		
		UI = new Image[10];
		for(int i = 0; i < 5;i++) 
		{
			UI[i] = Toolkit.getDefaultToolkit().getImage("Combat Carnival/UI/Health/Player1 ("+(i+1)+").png");
					
			}
		
		for(int i = 0; i < 5;i++) 
		{
			UI[i+5] = Toolkit.getDefaultToolkit().getImage("Combat Carnival/UI/Health/Player_2 ("+(i+1)+").png");
					
			}
		}
	
	
	
	public void Damage_taken(HurtBox hurt,cc_player player)
	{
		if(delay == 0)
		{
		if(this.overlaps(hurt)) {
			if(Health > 0)
			Health -= 5;
			isHurt = true;
			}
				
		
		delay = duration;
		}
		delay--;
		
	}
	public boolean isDead() 
	{
		return Health <= 0;
	}
	
	public void hitbox_move(cc_player player) 
	{
		if(player.action==0||player.action==1||player.action==3) {
		x = player.x+ ((38 *player.w)/140);
		y =player.y+((64*player.h)/320);
		w =( 59 * player.w )/140;
		h = (204 * player.h)/320;
		}
		
		if(player.action == 6 && player.forward) {
			x = player.x+((22*player.w)/140);
			y =player.y + ((136*player.h)/320);
			w =(61* player.w )/140;
			h = (130* player.h)/320;
		}
		if(player.action == 6 && !player.forward) {
			x = player.x + ((56*player.w)/140);
			y =player.y+ ((134*player.h)/320);
			w =(61* player.w )/140;
			h = (130* player.h)/320;
		}
		if(player.action == 2 && player.forward) {
			x = player.x+((22*player.w)/140);
			y =player.y+((62*player.h)/320);
			w =(77* player.w )/140;
			h = (231* player.h)/320;
		}
		if(player.action == 2 && !player.forward) {
			x = player.x+((38*player.w)/140);
			y =player.y+((60*player.h)/320);
			w =(77* player.w )/140;
			h = (231* player.h)/320;
		}
		if(player.action == 5 && player.forward) {
			x = player.x+((52*player.w)/140);
			y =player.y+((120*player.h)/320);
			w =(61* player.w )/140;
			h = (142* player.h)/320;
		}
		if(player.action == 5 && !player.forward) {
			x = player.x+((42*player.w)/140);
			y =player.y+ ((120*player.h)/320);
			w = (61* player.w )/140;
			h = (142* player.h)/320;
		}
	}
	/*
	public void setHealthLocation(CameraFocus p) 
	{
		
			for(int i = 0; i <5; i++) 
			{
				bar[i].x = p.x;
				bar[i].y = p.y;		
			}
	
		
			for(int i = 5; i <10; i++) 
			{
				bar[i].x = p.x;
				bar[i].y = p.y;		
			}
	}
	*/
	public void showHealth(Graphics g, cc_player p) 
	{
		if(p.player1) {
			for(int i = 0; i <5; i++) 
			{
				
			}
			if(Health == 0) 
				g.drawImage(UI[4],0, 0, 597,140,null);
			if(Health > 0) 
				g.drawImage(UI[3],0, 0, 597,140,null);
			if(Health >= 30) 
				g.drawImage(UI[2],0, 0, 597,140,null);
			if(Health >= 60) 
				g.drawImage(UI[1],0, 0, 597,140,null);
			if(Health == 100) 
				g.drawImage(UI[0],0, 0, 597,140,null);
		}
		else 
		{
			if(Health == 0) 
				g.drawImage(UI[9],1320, 0, 597,140,null);
			if(Health >0) 
				g.drawImage(UI[8],1320, 0, 597,140,null);
			if(Health >= 30) 
				g.drawImage(UI[7],1320, 0, 597,140,null);
			if(Health >= 60) 
				g.drawImage(UI[6],1320, 0, 597,140,null);
			if(Health == 100) 
				g.drawImage(UI[5],1320, 0, 597,140,null);
			
		}
	}

	

}
