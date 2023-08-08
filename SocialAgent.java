    /* Name: Desmond Frimpong
     * Date: February 24, 2023
     * File: SocialAgent.java
     * 
     * CS 231
     * Section B
     * Project 3
     * 
     * this class implement a form of Agent called Social Agent
     */
    

import java.awt.*;
import java.util.Random;

public class SocialAgent extends Agent {
   
    // fields for the SocialAgent class
    boolean moved;
    int radius;

    public SocialAgent(double x0, double y0, int radius){
        super(x0, y0);
        this.radius = radius;
        this.moved = false;
    }

    public void setRadius(int radius){
        this.radius = radius;
    }

    public int getRadius(){
        return radius;
    }

    public void draw(Graphics g){
        if(!moved) {
            g.setColor(new Color(0, 0, 255));
        }
        else {
            g.setColor(new Color(125, 125, 255));
        }
        g.fillOval((int) getX(), (int) getY(), 5, 5);
    }

    public void updateState( Landscape scape){
        Random random = new Random();

        LinkedList<Agent> neighbors = scape.getNeighbors(x, y, radius);

        if(neighbors.size() < 4){
            double newX = this.getX() - 10 + random.nextDouble(20);
            double newY = this.getY() - 10 + random.nextDouble(20);
             
            if(newX > scape.getWidth()){
                this.setX(scape.getWidth());
            }
            else if(newY > scape.getHeight()){
                this.setY(scape.getHeight());
            }
            else if(newX < 0){
                this.setX(0);
            }
            else if(newY < 0){
                this.setY(0);
            }
            else{
                this.setX(newX);
                this.setY(newY);
            }
            moved = true;
        }
        else{
            moved = false;
        }

    }
}