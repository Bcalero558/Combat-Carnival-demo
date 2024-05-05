package Fight;

import java.awt.Graphics;

public class Hitbox extends Rect {
	ImageLayer[] bar = 
		{ 
		new ImageLayer("Combat Carnival/UI/Health/Player1(1).png",0,0,1,false),
		new ImageLayer("Combat Carnival/UI/Health/Player1(2).png",0,0,1,false),
		new ImageLayer("Combat Carnival/UI/Health/Player1(3).png",0,0,1,false),
		new ImageLayer("Combat Carnival/UI/Health/Player1(4).png",0,0,1,false),
		new ImageLayer("Combat Carnival/UI/Health/Player1(5).png",0,0,1,false),
		new ImageLayer("Combat Carnival/UI/Health/Player_2(1).png",500,0,1,false),
		new ImageLayer("Combat Carnival/UI/Health/Player_2(2).png",500,0,1,false),
		new ImageLayer("Combat Carnival/UI/Health/Player_2(3).png",500,0,1,false),
		new ImageLayer("Combat Carnival/UI/Health/Player_2(4).png",500,0,1,false),
		new ImageLayer("Combat Carnival/UI/Health/Player_2(5).png",500,0,1,false),
		};
	boolean player1;
	int Health;
	int duration = 50;
	int delay = duration;
	boolean isHurt = false;
	public Hitbox(int x, int y, int w, int h, int Health ) {
		super(x, y, w, h);
		this.Health = Health;
	}
	
	public void Damage_taken(HurtBox hurt,cc_player player)
	{
		if(delay == 0)
		{
		if(this.overlaps(hurt)) {
			Health -= 5;
			isHurt = true;
			}
				
		
		delay = duration;
		}
		delay--;
		
	}
	
	
	public void hitbox_move(cc_player player) 
	{
		if(player.action==0||player.action==1||player.action==3) {
		x = player.x+ 38;
		y =player.y+64;
		w =59;
		h = 204;
		}
		
		if(player.action == 6 && player.forward) {
			x = player.x+22;
			y =player.y+136;
			w =61;
			h = 130;
		}
		if(player.action == 6 && !player.forward) {
			x = player.x+56;
			y =player.y+134;
			w =61;
			h = 130;
		}
		if(player.action == 2 && player.forward) {
			x = player.x+22;
			y =player.y+62;
			w =77;
			h = 231;
		}
		if(player.action == 2 && !player.forward) {
			x = player.x+38;
			y =player.y+60;
			w =77;
			h = 231;
		}
		if(player.action == 5 && player.forward) {
			x = player.x+52;
			y =player.y+120;
			w =61;
			h = 142;
		}
		if(player.action == 5 && !player.forward) {
			x = player.x+42;
			y =player.y+120;
			w =61;
			h = 142;
		}
	}
	public void setHealthLocation(cc_player p) 
	{
		if(p.player1) {
			for(int i = 0; i <5; i++) 
			{
				bar[i].x = p.x;
				bar[i].y = p.y;		
			}
		}
		else
			for(int i = 5; i <10; i++) 
			{
				bar[i].x = p.x;
				bar[i].y = p.y;		
			}
	}
	
	public void showHealth(Graphics g, cc_player p) 
	{
		if(p.player1) {
			for(int i = 0; i <5; i++) 
			{
				
			}
			if(Health == 0) 
				bar[4].draw(g);
			if(Health <= 25) 
				bar[3].draw(g);
			if(Health >= 50) 
				bar[2].draw(g);
			if(Health >= 75) 
				bar[1].draw(g);
			if(Health == 100) 
			bar[0].draw(g);
		}
		else 
		{
			if(Health == 0) 
				bar[9].draw(g);
			if(Health <= 25) 
				bar[8].draw(g);
			if(Health >= 50) 
				bar[7].draw(g);
			if(Health >= 75) 
				bar[6].draw(g);
			if(Health == 100) 
			bar[5].draw(g);
			
		}
	}

	

}
