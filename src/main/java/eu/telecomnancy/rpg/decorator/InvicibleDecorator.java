package eu.telecomnancy.rpg.decorator;

import java.util.ArrayList;

import eu.telecomnancy.rpg.GameCharacter;
import eu.telecomnancy.rpg.effects_visitor.CharacterVisitor;
import eu.telecomnancy.rpg.fights_strategy.Strategy;
import eu.telecomnancy.rpg.observer.Observer;

public class InvicibleDecorator extends GameCharacter { // sa santé ne peut pas descendre en dessous de 20.
    
    private GameCharacter character; 

    public InvicibleDecorator(GameCharacter character){ 
        super(character.getName()); 
        this.character = character;   
    }

    @Override
    public void receiveDamage(int damage){
        if (character.getHealth() - damage < 20){
            character.setHealth(20);
        } else {
            character.receiveDamage(damage);
        }
    }

    public void giveDamage(GameCharacter c){
        int d = character.getStrategy().calculateDamageInflicted(10); 
        c.receiveDamage(d);
    }

    public void accept(CharacterVisitor visitor){
        character.accept(visitor); // car character sait de quel type il est. 
    }

    // on rédefinit bien touttes ls méthodes avec le character et non pas avec this 
    public int getHealth(){
        return character.getHealth();
    }

    public String getName() {
        return character.getName();
    }

    public void setStrategy(Strategy strategy) {
        character.setStrategy(strategy);;
    }

    public Strategy getStrategy() {
        return character.getStrategy();
    }


    public void setHealth(int health) {
        character.setHealth(health);
    }

    public int getExperiencePoints() {
        return character.getExperiencePoints();
    }

    public void setExperiencePoints(int experiencePoints) {
        character.setExperiencePoints(experiencePoints);
    }

    public int getLevel() {
        return character.getLevel();
    }

    public void setLevel(int level) {
        character.setLevel(level);
    }

    public String toString() {
        return character.getName() + " (Level " + character.getLevel() + ") with " + character.getHealth() + " HP and " + character.getExperiencePoints() + " XP";
    }

    public ArrayList<Observer> getObservers() {
        return character.getObservers();
    }

    public void attach(Observer o) {
        character.attach(o);
    }

    public void detach(Observer o) {
        character.detach(o);
    }

    public void notifyObservers() { // pour tout les observateurs, on notifie.
        character.notifyObservers();
    }
}
