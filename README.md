# Humans-VS-Zombies-Game
implementation of Humans vs zombie game in java 

## Problem Statemnent
Let us play a game for Humans vs Zombies. Members of each group are armed with guns. Let H
be the number of humans with a kill rate α and Z be the number of zombies with a kill rate β. We
may assume the following differential equations to represent the rate of changes in H and Z:
           dH/dt = - β z 
           dZ/dt = - α H
The game ends when one of them (either humans or zombies) reaches zero and the other side is the winner. 
Write the values of H and Z at different values of t in a csv file, each line contains an entry for a t.

##  Approach :  use leapforg simulation method.
# Humans vs. Zombies Simulation

This project simulates the spread of zombies in a grid populated with humans using the leapfrog method. The simulation proceeds by interleaving updates of human and zombie positions.

## Problem Description

The simulation involves a grid where:
- 'H' represents a human.
- 'Z' represents a zombie.
- '.' represents an empty space.

Zombies can move in four directions: up, down, left, or right. If a zombie moves into a cell occupied by a human, the human turns into a zombie. Humans try to move to adjacent empty cells to avoid zombies.

## Implementation Details


### Movement Rules

1. **Zombies**:
   - Zombies move first.
   - A zombie tries to infect any adjacent human.
   - Newly infected humans become zombies.

2. **Humans**:
   - Humans move after zombies.
   - A human tries to move to an adjacent empty cell.
   - If no empty cell is available, the human stays in place.

### Simulation Loop

The simulation continues until there are no humans left in the grid.

### Leapfrog Method

The leapfrog method is adapted here to interleave the movements of zombies and humans to simulate their interaction dynamically.

### output : 
At the end of simulation it will print the winner name. 
The final output is stored is stored in the csv file.
