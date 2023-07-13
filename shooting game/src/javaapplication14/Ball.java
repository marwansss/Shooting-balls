
package javaapplication14;
import java.awt.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Ball extends Thread {
    
    Random ran= new Random();
    int fw ,fh; 
    int x ,y , diameter=50 ;
    int speed = 0 ;
    //float red , green , blue;
    Color c ;
    boolean up = false , right = false ;
    
    Ball (int framewidth , int frameheight ,Color c ,int speed ,int diameter)
    {
        this.c=c;
        this.diameter = diameter;
        fw =framewidth;
        fh =frameheight;
        x= ran.nextInt(fw-diameter);
        y=ran.nextInt(fh-diameter);
        this.speed=speed;
        //speed=ran.nextInt(10);
        up = ran.nextBoolean();
        right = ran.nextBoolean();
       // red =ran.nextFloat();
        //green =ran.nextFloat(); 
        //blue =ran.nextFloat(); 
    }
    public void run()
    {
        while(true)
        {
        if(right) x+=speed;
        else x-=speed;
        
        if(up) y-=speed;
        else y +=speed;
        
        if(x<0) right=true;
        if(x>(fw-diameter)) right = false;  
        
        if(y<25) up=false;
        if(y>(fh-diameter)) up = true; 
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ball.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }
    void draw(Graphics g)
    {
        //for random color
//        g.setColor( new Color(red, green, blue));
         g.setColor(c);

        g.fillOval(x, y,diameter, diameter);
    }
    
}
