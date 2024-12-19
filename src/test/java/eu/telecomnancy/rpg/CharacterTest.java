package eu.telecomnancy.rpg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CharacterTest {
    // ce fichier teste la correcte création des personnages avec les valeurs par défaut.
    // Niveau 1, 100 points de vie, 0 points d'expérience.

    @Test
    void testCreateCharacter() {
        Warrior warrior = new Warrior("w1");
        assertEquals(100, warrior.getHealth(), "Health devrait être 100");
        // assertEquals permet de faire un test d'égalité entre deux valeurs et de renvoyer un msg d'erreur si elles ne sont pas égales.
        System.out.println("Le 1 test est bon");
    }

    @Test
    void testCreateCharacter2() {
        Wizard Wizard = new Wizard("w2");
        assertEquals(0, Wizard.getExperiencePoints(), "ExperiencePoints devrait être 0");
        System.out.println("Le 2 test est bon");
    }

    @Test
    void testCreateCharacter3() {
        Healer healer = new Healer("h1");
        String message = "Level devrait être 1";
        assertEquals(1, healer.getLevel(), message);
        System.out.println("Le 3 test est bon");
    }

    
}
