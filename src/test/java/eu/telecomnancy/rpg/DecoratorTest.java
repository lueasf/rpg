package eu.telecomnancy.rpg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import eu.telecomnancy.rpg.decorator.InvicibleDecorator;
import eu.telecomnancy.rpg.decorator.ArmoredDecorator;

public class DecoratorTest {

    /*
     * Test de la classe InvicibleDecorator
    */
    @Test 
    void testDecorator() {
        Wizard w = new Wizard("w1");
        w.setHealth(23);
        InvicibleDecorator inv = new InvicibleDecorator(w);
        inv.receiveDamage(10);
        assertEquals(20,w.getHealth(), "L'état de santé du personnage ne doit pas descendre en dessous de 20");
        System.out.println("Le test 22 est bon (InvicibleDecorator)");
    }

    /*
     * Test de la classe ArmoredDecorator
    */
    @Test
    void testDecorator2(){
        Healer h = new Healer("h1");
        h.setHealth(28);
        ArmoredDecorator arm = new ArmoredDecorator(h);
        arm.receiveDamage(10);
        assertEquals(20, arm.getHealth(), "L'état de santé du personnage doit être de 20 car 28-(10-2))");
        System.out.println("Le test 23 est bon (ArmoredDecorator)");
    }

    /*
     * Test de la classe ArmoredDecorator cumulée avec InvicibleDecorator
    */
    @Test 
    void testDecorator3(){
        Healer h = new Healer("h1");
        h.setHealth(22);
        ArmoredDecorator arm = new ArmoredDecorator(h);
        InvicibleDecorator inv = new InvicibleDecorator(arm);
        inv.receiveDamage(10);
        assertEquals(20, inv.getHealth(), "L'état de sante du perso est de 20 car 22 - (10-2) avec Invicible ne descend pas en dessous de 20");
        System.out.println("Le test 24 est bon (ArmoredDecorator + InvicibleDecorator)");
    }
    
}
