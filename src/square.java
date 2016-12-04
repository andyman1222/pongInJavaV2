import java.awt.*;
import java.applet.*;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
public class square extends JPanel{
	Graphics g;
	int x=250;
	int y;
	protected int xAccel = 0;
	public int points = 0;
	public String pointsString = "0";
	public int acceleration;
	public boolean isActive = false;
	public int oneOrTwo;

	public void paintComponent(Graphics g){
		g.setColor(Color.white);
		initialize(g);
		repaint();
	}
	
	public square(int y, int oneOrTwo){
		this.y=y;
		this.oneOrTwo = oneOrTwo;
	}
	public void initialize(Graphics g){
		if(isActive){
			move(acceleration);
		}
		else{
			moveCPU();
		}
		try{
			Thread.sleep(10);
		}
		catch(Exception e){}
		g.setColor(Color.white);
		g.fillRect(y,x,25,75);
		pointsString = ""+points;
	}

	int increment = (int)Math.round(Math.random()*25)+10;
	int count = 0;
	int e = 1;
	public void moveCPU(){
		
		if(mainCode.circle1.target == oneOrTwo){
			
			if(count == increment){
				if(e==1){
					e=-1;
				}
				else{
					e=1;
				}
				increment = (int)Math.round(Math.random()*25)+10;
				count = 0;
			}
			else{
				count++;
			}
			System.out.println(increment);
			System.out.println(count);
			System.out.println(e);
		}
		else{
			if(((x>Math.ceil((mainCode.circle1.y-30)/10)*10))&&(x>-1)){
				e=-1;
			}
			else if((x<Math.floor((mainCode.circle1.y-30)/10)*10)&&(x<424)){
				e=1;
			}
			else{
				e=0;
			}
		}
		if((x+xAccel+e>0)&&(x+xAccel+e<424)){
			if(e!=0){
				xAccel+=e;
				x+=xAccel;
			}
			else{
				if(xAccel<-10){
					xAccel+=1;
					x+=xAccel;
				}
				else if(xAccel>10){
					xAccel-=1;
					x+=xAccel;
				}
				else{
					xAccel = 0;
				}
			}
		}
		else{
			xAccel = 0;
		}
	}

	public void move(int e){

		if((x+xAccel+e>0)&&(x+xAccel+e<424)){
			if(e!=0){
				xAccel+=e;
				x+=xAccel;
			}
			else{
				if(xAccel<-10){
					xAccel+=5;
					x+=xAccel;
				}
				else if(xAccel>10){
					xAccel-=5;
					x+=xAccel;
				}
				else{
					xAccel = 0;
				}
			}
		}
		else{
			acceleration = 0;
			xAccel = 0;

		}
	}
}