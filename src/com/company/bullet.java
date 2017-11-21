package com.company;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;


public class bullet {
    int x=0,y=550;
    bullet(int x){
        this.x=x;
    }
    public void ren(Graphics g){
        g.setColor(Color.red);

        g.fillOval(x+30,y,10,10);
        y=y-25;
    }

}
