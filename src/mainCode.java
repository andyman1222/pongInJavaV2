import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

import javax.swing.*;
public class mainCode extends JPanel{
	public static square player1=new square(0,1);
	public static square player2=new square(975,2);
	public static circle circle1 = new circle();
	static JFrame frame=new JFrame("Pong");
	static Graphics i;
	public void paint(Graphics g){
		try{Thread.sleep(0,1);}
		catch(Exception e){}
		g.setColor(Color.black);
		g.fillRect(0,0,1000,500);
		circle.initialize(g);
		player1.initialize(g);
		player2.initialize(g);
		
		g.drawString(player1.pointsString + "-" + player2.pointsString,500,500);
		repaint();
	}
	public static void main(String[] args) {
		BufferStrategy fast;
		frame.add(new mainCode());
		//frame.add(circle1);
		//frame.add(player1);
		//frame.add(player2);
		//frame.add(mainCode.player());
		frame.setSize(1050, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		KeyPress keys=new KeyPress();
		frame.addKeyListener(keys);
		circle1.respawn((int)Math.round((Math.random()*2)+1));
		while(true){
			
		}
	}
	public static void addPoints(int player, int point){
		if(player==1){
			player1.points+=point;
		}
		else{
			player2.points+=point;
		}
	}
}
