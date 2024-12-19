package eu.telecomnancy.rpg.team;

import java.util.ArrayList;
import java.util.Collection;

import eu.telecomnancy.rpg.GameCharacter;

public class Builder { // permet de choisir ce que je veux ajouter comme caractéristiques (nom, joueurs etc...)

    // ces méthodes renvoient l'objet Builder lui-même pour permettre de chaîner les appels.
    
    private Collection<GameCharacter> players = new ArrayList<>();
    private String name = "default";


    // on peut ajouter un joueur à la liste de joueurs
    public Builder ajouterJouer(GameCharacter player){ // testé, approuvé
        players.add(player);
        return this;
    }

    // on peut ajoiuter un nom à l'équipe
    public Builder ajouterNom(String name){ // testé, approuvé
        this.name = name;
        return this;
    }

    // on utilise la méthode build() pour construire l'équipe (retourne une équipe)
    public Team build(){ // testé, approuvé
        return new Team(name, players);
    }
}
