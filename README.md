
# Java Simple Game

traning java programming and make a simple game and logic.
## About
this game can play with 2 player and once player can attack with weapon and use armor for plush his health point.
### Player Class C-Tor and atrs
* name
* level
* base health
* total health
* base attack by default (20)
### Weapon Class C-Tor and atrs
* name
* rank
* attack power
### Armor Class C-Tor and atrs
* name
* rank
* strength
* health
## Rules
* -------basic role player-------
* player base health + special level -> total health
* if player equip armor total health + max value armor (health, strength and rank)
* if player equip weapon total power + max value weapon (power and rank)
* -------increment when player attacking--------
* if player level up -> health += level * 7
* base health ->  base original health player
* base attack ->  base original attack player

* -----attack rules----
* if player attack, set level++
* check compare weapon and defender armor,
* if defender armor bigger than weapon attacker, 
* damage taken only 20% and ( health defender - 20% 
* damage from maxAttack weapon attacker )
* else damage taken 50% from attack power

* if damage taken bigger than hp opponent, than player beat opponent
## Features

- level up player
- attacking
- simple logic defense opponent


## Used By

This project is used by:

- helka septyawan

