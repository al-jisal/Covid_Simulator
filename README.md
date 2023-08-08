# Covid_Simulator

This project explores how individuals with diseases could spread it within a population. Specifically, the project simulates the era of Covid 19. 

I have three types of agents in the simulation: Diseased agents, agents with the covid virus; Normal agents, healthy agents prone to contracting the virus if they come into contact with the diseased agents; and Frontline agents, agents that treat other agents with the virus. 

The diseased agents have fields such as treated, quarantined, and hasVirus. If a diseased agent, which is not quarantined, gets surrounded by three or more frontline agents, that diseased agent gets quarantined, and if they were already quarantined, then they get treated. A quarantined agent does not get to move when it gets updated. Diseased agents are represented by blue but they turn into black when they get treated.

The normal agents are represented by green, and they turn yellow when they contract the virus. When a normal agent gets surrounded by three or more diseased agents, that agent contracts the virus, and when three or more frontline agents surround a quarantined normal agent, that agent gets treated, otherwise, that agent gets quarantined if it has the virus.

Frontline agents are red in color. In this simulation, I made an assumption that frontline agents are immune to the virus, so they do not contract the virus even if they come in contact with diseased agents. Their goal is to treat the population with the virus.
