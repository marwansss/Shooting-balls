/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication14;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
/**
 *
 * @author marwan
 */
public class ship implements Runnable , KeyListener  {
    
    static int score =0; 
    String s ="0";
    int r;
    int ra;
    String ranc;
    Random ran= new Random();
    int x,y,dx;
    int bx,by;
    boolean shot=false,readytofire;
    Rectangle bullet;
   
    Ball  ball [] ; 
    public ship(Ball ball[]){
        this.ball= ball;
        x=280;
        y=580;
    }
     void randomball()
     {
         ra=ran.nextInt(6);
         if(ra==0)
         {
           ranc="BLACK";
           r=0;
         }
         else if(ra==1)
         {
              ranc="magenta";
                 r=1;
         }
          else if(ra==2)
         {
              ranc="WHITE";
                 r=2;
         }
          else if(ra==3)
         {
             randomball();
              //ranc="BLACK";
                 //r=0;
         }
           else if(ra==4)
         {
              ranc="YELLOW";
                 r=4;
         }
          else if(ra==5)
         {
             ranc="PINK"; 
               r=5;
         }
          else if(ra==6)
         {
              ranc="GREEN";
                 r=6;
         }
          
     }
    public void draw(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(x, y, 40, 10);
        g.fillRect(x+18, y-7, 4, 4);
        
        if(shot){
            g.setColor(Color.WHITE);
            g.fillRect(bullet.x, bullet.y, bullet.width, bullet.height);
        }
    }
    public void move(){
        x+=dx;
        if(x<=0){
            x=0;
        }
        if(x>=850){
           x=850;
        }
    }
    void hit ()
     {
         int i;
         
         for( i =0; i<ball.length;i++)
          if (bullet.intersects( ball[i].x,  ball[i].y,  ball[i].diameter, ball[i].diameter))
          {
              if(i==3)
              {
                  score=0;
                  s=Integer.toString(score);
                   ball[i].y=ran.nextInt(500);
                   ball[i].x=ran.nextInt(800);
              }
              else if(r==0&&i==0)
              {
                  ball[i].y=ran.nextInt(500);
                  ball[i].x=ran.nextInt(800);
                  score ++;
                  score ++;
                  s=Integer.toString(score);
                  randomball();
              }
              else if(r==1 && i==1)
              {
                  ball[i].y=ran.nextInt(500);
                  ball[i].x=ran.nextInt(500);
                  score ++;
                  score ++;
                  s=Integer.toString(score);
                  randomball();
              }
              else if(r==2&&i==2)
              {
                  ball[i].y=ran.nextInt(500);
                  ball[i].x=ran.nextInt(500);
                  score ++;
                  score ++;
                  s=Integer.toString(score);
                  randomball();
              }
              else if(r==4&&i==4)
              {
                  ball[i].y=ran.nextInt(500);
                  ball[i].x=ran.nextInt(500);
                  score ++;
                  score ++;
                  s=Integer.toString(score);
                  randomball();
              }
              else if(r==5&&i==5)
              {
                  ball[i].y=ran.nextInt(500);
                  ball[i].x=ran.nextInt(500);
                  score ++;
                  score ++;
                  s=Integer.toString(score);
                  randomball();
              }
              else if(r==6&&i==6)
              {
                  ball[i].y=ran.nextInt(500);
                  ball[i].x=ran.nextInt(500);
                  score ++;
                  score ++;
                  s=Integer.toString(score);
                  randomball();
              }
              else
              {
          ball[i].y=ran.nextInt(500);
          ball[i].x=ran.nextInt(500);
          score ++;
          s=Integer.toString(score);
              }
          }
         
     }
    //public void setdx(int xdir){
      //  dx=xdir;
 //   }
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
 
        if (key == KeyEvent.VK_LEFT)
        dx=0;            
//setdx(0);
 
        if (key == KeyEvent.VK_RIGHT)
        dx=0;            
//setdx(0);
        if (key == KeyEvent.VK_SPACE){
           
                readytofire=false;
                if(bullet.y<= 0 ){
                     bullet=new Rectangle(0,0,0,0);
                     shot=false;
                     readytofire=true;
                }
            
        }
    }
    public void keyPressed(KeyEvent e) {
        
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_LEFT)
            dx--;
            //setdx(-1);
        if (key == KeyEvent.VK_SPACE)
        {
            if(bullet==null){
                readytofire=true;
            }
        if(readytofire){
            by=y-7; 
            bx=x+18;
            bullet=new Rectangle(bx,by,3,5);
            shot=true;
        }
        }
        if (key == KeyEvent.VK_RIGHT)
             dx++;
            // setdx(1);
        
         
   
}
    public void shoot(){
        if(shot){
            bullet.y--;
             hit();
            
        }
    }
    public void run(){
       
        try{
            while(true){
                 
                shoot(); 
                move();
             
              Thread.sleep(1);
            }
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

   @Override
     public void keyTyped(KeyEvent e) {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    
    }
}
            
    
    
    
