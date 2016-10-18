import java.awt.*;
import java.applet.*;
import javax.swing.JPanel;
import java.awt.Graphics;
public class circle extends JPanel{
	Graphics i;
	int x=500;
	int y=250;
	int isColliding=0;
	int isCollidingx = 0, isCollidingy = 0;
	int xAccel=(int)Math.round(Math.random()*2+1)*(int)Math.round(Math.random()*-1+1);
	int yAccel=(int)Math.round(Math.random()*2+1)*(int)Math.round(Math.random()*-1+1);
	public int target = 0;
	public circle(Graphics g){
		g=i;
	}
	public void paint(Graphics g){
		g=i;
		initialize(g);
	}
	void respawn(int side){
		target = 0;
		x=500;
		y=250;
		isColliding=0;
		isCollidingx = 0;
		isCollidingy = 0;
		if(side==1){
			xAccel=(int)Math.round(Math.random()*7.5+5)*-1;
		}
		else{	
			xAccel=(int)Math.round(Math.random()*7.5+5);
		}
		if(Math.round(Math.random()+1)<0){
			yAccel=(int)Math.round(Math.random()*7.5+5)*-1;
		}
		else{
			yAccel=(int)Math.round(Math.random()*7.5+5);
		}
	}
	public void initialize(Graphics g){
		g.fillRect(x,y,10,10);
		i=g;
		x+=xAccel;
		if(target == 1){
			y+=yAccel+(mainCode.player1.xAccel/1.5);
		}
		else if(target == 2){
			y+=yAccel+(mainCode.player2.xAccel/1.5);
		}
		else{
			y+=yAccel;
		}
		
		//System.out.println(xAccel + " " + yAccel);
				if((y<mainCode.player1.x+75)&&(y+10>mainCode.player1.x)&&(x<25)){
					if(isColliding==0){
						target = 1;
						xAccel = (Math.abs(xAccel)+1)*1;
						isColliding=1;
						if(yAccel<0){
							yAccel=(int)Math.round(Math.random()*-2-1);
						}
						else{	
							yAccel=(int)Math.round(Math.random()*2+1);
						}
					}
				}
				else if((y<mainCode.player2.x+75)&&(y+10>mainCode.player2.x)&&(x>965)){
					if(isColliding==0){
						target = 2;
						xAccel = (Math.abs(xAccel)+1)*-1;
						isColliding=1;
						if(yAccel<0){
							yAccel=(int)Math.round(Math.random()*-2-1);
						}
						else{	
							yAccel=(int)Math.round(Math.random()*2+1);
						}
					}
				}
				else{
					isColliding=0;
				}
			if(x>990){
				mainCode.addPoints(1,1);
				respawn(1);
			}
			else if(x<1){
				mainCode.addPoints(2,1);
				respawn(2);
			}
			else{
				isCollidingx=0;
				isColliding=0;
			}
			if((y>490)&&(isCollidingy == 0)){
				yAccel=yAccel*-1;
				isCollidingy=1;
				isColliding=1;
			}
			else if((y<1)&&(isCollidingy == 0)){
				yAccel=yAccel*-1;
				isCollidingy=1;
			}else{
				isCollidingy=0;
				isColliding=0;
			}
			
	}
}