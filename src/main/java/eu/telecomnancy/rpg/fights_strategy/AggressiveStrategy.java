package eu.telecomnancy.rpg.fights_strategy;

public class AggressiveStrategy implements Strategy {
    
    public int calculateDamageInflicted(int damage){ // ceci est un algorithme de calcul de dégâts dont se sert le personnage pour attaquer en mode agressif
        return damage + 10;
    }

    public int calculateDamageReceived(int damage){ 
        return damage + 8;
    }
}
