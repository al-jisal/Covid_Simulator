    /* Name: Desmond Frimpong
     * Date: February 24, 2023
     * File: NormalAgent.java
     * 
     * this class implement a form of Agent called Normal Agent who
     * represent a normal person without virus
     */
    
     import java.awt.*;
     import java.util.Random;

public class NormalAgent extends Agent{
    // fields for the class
    int radius;
    boolean quarantined;
    boolean treated;

    public NormalAgent( double x0, double y0, int radius){
        super(x0, y0);
        this.radius = radius;
        quarantined = false;
        treated = true;
        this.hasVirus = false;
    }
    
    public void setRadius(int radius){
        this.radius = radius;
    }

    public int getRadius(){
        return radius;
    }

    public void draw(Graphics g){
        if(!hasVirus){
            g.setColor(new Color(0, 204, 0));
        }
        else{
            g.setColor(new Color(255, 255, 0));
        }

        g.fillOval((int) getX(), (int) getY(), 5, 5);
    }

    public void updateState(Landscape scape){
        Random random = new Random();

        LinkedList<Agent> neighbors = scape.getNeighbors(x, y, radius);
        
        int i = 0;
        int j = 0;
        if(neighbors.size() > 3){
            for(Agent agent : neighbors){
                if(agent instanceof FrontlineAgent){
                    i++;
                }
                if(agent instanceof DiseasedAgent){
                    j++;
                }
            }
        }

        if(quarantined){
            if(i >= 3){  
                treated = true;
                hasVirus = false;
            }
        }else{
            if(i >= 3){
                   quarantined = true;
            }
        }  

        if(j >= 3){
            hasVirus = true;
            quarantined = false;
            treated = false;
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

