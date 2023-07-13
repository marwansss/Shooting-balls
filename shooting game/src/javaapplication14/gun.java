package javaapplication14;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



/**
 *
 * @author ASC
 */
public class gun implements KeyListener {

   int x,y;

    @Override
    public void keyPressed(KeyEvent e) {
     int key = e.getKeyCode();
     if(key == KeyEvent.VK_UP)
         y=y-10;
     //label.setLocation(x, y);
     
      if(key == KeyEvent.VK_DOWN)
         y=y+10;
    // label.setLocation(x, y);
     
      if(key == KeyEvent.VK_LEFT)
          x=x-10;
     //label.setLocation(x, y);
     
     if(key == KeyEvent.VK_RIGHT)
          x=x+10;
    // label.setLocation(x, y);
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      void draw(Graphics g)
    {
         g.setColor(Color.RED);
        g.fillRect(300, 300, 50, 50);
    }
}

