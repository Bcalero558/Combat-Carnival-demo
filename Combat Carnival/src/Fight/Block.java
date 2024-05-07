package Fight;


	public class Block extends Rect {

		public boolean blocks = false;

			public Block(int x, int y, int w, int h) {
				super(x, y, w, h);
			}

			public void block_move(cc_player player) 
			    {
				if(player.forward) {
				blocks = true;
				x = player.x+ ((96 *player.w)/140);
				y =player.y + ((87*player.h)/320);
				w =(28* player.w )/140;
				h = (178* player.h)/320;
				}
				if(!player.forward) {
					blocks = true;
					x = player.x+ ((11 *player.w)/140);
					y =player.y + ((90*player.h)/320);
					w =(28* player.w )/140;
					h = (178* player.h)/320;
					}
				}

		}

