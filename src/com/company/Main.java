package com.company;

import org.newdawn.slick.*;
import java.util.ArrayList;
import java.util.Random;


public class Main extends BasicGame{

    int x=270;
    int rr=0;
    Random r;
    int score =0;
    Input in;



    ArrayList<bullet>s =new ArrayList<bullet>();
    ArrayList<enemy> e=new ArrayList<enemy>();
    public Main() {
        super("space");
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer a=new AppGameContainer(new Main());
        a.setShowFPS(false);
        a.setDisplayMode(600,600,false);
        a.start();
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        in=gameContainer.getInput();
        r=new Random();
        e.add(new enemy());




    }

    @Override
    public void update(GameContainer gc, int y) throws SlickException {

           for (int z=0;z<s.size()-1;z++){
               if(s.get(z).y<100){
                   s.remove(z);
               }
           }
           rr=r.nextInt(50);
        if(rr==3){
            e.add(new enemy());
        }
        for(int i=0;i<e.size()-1;i++){
            if(e.get(i).y >600){
                e.remove(i);

            }
        }
    for (bullet ex: s){
        System.out.print(ex.x );
    }
        System.out.println("");


    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {



        if(in.isKeyDown(Input.KEY_RIGHT) && x<530){
            x=x+10;
        }
        else if(in.isKeyDown(Input.KEY_LEFT) && x>0){
            x=x-10;
        }

        if(in.isKeyPressed(Input.KEY_A)){
           s.add(new bullet(x));
        }
        for(bullet c: s){
            c.ren(gc.getGraphics());
        }
        for(int i=0;i<e.size()-1;i++){
            for(bullet c: s){
                if(e.get(i).x>c.x && e.get(i).x>c.x ){
                    g.setColor(Color.red);
                    g.fillOval(e.get(i).x,e.get(i).y,100,100);
                    g.setColor(Color.white);
                    g.fillRect(0,0,600,600);
                    e.remove(i);

                    score++;
                }
            }

        }
        for(enemy ee: e){

            ee.ren(gc.getGraphics());
        }
        g.setColor(Color.white);
        g.fillRect(x,550,70,40);
        g.drawString("Score :"+score,450,40);

    }
}
