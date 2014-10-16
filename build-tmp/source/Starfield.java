import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Starfield extends PApplet {

NormalParticle [] philip = new NormalParticle[50];
public void setup()
{
	size(400,400);
	background(0);
	for (int i = 0; i < philip.length; ++i) 
	{
	 	philip[i] = new NormalParticle();
	}
}

public void draw()
{
	background(0);
	for (int i = 0; i < philip.length; ++i) 
	{
		
	 	
	 	philip[i].reWind();
	 	philip[i].move();
	 	philip[i].show();
	}
}

class NormalParticle
{
	int [] colour = new int[3];
	double posX, posY, speed, angle;
	NormalParticle()
	{
		for (int a = 0; a < colour.length; ++a) 
		{
			colour[a] = (int)(Math.random()*256);
		}
 	 	
 	 	posX = 200;
 	 	posY = 200;
 	 	speed = (Math.random()*3 + 3   );
 	 	angle = (Math.random()*2*PI);

	}
	public void move()
	{
		posX = posX + speed * Math.cos(angle);
		posY = posY + speed * Math.sin(angle);
	}

	public void show()
	{
		fill(colour[0],colour[1],colour[2]);
		ellipse((int)(posX),(int)(posY),10,10);
	}

	public void reWind()
	{
 		if(Math.sqrt(Math.pow(posX-200,2) + Math.pow(posY-200,2)) >= 200)
 		{
 			posX = 200;
 			posY = 200;
 			angle = (Math.random()*2*PI);
 			for (int a = 0; a < colour.length; ++a) 
		 	{
			 	colour[a] = (int)(Math.random()*256);
		 	}
 	 	
 		}
	}

}

interface Particle
{
	//your code here
}

class OddballParticle
{
	int [] colour = new int[3];
	double posX, posY, speed, angle;
	OddballParticle()
	{
 		for (int a = 0; a < colour.length; ++a) 
		{
			colour[a] = (int)(Math.random()*256);
		}
		posX = 200;
		posY = 100;
		speed = 4;
		angle = Math.random()*2*PI;

	}

	public void move() 
	{
		posX = posX + speed * Math.cos(angle);
		posY = posY + speed * Math.sin(angle);
	}

	public void show() 
	{
		fill(255);
		ellipse((int)(posX),(int)(posY),20,20);
	}
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Starfield" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
