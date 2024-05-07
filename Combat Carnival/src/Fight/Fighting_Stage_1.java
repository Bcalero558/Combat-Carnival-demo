package Fight;

import java.awt.*;


public class Fighting_Stage_1  extends Stage{

	
////Objects /////////////////////////////////////////////
	boolean Fightscreen = false;
	boolean leftOfScreen = true;
	boolean gameover = true;
	public int[] wordPlayer = 
	{
		16,12,1,25,5,18
	};
	public int[] wordWins = 
	{
		23,9,14,19
	};
	public int[] wordTie = 
	{
		4,18,1,23
	};
   double timer1 = 0;
   double lasttime1 = 0;
   double now;
   double timer2 = 0;
   double lasttime2 = 0;
   int Letterposition = 0;
	Rect[] wall = 
	{
			   new Rect (-2, 1050, 50000, 100),
			   new Rect (-80 - Camera.x/1, 509 - Camera.y/1 , 60, 360),  
			   new Rect (1929-Camera.x/1, 509-Camera.y/1, 114, 360)
   };
	boolean testing = false;
	   cc_player p1 = new cc_player("default", 616 -Camera.x, 300 - Camera.y, 10 ,280,640, leftOfScreen);
	   cc_player p2 = new cc_player("default", 1496 -Camera.x, 300 - Camera.y, 10 ,280,640, !leftOfScreen);
	Image[] letters;
	
	Block block1 = new Block(1200,1100,1,1);
	Block block2 = new Block(1200,1100,1,1);

	Hitbox Hitbox1 = new Hitbox(180,310,32,105,100);
	Hitbox Hitbox2 = new Hitbox(180,310,32,105,100);
	HurtBox Hurtbox1 = new HurtBox(1000,1000,1,1);
	HurtBox Hurtbox2 = new HurtBox(1000,1000,1,1);
	
