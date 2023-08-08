    /* Name: Desmond Frimpong
     * Date: February 24, 2023
     * File: FrontlineAgent.java
     * 
     * this class implement a form of Agent called Frontline Agent who
     * finds, quaratines, and treats other agents with Corona
     */
    
     import java.awt.*;
     import java.util.Random;

public class FrontlineAgent extends Agent {

    // fields for this class
    int radius;

    public FrontlineAgent(double x0, double y0, int radius){
        super(x0, y0);
        this.radius = radius;
        hasVirus = false; 
    }
    
    public void setRadius(int radius){
        this.radius = radius;
    }

    public int getRadius(){
        return radius;
    }

    public void draw(Graphics g){
        g.setColor(new Color(255, 0, 0));

        g.fillOval((int) getX(), (int) getY(), 5, 5);
    }

    public void updateState(Landscape scape){
        Random random = new Random();
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
