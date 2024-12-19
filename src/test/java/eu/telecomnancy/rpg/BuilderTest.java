package eu.telecomnancy.rpg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import eu.telecomnancy.rpg.team.Builder;
import eu.telecomnancy.rpg.team.Team;

public class BuilderTest {

    @Test
    void testBuilder() {
        Warrior warrior = new Warrior("w1");

        Team team = new Builder()
                .ajouterJouer(warrior)
                .ajouterNom("equipe2")
                .build();
        assertEquals("equipe2", team.getName(), "Le nom de l'équipe doit être equipe2"); 
        System.out.println("Le test 10 est bon (Builder nom)");

    }
    
    @Test
    void testBuilder2() {
        Warrior warrior = new Warrior("w1");
        Wizard wizard = new Wizard("w2");
        Team team = new Builder()
                .ajouterJouer(warrior)
                .ajouterJouer(wizard) 
                .build();
        assertEquals(List.of(warrior, wizard), team.getPlayers(), "Les personnages doivent être w1 et w2");
        System.out.println("Le test 11 est bon (Builder joueurs)");
    
    }   

    @Test
    void testBuilder3() {
        Team team = new Builder()
                .build();  
        assertEquals("default", team.getName(), "L'équipe doit s'appeler default");
        System.out.println("Le test 12 est bon (Builder nom default)");
    }
}
