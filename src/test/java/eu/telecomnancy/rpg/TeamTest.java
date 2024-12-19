package eu.telecomnancy.rpg;

import java.util.ArrayList;
import java.util.Arrays;
import eu.telecomnancy.rpg.team.Team;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.junit.jupiter.api.Test;

class TeamTest {

    @Test
    void testCreateTeam() {
        Team team = new Team("test");
        assertEquals(0, team.size(), "L'équipe doit être vide");
        System.out.println("Le test 4 est bon (1er constructeur)");
    }

    @Test 
    void addCharacterToTeam() {
        Team team = new Team("test");
        Wizard wiz = new Wizard("test");
        team.addPlayer(wiz);
        assertEquals(1, team.size(), "L'équipe doit contenir un personnage");
        System.out.println("Le test 5 est bon (addPlayer)");
    }

    @Test
    void removeCharacterFromTeam() {
        Team team = new Team("test");
        Wizard wiz = new Wizard("wiz");
        Warrior war = new Warrior("war");
        team.addPlayer(wiz);
        team.addPlayer(war);
        team.removePlayer(wiz);
        assertEquals(1, team.size(), "L'équipe doit être composée d'un seul personnage");
        System.out.println("Le test 6 est bon (removePlayer)");
    }
    
    @Test
    void testCreateTeam2(){
        Wizard wiz = new Wizard("wiz1");
        Wizard wiz2 = new Wizard("wiz2");
        ArrayList<GameCharacter> players = new ArrayList<>(Arrays.asList(wiz, wiz2));
        Team team = new Team("equipe", players);
        assertEquals(2, team.size(), "L'équipe doit contenir 2 personnages");
        System.out.println("Le test 7 est bon (2eme constructeur)");
    }

    @Test
    void testCreateTeam3(){
        Wizard wiz = new Wizard("wiz1");
        Wizard wiz2 = new Wizard("wiz2");
        ArrayList<GameCharacter> players = new ArrayList<>(Arrays.asList(wiz, wiz2));
        Team team  = new Team("equipe", players);
        Team team2 = team.cloneTeam();
        assertNotSame(team, team2); // égalité avec un ""=="" (case mémoire)
        System.out.println("Le test 8 est bon (clone)");
    }

    @Test
    void TestContainsPlayer(){
        Wizard wiz = new Wizard("wiz1");
        Wizard wiz2 = new Wizard("wiz2");
        ArrayList<GameCharacter> players = new ArrayList<>(Arrays.asList(wiz, wiz2));
        Team team = new Team("equipe", players);
        assertEquals(true, team.containsPlayer("wiz1"), "L'équipe doit contenir wiz1");
        assertEquals(false, team.containsPlayer("wiz3"), "L'équipe ne doit pas contenir wiz3");
        System.out.println("Le test 9 est bon (containsPlayer)");
    }

}