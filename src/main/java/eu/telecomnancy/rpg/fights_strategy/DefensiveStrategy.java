package eu.telecomnancy.rpg.fights_strategy;

public class DefensiveStrategy implements Strategy {
    public int calculateDamageInflicted(int damage) {
        return damage - 8;
    }

    public int calculateDamageReceived(int damage) {
        return damage - 5;
    }
}
