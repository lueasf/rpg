package eu.telecomnancy.rpg.effects_visitor;

import eu.telecomnancy.rpg.Healer;
import eu.telecomnancy.rpg.Warrior;
import eu.telecomnancy.rpg.Wizard;

public class HealVisitor implements CharacterVisitor {
    
    public void visitWarrior(Warrior warrior) {
        warrior.setHealth(warrior.getHealth() + 10 );
    }

    public void visitWizard(Wizard wizard) {
        wizard.setHealth(wizard.getHealth() + 5 );
    }

    public void visitHealer(Healer healer) {
        healer.setHealth(healer.getHealth() + 10 );
    }


}
