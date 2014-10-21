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

Particle [] philip = new Particle[100];
public void setup()
{
	size(800,800);
	background(0);
	philip[0] = new OddballParticle();
	for (int i = 1; i < philip.length; ++i) 
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

class NormalParticle implements Particle
{
	int [] colour = new int[3];
	double posX, posY, speed, angle;
	NormalParticle()
	{
		for (int a = 0; a < colour.length; ++a) 
		{
			colour[a] = (int)(Math.random()*256);
		}
 	 	
 	 	posX = 400;
 	 	posY = 400;
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
		ellipse((int)(posX),(int)(posY),5,5);
	}

	public void reWind()
	{
 		if(Math.sqrt(Math.pow(posX-400,2) + Math.pow(posY-400,2)) >= 400)
 		{
 			posX = 400;
 			posY = 400;
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
	public void move();
	public void show();
	public void reWind();
}

class OddballParticle implements Particle
{
	int [] colour = new int[3];
	int siz;
	double posX, posY, speed, angle;
	OddballParticle()
	{
		for (int a = 0; a < colour.length; ++a) 
		{
			colour[a] = (int)(Math.random()*256);
		}
 	 	
 	 	posX = 400;
 	 	posY = 400;
 	 	speed = (Math.random()*3 + 3);
 	 	angle = (Math.random()*2*PI);
 	 	siz = 10;
	}

	public void move() 
	{
		posX = posX + speed * Math.cos(angle);
		posY = posY + speed * Math.sin(angle);
		for (int a = 0; a < colour.length; ++a) 
		{
			colour[a] = (int)(Math.random()*256);
		}

	}

	public void show() 
	{

		fill(colour[0],colour[1],colour[2]);
		ellipse((int)(posX),(int)(posY),siz,siz);
		siz ++;
	}

	public void reWind()
	{
 		if(Math.sqrt(Math.pow(posX-400,2) + Math.pow(posY-400,2)) >= 400)
 		{
 			posX = 400;
 			posY = 400;
 			siz = 10;
 			angle = (Math.random()*2*PI);
 			for (int a = 0; a < colour.length; ++a) 
		 	{
			 	colour[a] = (int)(Math.random()*256);
		 	}
 	 	
 		}
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
