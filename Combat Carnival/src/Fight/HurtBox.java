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
		x = player.x+ 93;
		y =player.y + 138;
		w =39;
		h = 33;
		
		}
	
		else if(player.action==3&& !player.forward) {
			hurts = true;
			this.x = player.x+10;
			this.y =player.y+137;
			this.w =39;
			this.h = 33;
			}
		//lower
		else if(player.action == 6 && player.forward) {
			hurts = true;
			this.x = player.x+73;
			this.y =player.y+237;
			this.w =39;
			this.h = 30;
		}
		else if(player.action == 6 && !player.forward) {
			hurts = true;
			this.x = player.x+27;
			this.y =player.y+237;
			this.w =39;
			this.h = 30;
		}
		//overhead
		else if(player.action == 5 && player.forward) {
			hurts = true;
			this.x = player.x+88;
			this.y =player.y+43;
			this.w =64;
			this.h = 165;
		}
		else if(player.action == 5 && !player.forward) {
			hurts = true;
			this.x = player.x+10;
			this.y =player.y+47;
			this.w =64;
			this.h = 165;
		}
		else
			hurts = false;
	}

}
