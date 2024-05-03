package Fight;

public class HurtBox extends Rect {

	public HurtBox(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	public void hurtbox_move(cc_player player) 
	{
		if(player.action==3&& player.forward) {
		x = player.x+18;
		y =player.y+31;
		w =32;
		h = 105;
		}
		if(player.action==3&& !player.forward) {
			x = player.x+18;
			y =player.y+31;
			w =32;
			h = 105;
			}
		if(player.action == 6 && player.forward) {
			x = player.x+13;
			y =player.y+66;
			w =30;
			h = 69;
		}
		if(player.action == 6 && !player.forward) {
			x = player.x+28;
			y =player.y+66;
			w =30;
			h = 69;
		}
		if(player.action == 2 && player.forward) {
			x = player.x+13;
			y =player.y+31;
			w =37;
			h = 115;
		}
		if(player.action == 2 && !player.forward) {
			x = player.x+20;
			y =player.y+31;
			w =37;
			h = 115;
		}
		if(player.action == 5 && player.forward) {
			x = player.x+27;
			y =player.y+56;
			w =29;
			h = 81;
		}
		if(player.action == 5 && !player.forward) {
			x = player.x+22;
			y =player.y+56;
			w =29;
			h = 81;
		}
	}

}
