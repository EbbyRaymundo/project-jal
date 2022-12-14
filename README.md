# Jal

## TODO
- In the static factory methods of Inventory, Events, and Decisions, we should use the numItems, numSituations, and numChoices to set the intial capacities of the ArrayLists so that we never need to resize. Adds efficiency but will make no changes to the model's logic.
- Add in logic to addItem() within the Situation class so that you can't give the player duplicates of items.
  - We reconsidered this since it would fit within the artistic vision that the player could jump back to the beginning of the game 
    and load up their inventory with duplicates.
- Enforce the Situation's choice instance variable to be of max size 4.
## Preface
Jal is a UNCC BINF 6380 Advanced Programming project that challenges students to make a sufficiently complex programming project by the end of the semester. 

## About Jal
Jal is a text-based story adventure that integrates a GUI for increased interactivity and provides a finite amount of options for a user in each zone. The events are designed in a [deterministic finite automaton](https://en.wikipedia.org/wiki/Deterministic_finite_automaton) (DFA) schema, and the game engine was developed in a [model-view-controller](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller) (MVC) pattern.

## Running Jal
To start the game, run the Start file.

## Developing for Jal
Jal's story flow is not hard-coded. You can create your own game with your own rules following the .slime format:

```
number of items~number of situations~number of choices
item 0 name~item 0 description
item 1 name~item 1 description
item 2 name~item 2 description
...
item n name~item n description
situation 0 text
situation 1 text~image file name
situation 2 text~granted item key
situation 3 text~granted item key~image file name
...
situation n text
preceding situation key~following situation key~choice 0 text
preceding situation key~following situation key~choice 1 text
preceding situation key~following situation key~choice 2 text~required item key
...
preceding situation key~following situation key~choice n text
```
The most important constraint of JAL is that **you are limited to 4 choices per situation**.
The second most important thing to remember is that **NUMBERING FOR ITEMS, SITUATIONS, AND CHOICES START AT 0**!
It is very important that when you are formatting your file, you **separate your components with a '~' within a line**. This is used as the separator for the regex finder to split up the line.
You have the option to grant the player an item upon reaching a particular Situation, or require the player to possess a particular item to be able to select a choice. Additionally, you do not need to use items in your game at all. If you so choose, you may create a game flow that contains no item acquisition in your situations and no conditional choices. To do this, simply remove any item lines in the file, and remove the number of items at the top of the file. Do not set number of items to 0.

## Credits
Developed by Eberardo Raymundo and William Willis.