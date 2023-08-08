    /* Name: Desmond Frimpong
     * Date: February 24, 2023
     * File: Agent.java
     * 
     * this class implement an abstract entity called Agent in a spatial coordinates (x,y)
     */
    

import java.awt.*;

public abstract class Agent {
   
    // fields for the Agent class
    double y;
    double x;
    boolean hasVirus; 

    public Agent(double x0, double y0){
        x = x0;
        y = y0;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void setX(double newX){
        x = newX;
    }

    public void setY(double newY){
        y = newY;
    }

    public String toString(){
        return "(" + x + ", " + y + ")";
    }

    public abstract void updateState( Landscape scape);

    public abstract void draw(Graphics g);


}
