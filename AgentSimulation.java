 /* Name: Desmond Frimpong
     * Date: February 24, 2023
     * File: AgentSimulation.java
     * 
     * CS 231
     * Section B
     * Project 3
     * 
     * this class implement a simulation for the agents
     */

import java.util.Random;

public class AgentSimulation {
    public static void main(String[] args) throws InterruptedException {
        /*
         * Shows screen and agents
         */
        if(args.length < 2){
            System.out.println("Provide command line arguments for the display size \nFor instance: AgentSimulation.java 50 50");
        }
        Landscape scape = new Landscape(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        LandscapeDisplay display = new LandscapeDisplay(scape);
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            scape.addAgent(new SocialAgent(random.nextDouble() * scape.getWidth(),
                    random.nextDouble() * scape.getHeight(),
                    30));
            scape.addAgent(new AntiSocialAgent(random.nextDouble() * scape.getWidth(),
                    random.nextDouble() * scape.getHeight(),
                    60));
        }

        while (true) {
            Thread.sleep(100);
            scape.updateAgents();
            display.repaint();
        }
    }    
}
