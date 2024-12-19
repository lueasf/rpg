package eu.telecomnancy.rpg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import eu.telecomnancy.rpg.fights_strategy.Strategy;

import eu.telecomnancy.rpg.command.AttackCommand;
import eu.telecomnancy.rpg.command.ChangeStratCommand;
import eu.telecomnancy.rpg.command.Command;
import eu.telecomnancy.rpg.facade.Game;
import eu.telecomnancy.rpg.fights_strategy.DefensiveStrategy;
import eu.telecomnancy.rpg.fights_strategy.AggressiveStrategy; 

public class CommandTest {
    
    /*
     * Test de la commande d'attaque
    */

    @Test
    void testCommand(){
        Game game = new Game();
        Wizard w1 = new Wizard("w1");
        Warrior w2 = new Warrior("w2");
        Command command = new AttackCommand(game, w1, w2);
        command.execute();
        assertEquals(92, w2.getHealth(), "Le warrior devrait avoir perdu 8 points de vie.");
        // En effet le niveau du wizard est de 1 donc : 1* 2.3f + 6 arrondi donne 8.
        System.out.println("Le test 25 est passé (Commande d'attaque)");
    }

    @Test
    void testCommand2(){
        Game game = new Game();
        Wizard w1 = new Wizard("w1");
        w1.setLevel(3);
        Warrior w2 = new Warrior("w2");
        Strategy s = new AggressiveStrategy(); // constructeur par défaut
        w1.setStrategy(s);
        assertTrue(w1.getStrategy() instanceof AggressiveStrategy);
        System.out.println("Le test 26 est passé (Commande d'attaque)");

        Command command = new ChangeStratCommand(game, w1, new DefensiveStrategy());
        command.execute();
        assertTrue(w1.getStrategy() instanceof DefensiveStrategy);
        System.out.println("Le test 27 est passé (Commande d'attaque)");

        Command command2 = new AttackCommand(game, w1, w2);
        command2.execute();
        assertEquals(95, w2.getHealth(), "Le warrior devrait avoir perdu 5 points de vie.");
        System.out.println("Le test 28 est passé (Commande d'attaque)");

        // En effet le niveau du wizard est de 3 donc : 3* 2.3f + 6 arrondi donne 13.
        // Or la stratégie défensive soustrait 8 dégats, ce qui fait 13 - 8 = 5. D'ou un niveau de vie de 100 - 5 = 95.
        
    }
}
