# Jal

## TODO
- Need to link model, viewer, and controller.
- Need to add file parser to model

## Preface
Jal is a UNCC BINF 6380 Advanced Programming project that challenges students to make a sufficiently complex programming project by the end of the semester. 

## About Jal
Jal is a text-based story adventure that integrates a GUI for increased interactivity and provides a finite amount of options for a user in each zone. The events are designed in a [deterministic finite automaton](https://en.wikipedia.org/wiki/Deterministic_finite_automaton) (DFA) schema, and the game engine was developed in a [model-view-controller](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller) (MVC) pattern.

## Running Jal
To start the game, run the Start file.

## Developing for Jal
Jal's story flow is not hard-coded. You can create your own game with your own rules following the .slime format:

```
number_of_items number_of_situations number_of_choices
item_0_name item_0_description
item_1_name item_1_description
item_2_name item_2_description
...
item_n_name item_n_description
situation_0_text 
situation_1_text
situation_2_text granted_item_key
...
situation_n_text
preceding_situation_key following_situation_key choice_0_text
preceding_situation_key following_situation_key choice_1_text
preceding_situation_key following_situation_key choice_2_text required_item_key
...
preceding_situation_key following_situation_key choice_n_text
```
You have the option to grant the player an item upon reaching a particular Situation, or require the player to possess a particular item to be able to select a choice.

## Credits
Developed by Eberardo Raymundo and William Willis.