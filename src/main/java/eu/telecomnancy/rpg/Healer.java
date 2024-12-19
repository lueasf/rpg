package eu.telecomnancy.rpg;

import java.util.Random;

import eu.telecomnancy.rpg.effects_visitor.CharacterVisitor;


public class Healer extends GameCharacter {
    private int wisdom;

    public Healer(String name){
        super(name);
        wisdom = getLevel() * 10+new Random().nextInt(10);
        // la sagesse du healer est égale à 10 fois son niveau + un nombre aléatoire entre 0 et 9
    }

    public int getWisdom(){
        return this.wisdom;
    }

    public void setWisdom(int w){
        this.wisdom = w;
    }

    public void accept(CharacterVisitor visitor){
        visitor.visitHealer(this); // on appelle la méthode visitHealer de visitor (BuffVisitor, DamageVisitor, HealVisitor)
        // sur l'objet healer courant
    }
}

