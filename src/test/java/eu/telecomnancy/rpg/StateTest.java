package eu.telecomnancy.rpg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import eu.telecomnancy.rpg.state.CheatState;
import eu.telecomnancy.rpg.state.DeadState; 

public class StateTest {
    

    /*
     * Test de l'état CheatState
    */
    @Test
    void stateTest(){
        Wizard w1 = new Wizard("Merlin");
        Warrior w2 = new Warrior("Wario");
        CheatState cheat = new CheatState();
        w1.setState(cheat);
        w1.setLevel(3);
        assertEquals(200, w1.getHealth(), "Le niveau de santé du Wizard devrait être de 200");
        System.out.println("Le test 29 est bon (CheatState)");

        w1.giveDamage(w2);
        assertEquals(61, w2.getHealth(), "Le niveau de santé de Wario devrait être de 100");
        System.out.println("Le test 30 est bon (CheatState)");
        // le niveau de santé de Wario devrait être de 61 car niveau de warior * 2.3 + 6 arrondi fait 13, * 3 = 39. 100 - 39 = 61

        assertEquals(200, w1.getHealth(), "Le niveau de santé du Wizard devrait être de 200");
        System.out.println("Le test 31 est bon (CheatState)");
        // Le niveau de santé du wizard devrait être de 200, car il en a 100 au début et et il gagne 100 en rentrant dans le cheat mode.

        assertEquals(20,w1.getExperiencePoints(), "Le nombre de points de w1 devrait être de 20");
        System.out.println("Le test 32 est bon (CheatState)");
        // Le nombre de points de w1 devrait être de 20, car il en a 0 au début et il gagne 20 en attaquant.

        w2.receiveDamage(60);
        assertTrue(w2.getState() instanceof CheatState);
        // Le personnage a 61 de vie et reçoit 60 dégats donc il passe en cheatState miraculeusement.
        System.out.println("Le test 33 est bon (CheatState)");
    }


    /*
     * Test de l'état DeadState
    */
    @Test 
    void stateTest2(){
        Wizard w1 = new Wizard("Merlin");
        Warrior w2 = new Warrior("Wario");
        DeadState dead = new DeadState();
        w1.setState(dead);
        w1.giveDamage(w2);
        assertEquals(100, w2.getHealth(), "Le niveau de santé de Wario devrait être de 100");
        System.out.println("Le test 34 est bon (DeadState)");
        // En effet, étant mort, Merlin ne peut pas attaquer.
    }
}
