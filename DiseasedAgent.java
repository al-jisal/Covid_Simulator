    /* Name: Desmond Frimpong
     * Date: February 24, 2023
     * File: DiseasedAgent.java
     * 
     * CS 231
     * Section B
     * Project 3
     * 
     * this class, AS MY EXTENTION, implement a form of Agent called Diseased Agent who
     * has contracted corona virus, so needs to be quarantined from other agents
     */
    
     import java.awt.*;
     import java.util.Random;

public class DiseasedAgent extends Agent {
    // fields for the class
    int radius;
    boolean quarantined;
    boolean treated;

    public DiseasedAgent(double x0, double y0, int radius){
        super(x0, y0);
        this.radius = radius;
        quarantined = false;
        treated = false;
        this.hasVirus = true;
    }

    public void setRadius(int radius){
        this.radius = radius;
    }

    public int getRadius(){
        return radius;
    }

    public void draw(Graphics g){
        if(treated){
            g.setColor(new Color(0, 0, 0));
        }
        else g.setColor(new Color(0, 0, 255));

        g.fillOval((int) getX(), (int) getY(), 5, 5);
    }

    public void updateState(Landscape scape){
        Random random = new Random();

        LinkedList<Agent> neighbors = scape.getNeighbors(x, y, radius);

        int i = 0;
        if(neighbors.size() > 3){
            for(Agent agent : neighbors){
                if(agent instanceof FrontlineAgent){
                    i++;
                }
            }
        }

        if(quarantined){
            if(i >= 3){    
                treated = true;
                hasVirus = false;
            }
        }
        else{     
            if(i >= 3){
                quarantined = true;
            }
        }
        
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

        
           
    }  
        
}