	CameraFocus center = new CameraFocus (972, 708,70,160);
ImageLayer[] Background = 
		{ 
		new ImageLayer("Combat Carnival/background/6.png",-500,0,10,true),
		new ImageLayer("Combat Carnival/background/2.png",-500,0,4,true),
		new ImageLayer("Combat Carnival/background/3.png",-500,0,3,true),
		new ImageLayer("Combat Carnival/background/4.png",-500,0,2,true),
		new ImageLayer("Combat Carnival/background/7.png",250,-200,10,true),
		new ImageLayer("Combat Carnival/background/5.png",-500,0,1,true)
		};
ImageLayer Floor = new ImageLayer("Combat Carnival/background/floor.PNG",0,869,5,false);

///////////////////////////////////////////////////////////////////////
	
public Fighting_Stage_1(boolean[] pressing, Image[] letters) 
{
	super(pressing);
	this.letters = letters;

}

////////////////////////////////////////////////////////////////////////////////////////////////
@Override
	public void inGameLoop() {
		// TODO Auto-generated method stub
	if(Fightscreen) {
		Fightscreen = false;
		   p1 = new cc_player("default", 616 -Camera.x, 300 - Camera.y, 10 ,280,640, leftOfScreen);
		    p2 = new cc_player("default", 1496 -Camera.x, 300 - Camera.y, 10 ,280,640, !leftOfScreen);
	
		
		 block1 = new Block(1200,1100,1,1);
		 block2 = new Block(1200,1100,1,1);

		 Hitbox1 = new Hitbox(180,310,32,105,100);
		 Hitbox2 = new Hitbox(180,310,32,105,100);
		 Hurtbox1 = new HurtBox(1000,1000,1,1);
		 Hurtbox2 = new HurtBox(1000,1000,1,1);
		stage[0]=stage[1];
	
	}
		now = System.currentTimeMillis();
		block1 = new Block(1100,1100,1,1);
		block2 = new Block(1200,1200,1,1);
		p1.testing = testing;
		p2.testing = testing;
		block1.blocks=false;
		block2.blocks=false;
		testing = false;
		if (timer1 == 0) {
		p1.moving= false;
		p1.attacking= false;
		}
		if (timer2 == 0) {
		p2.moving= false;
		p2.attacking= false;
		}
		Hitbox1.hitbox_move(p1);
		Hurtbox1.hurtbox_move(p1);
		if(!Hurtbox1.hurts)
			Hurtbox1 =  new HurtBox(10000,10000,1,1);
		Hitbox2.hitbox_move(p2);
		Hurtbox2.hurtbox_move(p2);
		if(!Hurtbox2.hurts)
			Hurtbox2 =  new HurtBox(10000,10000,1,1);
		Hitbox1.Damage_taken(Hurtbox2,p1);
		Hitbox2.Damage_taken(Hurtbox1,p2);
		
		
		
		
		center.CameraMovement(p1,p2, 500);
		if(!Hitbox1.isDead()&&!Hitbox2.isDead()) 
			{	
			this.playing();
			}
		else {
			
		if(Hitbox1.isDead()) {
			p1.dies(Hitbox1);
		}
		 if(Hitbox2.isDead()) {
			p2.dies(Hitbox2);
		}
		if(pressing[ENTER]) 
		{
			Fightscreen = true;
			 
			
			
		}
		}
		}
/////////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////////////
public void playing() 
{


	if(timer1 > 0)
		timer1--;
	if (timer2>0)
	timer2--;
	//attacks
	if (pressing[_R] && timer1 == 0) {
		timer1 = 42;
		p1.overhead_attack();
	}
	
	if (pressing[_F] && timer1 == 0) {
		timer1 = 42;
		p1.basic_attack();
		
	}
		
		
	if (pressing[_V] && timer1 == 0) {
		timer1 = 42;
		p1.lower_attack();
	}

	if(pressing[_W] && timer1 == 0) {
	p1.jump();
	if(!p1.attacking)
	timer1 = 2;

	}

if(pressing[_A] && timer1 == 0) 
{
	if(!p1.overlaps(wall[1]))
		p1.moveLT(5);
	else
	p1.moveLT(0);
	if(!p1.attacking)
	timer1 = 2;
}
//if(pressing[_S]) p1.moveDN(10);

if(pressing[_D] && timer1 == 0) 
	{
	
	if(!p1.overlaps(wall[2]))
	p1.moveRT(5);
	else
	p1.moveRT(0);
	if(!p1.attacking)
	timer1 = 2;
	}

p1.move();
//////////////////////////////////////////////////////////////////////////////////

//attacks
	if (pressing[_Y]&& timer2 == 0) {
		timer2 = 42;
		p2.overhead_attack();
	}
	if (pressing[_H]&& timer2 == 0) {
		timer2 = 42;
		p2.basic_attack();	
	}
	if (pressing[_N] && timer2 == 0) {
		timer2 = 42;
		p2.lower_attack();
	}
	
if(pressing[_I]&& timer2 == 0) {
	p2.jump();
	if(!p2.attacking)
	timer2 = 2;
	}

if(pressing[_J] && timer2 == 0) 
{
	if(!p2.overlaps(wall[1]))
		p2.moveLT(5);
	else
	p2.moveLT(0);
	if(!p2.attacking)
	timer2 = 2;
}

if(pressing[_S]&&!p1.moving&&!p1.attacking) 
	block1.block_move(p1);

if(pressing[_L]&& timer2 == 0) 
{
	
if(!p2.overlaps(wall[2]))
p2.moveRT(5);
else
p2.moveRT(0);
if(!p1.attacking)
timer2 = 2;

}


p2.move();


if(center.moveCameraL) 
{
	Camera.moveLT(15); 
	center.moveLT(15);

									}

if(center.moveCameraR) 
{ 
	Camera.moveRT(15);
	center.moveRT(15);
	 
}


if(pressing[_T]) {
System.out.println("Rect " + (1) + " " + wall[0].toString());
System.out.println("Rect " + (2) + " " + wall[1].toString());
System.out.println("Rect " + (3) + " " + wall[2].toString());
System.out.println("player " + (1) + " " + p1.toString());
}

if (p1.overlaps(wall[0])) 	
{
	p1.airtime = false; 
	p1.pushedOutOf(wall[0]);
}

for(int i = 1; i < wall.length;i++) {
	if (p1.overlaps(wall[i])) 
{
	p1.pushedOutOf(wall[i]);
	
}
}
//////////////////////////////////////////////////////////////////////////////////////////
if (p2.overlaps(wall[0])) 	
{
	p2.airtime = false; 
	p2.pushedOutOf(wall[0]);
}

for(int i = 1; i < wall.length;i++) {
	if (p2.overlaps(wall[i])) 
{
	p2.pushedOutOf(wall[i]);
	
}
}

if (Hitbox1.overlaps(Hitbox2)) 
{
	
	if(p1.forward&&!p2.forward) {
		p1.moveLT(15);
		p2.moveRT(15);
	}
	if(!p1.forward&&p2.forward) {
		p1.moveLT(15);
		p2.moveRT(15);
	}
	
}



if(pressing[_P]) 
{
	if(testing == true) 
	{
	testing = false;	
	}
	if(testing == false) {
		testing = true;
	}
}	}

//////////////////////////////////////////////////////////////////////////////	
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		for(int i = 0; i<6;i++)
			Background[i].draw(g);
			for(int i =-500; i < 2000; i+=250) {
			Floor.x = i;
			Floor.draw(g);
			}
			////////////////////////////////////
			if(testing) {
			g.setColor(Color.yellow);
			for(int i = 0; i < wall.length;i++)
			wall[i].draw(g);
			center.draw(g);
			g.setColor(Color.green);
			Hitbox1.draw(g);
			Hitbox2.draw(g);
			
			g.setColor(Color.red);
			Hurtbox1.draw(g);
			Hurtbox2.draw(g);
			
			g.setColor(Color.blue);
			block1.draw(g);
			block2.draw(g);
			}
/////////////////////////////////////////////////////////////////////
			
			g.setColor(Color.green);
			p1.draw(g);
			p2.draw(g);
			Hitbox1.showHealth(g,p1);
			Hitbox2.showHealth(g,p2);
			if(Hitbox1.isDead()&&Hitbox2.isDead()) 
			{	
			this.drawWord(wordTie, g,750);
			}
		else {
			if(Hitbox2.isDead()) {
				this.drawWord(wordPlayer, g,300);
				Letterposition += 100;
				g.drawImage(letters[26], Letterposition , 300 , 100,100,null);
				Letterposition += 200;
				this.drawWord(wordWins, g,Letterposition);
		}
		 if(Hitbox1.isDead()) {
			 this.drawWord(wordPlayer, g,300);
			 Letterposition += 100;
			 g.drawImage(letters[27], Letterposition , 300 , 100,100,null);
			 Letterposition += 200;
			 this.drawWord(wordWins, g,Letterposition);
		}
		}
		
	}
	//////////////////////////////////////////////////////////////////////////////
	
	///////////////////////////////////////////////////////////////////
	public void drawWord(int[] word,Graphics g, int x) 
	{
		Letterposition = x;
		for(int i = 0; i < word.length; i++) {
		g.drawImage(letters[word[i]-1], Letterposition , 300 , 100,100,null);
		Letterposition+=100;
		}
			
	}
////////////////////////////////////////////////////////////////////////////////
}
