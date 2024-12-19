package eu.telecomnancy.rpg.effects_visitor;

import eu.telecomnancy.rpg.Healer;
import eu.telecomnancy.rpg.Warrior;
import eu.telecomnancy.rpg.Wizard;

public interface CharacterVisitor { // interface Visitor qui permet d'implémenter les
    // méthodes d'effets sur les personnages selon leur type.

    public void visitWizard(Wizard wizard);

    public void visitWarrior(Warrior warrior);

    public void visitHealer(Healer healer);
}
