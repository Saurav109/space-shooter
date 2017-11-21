package com.company;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import java.util.Random;

public class enemy {
    int x=0,y=0;
    Random r;
    enemy(){
        r=new Random();
        x=r.nextInt(600)+1;
    }
    public void ren(Graphics g){
        g.setColor(Color.cyan);

        g.fillOval(x,y,50,50);
        y++;
    }
}
