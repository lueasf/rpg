package eu.telecomnancy.rpg.decorator;

import java.util.ArrayList;

import eu.telecomnancy.rpg.GameCharacter;
import eu.telecomnancy.rpg.effects_visitor.CharacterVisitor;
import eu.telecomnancy.rpg.fights_strategy.Strategy;
import eu.telecomnancy.rpg.observer.Observer;

public class ArmoredDecorator extends GameCharacter{ // réduit les degats
    
    private GameCharacter character; // on stoque le personnage, afin de l'utiliser pour les methodse comme receiveDamage etc
    // le but est d'avoir un objet qui est le perso décoré avec les bons attributs et les bonnes méthodes.
    // En dehors du constructeur, il n'exoisterao pas sans cette variable character.

    public ArmoredDecorator(GameCharacter character){ // on peut enchainer plusieurs fois le decorateur
        super(character.getName()); // on est obligé de mettre le super, il nous force à proxyfier les méthodes.
        this.character = character;   
    }

    @Override
    public void receiveDamage(int damage){
        character.receiveDamage(damage - 2);
    }

    public void giveDamage(GameCharacter c){
        int d = character.getStrategy().calculateDamageInflicted(10); 
        c.receiveDamage(d);
    }

    public void accept(CharacterVisitor visitor){
        character.accept(visitor); // car character sait de quel type il est. 
    }

    // public int getHealth(){
    //     return super.getHealth();
    // }    écrire cette méthodde c'est pareil que ne rien ecrire dans le fichier
    // il faut rédefinir les méthodes de GameChar ici spécialement pour le character qui 
    // correspond à l'objet que l'on a décoré. 

    // Ex : Si le mec décoré prends des dégats avec la fonction overide receiveDamage,
    // alors c'est bien sa santé qui a décru et pas celle de de l'armure.
    // EN effet ArmoredDecorator possède une santé car il extend gamechar, mais ca ne représente pas 
    // la santé du personnage qu'il a décoré.


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
