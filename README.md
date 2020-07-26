<br />
<p align='center'>
  TLOZ-themed text adventure game using creational, behavioral and structural design patterns.
  <h3 align="center">Text Adventure</h3>
</p>

## Table of Contents
* [About this project](#about-this-project)
* [Game elements](#available-commands)
* [Design patterns](#design-patterns)
* [Credits](#credits)

## About this project
This project was developer for Object Oriented Programming class, back in 2018. We were supposed to develop a text adventure using at least one creational design pattern, one behavioral design pattern and one structural design pattern. In this project the design patterns used were Singleton, Factory and Builder.

## Game elements
* A character, with a base HP of 3 hearts.
* Weapons that could be found in the map, categorized by rarities and Attack Damage stat.
* Armor, that could be found in the map, used to mitigate the damage received by monsters. Categorized by rarities and could be destroyed.
* Monster spawned randomly on the map. Fights are automatic.
* Traps set randomly on the map, if the player had an special item to defuse the trap, it could be disabled and receive no damage. If the player didn't have such special item, the character would receive a fixed amount of damage.
* NPCs spawner randomly among the map, usually selling potions and trap's special items.
* On each level, the map spawned a Triforce piece. When the player fetches each Triforce piece it would advance to the next level. The last level was a fight with Ganon.

## Design patterns
* Singleton: was used to create only one instance of a map on each level. Since the game had 4 levels, there were 4 singletons, one for each map.
* Builder: used to equip armors and weapons to the character, being the body itself of the charactar the base object.
* Factory: two factories, one to randomly generate armors and one to randomly generate weapons. Probability changed depending on rarity.

## Screenshots
#### Main Menu
![Menu](https://raw.githubusercontent.com/gabrieltrompiz/text-adventure/master/img/main-menu.PNG)

#### Fighting Monsters
![Fighting Monsters](https://raw.githubusercontent.com/gabrieltrompiz/text-adventure/master/img/fighting-monsters.PNG)

#### Finding Objects
![Finding Objects](https://raw.githubusercontent.com/gabrieltrompiz/text-adventure/master/img/finding-objects.PNG)

#### Finding Weapon
![Finding Weapon](https://raw.githubusercontent.com/gabrieltrompiz/text-adventure/master/img/finding-weapon.PNG)

#### Inventory
![Inventory](https://raw.githubusercontent.com/gabrieltrompiz/text-adventure/master/img/inventory.PNG)

#### NPCs
![NPCs](https://raw.githubusercontent.com/gabrieltrompiz/text-adventure/master/img/NPCs.PNG)

#### Moving to next level
![Moving to next level](https://raw.githubusercontent.com/gabrieltrompiz/text-adventure/master/img/finding-triforce.PNG)

## Credits
This project was developed by Gabriel Trompiz: [@gabrieltrompiz](https://github.com/gabrieltrompiz).