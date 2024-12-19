package eu.telecomnancy.rpg;

import java.util.Random;

import eu.telecomnancy.rpg.effects_visitor.CharacterVisitor;


public class Wizard extends GameCharacter {

    private int intelligence;

    public Wizard(String name) {
        super(name);
        intelligence = getLevel() * 10 +new Random().nextInt(10);
        // l'intelligence du wizard est égale à 10 fois son niveau + un nombre aléatoire entre 0 et 9
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void accept(CharacterVisitor visitor){
        visitor.visitWizard(this);
    }
    
    
}
