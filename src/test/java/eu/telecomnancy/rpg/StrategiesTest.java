package eu.telecomnancy.rpg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import eu.telecomnancy.rpg.fights_strategy.AggressiveStrategy;
import eu.telecomnancy.rpg.fights_strategy.DefensiveStrategy;

public class StrategiesTest {
    
    @Test
    void testAggressiveStrategy() {
        AggressiveStrategy aggre = new AggressiveStrategy();
        Wizard w = new Wizard("Merlin");
        w.setStrategy(aggre);
        w.receiveDamage(5);
        assertEquals(87, w.getHealth(), "La santé du wizard devrait être de 87");
        System.out.println("Le test 17 est bon. (agressive strategy)");
    }

    @Test
    void testDefensiveStrategy() {
        DefensiveStrategy def = new DefensiveStrategy();
        Warrior w = new Warrior("War");
        w.setStrategy(def);
        w.receiveDamage(10);
        assertEquals(95, w.getHealth(), "La santé du warrior devrait être de 95");
        System.out.println("Le test 18 est bon. (defensive strategy)");
    }
}
