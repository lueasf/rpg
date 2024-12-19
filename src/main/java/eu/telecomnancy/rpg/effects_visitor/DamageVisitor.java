package eu.telecomnancy.rpg.effects_visitor;

import eu.telecomnancy.rpg.Wizard;
import eu.telecomnancy.rpg.Warrior;
import eu.telecomnancy.rpg.Healer;

public class DamageVisitor implements CharacterVisitor{
    // Concrete Visitor qui implémente l'effet de dégâts sur les personnages
    
    public void visitWizard(Wizard wizard){
        wizard.setHealth(wizard.getHealth() - 2);
    }

    public void visitWarrior(Warrior warrior) {
        warrior.setHealth(warrior.getHealth() - 1);
    }

    public void visitHealer(Healer healer) {
        healer.setHealth(healer.getHealth() - 3);
    }
}
