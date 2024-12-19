package eu.telecomnancy.rpg.facade;

import java.util.ArrayList;

import eu.telecomnancy.rpg.GameCharacter;
import eu.telecomnancy.rpg.fights_strategy.Strategy;
import eu.telecomnancy.rpg.team.Team;

public class Game { // cette classe représente la facade. Ces méthodes sont les seules que l'on peut appeler depuis l'extérieur
    
    private ArrayList<Team> teams = new ArrayList<Team>();

    public Game(){

    }

    public Team créerTeam(String name){
        Team team = new Team(name);
        teams.add(team);
        return team;
    }

    public void supprimerTeam(String name){
        for (Team team : teams){
            if (team.getName().equals(name)){
                teams.remove(team);
                break;
            }
        }
    }

    public void attack(GameCharacter attacker, GameCharacter target){
        attacker.giveDamage(target);
    }

    public void changeStrat(GameCharacter character, Strategy strategy){
        character.setStrategy(strategy);
    }

}
