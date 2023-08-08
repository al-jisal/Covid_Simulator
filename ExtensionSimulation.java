import java.util.Random;

/* Name: Desmond Frimpong
     * Date: February 24, 2023
     * File: ExtensionSimulation.java
     * 
     * CS 231
     * Section B
     * Project 3
     * 
     * this class implement the idea of my extension: the era of covid
     */

public class ExtensionSimulation {

    public static void main(String[] args) throws InterruptedException{
         /*
         * Shows screen and agents
         */
        Landscape scape = new Landscape(800,800);
        LandscapeDisplay display = new LandscapeDisplay(scape);
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            scape.addAgent(new NormalAgent(random.nextDouble() * scape.getWidth(),
                    random.nextDouble() * scape.getHeight(),
                    20));
            scape.addAgent(new DiseasedAgent(random.nextDouble() * scape.getWidth(),
                    random.nextDouble() * scape.getHeight(),
                    20));
            scape.addAgent(new FrontlineAgent(random.nextDouble() * scape.getWidth(),
                    random.nextDouble() * scape.getHeight(),
                    30));
        }


        while (true) {
            Thread.sleep(50);
            scape.updateAgents();
            display.repaint();
        }
    }
    
}
