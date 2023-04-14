package com.tutorial;

import utilities.armor.Armor;
import utilities.weapon.Weapon;

import java.util.Arrays;

class Player{
    private String name;
    private int baseHealth;
    private int totalHealth;
    private int baseAttack;
    private int level;
    private Armor armor;
    private Weapon weapon;

    /*
    * -----Rules----
    * if player level up -> health += level * 7
    * base health ->  base original health player
    * base attack ->  base original attack player
    *
    * -----attack rules----
    * if player 1 attack, set level++
    * check compare weapon and defender armor,
    * if defender armor bigger than weapon attacker, damage taken only 20% and ( health defender - 20% damage from maxAttack weapon attacker )
    * else damage taken 50% from attack power
    *
    * if damage taken bigger than hp opponent, than player beat opponent
    * */
    // constructor
    public Player(String name, int level, int baseHealth){
        this.name = name;
        this.level = level;
        this.baseHealth = baseHealth + this.specialLevelUp();
        this.baseAttack = 20;
    }

    public void equipArmor(Armor armor){
        this.armor = armor;
        // set total health after equip the armor
        this.totalHealth = this.baseHealth + this.armor.getHealthArmor();
    }

    // setter weapon player
    public void equipWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    // level Up
    private void levelUp(){
        this.level++;
    }

    public void launchAttack(Player opponent){
        // initials rank armor and weapon
        final String[] ranks = {"E", "D", "C", "B", "A", "S"};

        // player 1 || attacker
        int damageAttack = this.getMaxAttack();

        System.out.println("\n"+this.getName() + " attacking on "+ opponent.getName() + " with damage "+ damageAttack);
        System.out.println(opponent.getName() + " with health "+ opponent.getTotalHealth()+"hp");

        // this logic attack player

        // check rank armor opponent
        // get higher or lower with index rank
        final int rankArmorOpponent = Arrays.asList(ranks).indexOf(opponent.armor.getRankArmor());
        final int rankWeaponAttacker = Arrays.asList(ranks).indexOf(this.weapon.getRankWeapon());
        final int damage;

        if(rankWeaponAttacker <= rankArmorOpponent){
            damage = ( this.getMaxAttack() / 100 ) * 20 ;
        }else{
            damage = ( this.getMaxAttack() / 100 ) * 50 ;
        }

        // if damage taken bigger than hp opponent, attacker auto win
        if(damage > opponent.getTotalHealth()){
            System.out.println(this.getName()+" beat "+ opponent.getName());
            return;
        }

        System.out.println(opponent.getName()+" damage taken "+damage);

        // after being attacked health will be reduced
        opponent.receiveAnAttack(damage);
        System.out.println("after damage taken "+ opponent.getTotalHealth());


        // after attack auto increment level attacker
        this.levelUp();
    }

    public int getBaseHealth(){
        return this.baseHealth;
    }

    private String getName(){
        return this.name;
    }

    private int specialLevelUp(){
        return this.level * 10;
    }

    public int getTotalHealth(){
        return this.totalHealth;
    }

    public void receiveAnAttack(int damage){
        this.totalHealth -= damage;
    }

    public int getMaxAttack(){
        // base attack increment while level up
        int attack = this.baseAttack + this.specialLevelUp();
        return attack + this.weapon.getAttackPower();
    }

    public void display(){
        System.out.println("\nname\t\t\t\t-> "+this.getName());
        System.out.println("base health\t\t\t-> "+this.getBaseHealth()+"hp");
        System.out.println("total health\t\t-> "+this.getTotalHealth()+"hp");
        System.out.println("level\t\t\t\t-> "+this.level);
        System.out.println("max attack\t\t\t-> "+this.getMaxAttack());
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("\nJava OOP Object Reference\n");

        Armor armor1 = new Armor("Done A", 3, 90, "B");
        Weapon weapon1 = new Weapon("Soaring", 120 , "A");

        Armor armor2 = new Armor("Done B", 2, 110, "A");
        Weapon weapon2 = new Weapon("Demon Axe", 80 , "B");

        Player player1 = new Player("helka", 4, 1200);
        player1.equipArmor(armor1);
        player1.equipWeapon(weapon1);

        Player player2 = new Player("dandi", 6, 1200);
        player2.equipArmor(armor2);
        player2.equipWeapon(weapon2);

        player1.display();
        player2.display();

        player1.launchAttack(player2);

        player1.display();
        player2.display();
    }
}
