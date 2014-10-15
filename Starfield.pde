NormalParticle [] philip = new NormalParticle[50];
void setup()
{
	size(400,400);
	background(0);
	for (int i = 0; i < philip.length; ++i) {
		philip[i] = new NormalParticle();
	}
}
void draw()
{
	background(0);
	for (int i = 0; i < philip.length; ++i) {
		philip[i].show();
	 	philip[i].move();
	 	philip[i].reWind();
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
 	 	speed = 5;
 	 	angle = (Math.random()*2*PI);

	}
	void move()
	{
		posX = posX + speed * Math.cos(angle);
		posY = posY + speed * Math.sin(angle);
	}

	void show()
	{
		fill(colour[0],colour[1],colour[2]);
		ellipse((int)(posX),(int)(posY),10,10);
	}

	void reWind()
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
	//your code here
}


