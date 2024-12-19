package eu.telecomnancy.rpg.fights_strategy;

public class NeutralStrategy implements Strategy {
    
    public int calculateDamageInflicted(int damage){
        return damage;
    }

    public int calculateDamageReceived(int damage){
        return damage;
    }
}
