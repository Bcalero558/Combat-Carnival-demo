package Fight;

public class HurtBox extends Rect {

public boolean hurts = false;

	public HurtBox(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	public void hurtbox_move(cc_player player) 
	{
		//jab
		if(player.action==3&& player.forward) {
		
		hurts = true;
		x = player.x+ ((93 *player.w)/140);
		y =player.y + ((138*player.h)/320);
		w =(39* player.w )/140;
		h = (33* player.h)/320;
		
		}
	
		else if(player.action==3&& !player.forward) {
			hurts = true;
			this.x = player.x+((10 *player.w)/140);
			this.y =player.y+((137*player.h)/320);
			this.w =(39* player.w )/140;
			this.h = (33* player.h)/320;
			}
		//lower
		else if(player.action == 6 && player.forward) {
			hurts = true;
			this.x = player.x+((73 *player.w)/140);
			this.y =player.y+((237*player.h)/320);
			this.w =(39* player.w )/140;
			this.h = (30* player.h)/320;
		}
		else if(player.action == 6 && !player.forward) {
			hurts = true;
			this.x = player.x+((27 *player.w)/140);
			this.y =player.y+((237*player.h)/320);
			this.w =(39* player.w )/140;
			this.h = (30* player.h)/320;
		}
		//overhead
		else if(player.action == 5 && player.forward) {
			hurts = true;
			this.x = player.x+((88 *player.w)/140);
			this.y =player.y+((43*player.h)/320);
			this.w =(64* player.w )/140;
			this.h = (165* player.h)/320;
		}
		else if(player.action == 5 && !player.forward) {
			hurts = true;
			this.x = player.x+((10 *player.w)/140);
			this.y =player.y+((47*player.h)/320);
			this.w =(64* player.w )/140;
			this.h = (165* player.h)/320;
		}
		else
			hurts = false;
	}

}
