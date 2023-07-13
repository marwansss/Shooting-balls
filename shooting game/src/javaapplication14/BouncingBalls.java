/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication14;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author PC
 */
public class BouncingBalls extends JFrame implements Runnable{

    int framewidth = 900, frameheigt= 600;
   Random ran= new Random();
   //int ra;
   //int r ;
  // String ranc;
    Thread thread; 
    Ball ball[]=new Ball[7];
  
   ship gun =new ship(ball); 
    Thread t =new Thread(gun);
     BouncingBalls()
     {
        setBounds(100,100,framewidth,frameheigt);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);
        addKeyListener(gun);
        
       
        ball[0] = new Ball(framewidth,frameheigt,Color.BLACK , 1 , 20);
        ball[1] = new Ball(framewidth,frameheigt,Color.magenta , 2 , 25);
        ball[2] = new Ball(framewidth,frameheigt,Color.WHITE , 3 , 30);
        ball[3] = new Ball(framewidth,frameheigt,Color.RED , 4 , 35);
        ball[4] = new Ball(framewidth,frameheigt,Color.YELLOW , 5 , 40);
        ball[5] = new Ball(framewidth,frameheigt,Color.PINK, 6 , 45);
        ball[6] = new Ball(framewidth,frameheigt,Color.GREEN, 7 ,50);
        
        thread =new Thread(this);
        thread.start();
     }
     /*void hit ()
     {
         int i;
         while(true){
         for( i =0; i<6;i++)
         
          if (gun.bullet.intersects( ball[i].x,  ball[i].y,  ball[i].diameter, ball[i].diameter))
          {
         // ball[i].y=0;
          //ball[i].x=0;
              System.out.println("fff");
          }
         }
     }*/
    
    @Override
     public void paint(Graphics g)
    {
        g.setColor(Color.DARK_GRAY);
        g.fillRect( 0, 0 , framewidth, frameheigt);
      
        gun.draw(g);
               for(int i=0; i<ball.length;i++)
                ball[i].draw(g);
       
       g.setColor(Color.yellow);
       g.setFont(new Font("courier New",Font.PLAIN , 20));
       g.drawString("score"+"  "+gun.s, 50, 50);
       g.drawString(gun.ranc, 50, 70);
               
    }
      @Override
    public void run() {
        gun.randomball();
        for(int i=0; i<ball.length;i++)
             ball[i].start();
         t.start();
          
      while(true)
      {
              
        //hit();
          
            repaint();
         
          try {
              Thread.sleep(1);
          } catch (InterruptedException ex) {
              Logger.getLogger(BouncingBalls.class.getName()).log(Level.SEVERE, null, ex);
          }
              
      }
    }
    
     
    public static void main(String[] args) {
      new BouncingBalls() ;
      
    }

   
}
