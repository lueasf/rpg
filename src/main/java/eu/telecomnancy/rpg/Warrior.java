package eu.telecomnancy.rpg;

import java.util.Random;

import eu.telecomnancy.rpg.effects_visitor.CharacterVisitor; 

public class Warrior extends GameCharacter {
    private int strength;

    public Warrior(String name) {
        super(name);
        strength = getLevel() * 10 + new Random().nextInt(10);
        // la force du warrior est égale à 10 fois son niveau + un nombre aléatoire entre 0 et 9
    }

    public int getStrength() {
        return strength;
    }
    
    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void accept(CharacterVisitor visitor) {
        visitor.visitWarrior(this);
    }
    
    
}
