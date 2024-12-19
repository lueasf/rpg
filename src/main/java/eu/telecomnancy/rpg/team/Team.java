package eu.telecomnancy.rpg.team;

import java.util.ArrayList;
import java.util.Collection;

import eu.telecomnancy.rpg.GameCharacter;

public class Team implements PrototypeTeam{

    private final String name;

    private Collection<GameCharacter> players;

    public Team(String name) { // testé, approuvé
        // ce constructeur permet de créer l'équipe avec un nom et aucun joueur.
        this.name = name;
        players=new ArrayList<GameCharacter>(); // ce constructeur permet d'initialiser des equipes avec nom, sans donner des listes de joueurs ou des 'null'.
    }

    public Team(String name, Collection<GameCharacter> players){ // avec ce cons
        this.name = name;
        this.players = new ArrayList<>(players);
    }

    private Team(Team team){ // ce constructeur construit un clone d'une équipe existante.
        this.players = new ArrayList<>(team.getPlayers());
        this.name = team.getName();
    }

    public String getName() {
        return name;
    }
    
    public Collection<GameCharacter> getPlayers() {
        return players;
    }
    public void addPlayer(GameCharacter player) { // testé, approuvé
        players.add(player);
    }

    public void removePlayer(GameCharacter player) { // testé, approuvé
        players.remove(player);
    }

    public void removePlayer(String name) {
        for (GameCharacter player : players) {
            if (player.getName().equals(name)) {
                players.remove(player);
                return;
            }
        }
    }

    public GameCharacter getPlayer(String name) {
        for (GameCharacter player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public boolean containsPlayer(String name) {
        for (GameCharacter player : players) {
            if (player.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsPlayer(GameCharacter player) { // testé, approuvé
        return players.contains(player);
    }

    public int size() {
        return players.size();
    }

    public Team cloneTeam(){ // testé, approuvé
        return new Team(this); // retourne le clone de l'équipe actuelle, grace au constructeur pv, car this est de type Team.
    }
}
