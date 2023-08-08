    /* Name: Desmond Frimpong
     * Date: February 24, 2023
     * File: Landscape.java
     * 
     * CS 231
     * Section B
     * Project 3
     * 
     * this class implement a landscape for our simulation
     */

import java.awt.*;
import java.lang.Math;

public class Landscape {
    
    
    // fields for the Landscape class
    int width;
    int height;
    LinkedList<Agent> agentList;

    public Landscape(int w, int h){
        this.width = w;
        this.height = h;
        this.agentList = new LinkedList<Agent>();
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public void addAgent(Agent a){
        agentList.add(a);
    }

    public String toString(){
        String str = "Width : " + width +"\nHeigth : " + height + "\nMembers on Landscape : " + agentList.size();
        return str;
    }
    
    public LinkedList<Agent> getNeighbors(double x0, double y0, double radius){
        LinkedList<Agent> neighbors = new LinkedList<Agent>();

        for(Agent agent : agentList){
            if( agent.getX() == x0 && agent.getY() == y0){
                continue;
            }
            if( Math.pow(agent.getX()-x0, 2) + Math.pow(agent.getY()-y0, 2) <= Math.pow(radius,2)){
                neighbors.add(agent);
            }
        }
        return neighbors;
    }

    public void updateAgents(){
        for( Agent agent : agentList){
            agent.updateState(this);
        }
        
    }

    public void draw(Graphics g){
        for (Agent agent : agentList) {
            agent.draw(g);
        }
    }

}
