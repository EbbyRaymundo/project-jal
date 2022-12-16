# Jal

## Preface
Jal is a UNCC BINF 6380 Advanced Programming project that challenges students to make a sufficiently complex programming project by the end of the semester. 

## About Jal
Jal is a text-based story adventure that integrates a GUI for increased interactivity and provides a finite amount of options for a user in each zone. The events are designed in a [deterministic finite automaton](https://en.wikipedia.org/wiki/Deterministic_finite_automaton) (DFA) schema, and the game engine was developed in a [model-view-controller](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller) (MVC) pattern. The model is fully independent of the view (GUI.java) and the controller (Controller.java)\

### Terminology
| Term | Meaning |
| ---- | ------- |
|Situation|The moment in the game that has a prompt to describe the scene and setting. Can have an associated key item to give the player that would unlock new paths|
|Choice|The decision a player can make based on the given Situation|
|Item|Given to the player upon reaching a specific Situation that can be used to unlock a Choice.|
|Slimeball|The .slime file that specifies every Item, Situation, Choice, and how they relate to each other. See [##Developing for Jal](#developing-for-jal) for more.|



## Running Jal
To start the game, run the Start file using "java Start YourFileHere.slime" on the command line within the src/ folder.

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

An example file that uses the functionality of Jal can be seen in master.slime
```
1~5~7
Phone:~Lots of fun games and scrolling to be had, sometimes i just want to see how much text can fit into a gigaaaaaaantic scrollbar
You wake up in your comfy bed. Thinking lots of thoughts about Guts berserk~me_when_java.jpg
You're still in bed...slimeball.No wonder youre not going to sleep tonight working on that project
You Live a Very long and healthy life! Bravo, somehow global warming was solved and the reins of capitalism were finally dropped, cheers to your very very full life comrade.
OH NO. You forgot to text your mom back! How do you even live with yourself you monster.~0
Somehow you wasted the rest of your life staring at that phone since you found that blue checkmark SO appealing. I bet you have a reddit account
0~1~You stay in bed like a slimeball
1~1~Just 5 more minutes!
0~2~Your eat your green veggies
0~2~You eat some cream of wheat
0~3~You pick up your phone
3~2~You give up your tech addiction
2~4~You check your phone again~0
```

This is the corresponding story map for the master.slime example:

![example story](src/photos/jal.png "Story board of the master.slime file.")

The most important constraint of Jal is that **you are limited to 4 choices per Situation**.\
The second most important thing to remember is that **NUMBERING FOR ITEMS, SITUATIONS, AND CHOICES START AT 0**!\
It is very important that when you are formatting your file, you **separate your components with a '~' within a line**. This is used as the separator for the regex finder to split up the line. That also means you shouldn't use any '~' within your text to not set everything on fire.\
A design decision that was decided upon was that you should be able to acquire duplicates of the same Item. This is because it fit the original artistic vision of being able to loop back to the same point in time and re-encounter something. If you would like to change this, you can add a playerItemList.contains(itemKey) check within the Inventory.addPlayerItem() method to see if the player already has the Item beforehand.\
You have the option to grant the player an item upon reaching a particular Situation, or require the player to possess a particular item to be able to select a choice. Additionally, you do not need to use items in your game at all. If you so choose, you may create a game flow that contains no item acquisition in your situations and no conditional choices. To do this, simply remove any item lines in the file, and remove the number of items at the top of the file. Do not set number of items to 0.

As a reminder:
- Granted item keys and images are optional for a Situation.
- A required item key is optional for a Choice.

## Future features that can be added

- In the future, we would like to add in an undo feature to place Situations in a stack, or some kind of save-state feature. Making it so certain key items could lock you out of an option would be a potential feature that one might want to add, but is not advised since it detracts from the player enjoyment of being able to interact with the entirety of your story.\
- Add in multi-Item requirements to a Choice.
- Make the player inventory a pop out that shows each item with its own little icon, name, and shows a description when you hover over it.
- Add a .slime developer tool to automatically generate your .slime file based on how you mapped your story.
- Add dynamic button allocation to the GUI so that a Situation can have more than 4 Choices.
- Use a GUI library that isn't Swing.
- Add in a log so the player can see the choices they've been taking.

## Credits
Developed by Eberardo Raymundo and William Willis.