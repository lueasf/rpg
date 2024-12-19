package eu.telecomnancy.rpg;

import static org.junit.jupiter.api.Assertions.assertEquals;
 
import org.junit.jupiter.api.Test;

import eu.telecomnancy.rpg.effects_visitor.BuffVisitor;
 

public class DamageVisitorTest {
    
    @Test
    void testDamageVisitorWar() {
        Warrior warrior = new Warrior("w1"); 
        BuffVisitor buffVisitor = new BuffVisitor();
        warrior.accept(buffVisitor);
        assertEquals(100, warrior.getHealth(), "La vie du warrior doit être égale à 100 à l'origine");
        System.out.println("Le test 13 est bon (DamageVisitor Warrior)");
    }
}
