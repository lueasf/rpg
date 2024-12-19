package eu.telecomnancy.rpg.effects_visitor;

import eu.telecomnancy.rpg.Healer;
import eu.telecomnancy.rpg.Warrior;
import eu.telecomnancy.rpg.Wizard;

import java.util.Random;

public class BuffVisitor implements CharacterVisitor{
    // Concrete Visitor qui implemente l'effet buff sur les personnages
    
    private Random random = new Random();

    public void visitWizard(Wizard wizard){ // testé, approuvée
        wizard.setIntelligence(wizard.getIntelligence() + 2 * random.nextInt(3));
    }

    public void visitWarrior(Warrior warrior) { // testé, approuvée
        warrior.setStrength(warrior.getStrength() + random.nextInt(3));
    }

    public void visitHealer(Healer healer) {    // testé, approuvée
        healer.setWisdom(healer.getWisdom() + 3* random.nextInt(3));
    }

}