# Warriors And Mages
Simulation of duels between heroes of different classes.

# Description
Initially project was started as an exercise and a place where I can train myself in OOP and design patterns. Application generates characters of different classes and properties and confronts them with each other in simulated duels.
Result of this duels is undeterministic, because we cannot foresee what will be the final result and which character will win the competetition.   

Characters have different attack, defense, experience and various other features that are specific only for their class. For example Warrior is able to enter berserker state, Mage casts spells, Necromancer summons creatures that helps him in a fight.
All this special abilities are used randomly.

All duels happens on arenas. After some number of confrontations each arena has its own winner, that can be involved in further duels up to the point when we have only one alive hero - the winner.

Application shows progress of each battle, each attack, defense, health point changes, experience gained after the battle and other events.  

At the end of the process game shows statistics of the winner and other characters.

I think that this project is worth paying attention to, because it contains ideas that can be used to create a real game. It can be also used for educational purposes even though it still can be improved.

In the future I would like to create frontend for this simulation and maybe even turn it into a real game.

# Requirements
- Java 11

# Launch
- clone repository
- run Main file in your IDE
