package eu.telecomnancy.rpg;
 
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.RepeatedTest; // pour repeter le test plusieurs fois et tester correctement le random

import eu.telecomnancy.rpg.effects_visitor.BuffVisitor;
 

public class BuffVisitorTest {
    
    @RepeatedTest(10)
    void testBuffVisitorWiz() {
        Wizard wizard = new Wizard("w1"); 
        BuffVisitor buffVisitor = new BuffVisitor();
        wizard.accept(buffVisitor);
        assertTrue(wizard.getIntelligence() <= 23, "L'intelligence du wizard doit supérieure à 23 à l'origine" + wizard.getIntelligence());
        // en effet, on a 19 d'intelligence à l'origine, et on ajoute 2*random(3) à l'intelligence au max.
        assertTrue(wizard.getIntelligence() >= 1, "L'intelligence du wizard doit être positive");
        System.out.println("Le test 14 est bon (BuffVisitor Wizard)");

    }

    @RepeatedTest(10)
    void testBuffVisitorWar(){
        Warrior warrior = new Warrior("w1");
        BuffVisitor buffVisitor = new BuffVisitor();
        warrior.accept(buffVisitor);
        assertTrue(warrior.getStrength() <= 21, "La force du warrior doit être inférieure à 21 à l'origine" + warrior.getStrength());
        // en effet, on a 19 de force à l'origine, et on ajoute random(3) à la force au max.
        assertTrue(warrior.getStrength() >= 1, "La force du warrior doit être positive");
        System.out.println("Le test 15 est bon (BuffVisitor Warrior)");
    }


    @RepeatedTest(10)
    void testBuffVisitorHeal(){
        Healer healer = new Healer("w1");
        BuffVisitor buffVisitor = new BuffVisitor();
        healer.accept(buffVisitor);
        assertTrue(healer.getWisdom() <= 25, "La sagesse du healer doit être inférieure à 25 à l'origine" + healer.getWisdom());
        // en effet, on a 19 de sagesse à l'origine, et on ajoute 3*random(3) à la sagesse au max.
        assertTrue(healer.getWisdom() >= 1, "La sagesse du healer doit être positive");
        System.out.println("Le test 16 est bon (BuffVisitor Healer)");
    }
}
