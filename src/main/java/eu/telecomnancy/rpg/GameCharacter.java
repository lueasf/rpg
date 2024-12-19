package eu.telecomnancy.rpg;

import java.util.ArrayList;

import eu.telecomnancy.rpg.effects_visitor.CharacterVisitor;
import eu.telecomnancy.rpg.fights_strategy.*;
import eu.telecomnancy.rpg.observer.Observer;
import eu.telecomnancy.rpg.observer.Subject;
import eu.telecomnancy.rpg.state.CheatState;
import eu.telecomnancy.rpg.state.DeadState;
import eu.telecomnancy.rpg.state.DefaultState;
import eu.telecomnancy.rpg.state.ScaredState;
import eu.telecomnancy.rpg.state.State; 

public abstract class GameCharacter implements Subject{

    private final String name;
    private State state; // état du personnage
    private int health;
    private int experiencePoints;
    private int level;
    private Strategy strategy;
    private ArrayList<Observer> observers = new ArrayList<Observer>(); // cette liste contient les observateurs qui suivent le perso.
    
    
    public GameCharacter(String name) {
        this.name = name;
        this.experiencePoints = 0;
        this.level = 1;
        this.health = 100;
        this.strategy = new NeutralStrategy();
        this.state = new DefaultState();
        this.state.setGameCharacter(this); // associe un perso au state
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
    
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    
    public State getState() {
        return state;
    }
    
    public void setState(State state) {
        this.state.onExitState(); // avant d'entrer dans le state, on appelle la méthode de sortie, qui peut faire effet.
        this.state = state;
        this.state.setGameCharacter(this);
        this.state.onEnterState(); // après être entré dans le state, on appelle la méthode d'entrée, qui peut faire effet.
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String toString() {
        return name + " (Level " + level + ") with " + health + " HP and " + experiencePoints + " XP";
    }

    public abstract void accept(CharacterVisitor visitor); // abstraite car on ne peut pas instancier un GameCharacter, donc pas appeler la methode accept dessus;

    public void receiveDamage(int damage) {
        int d = this.strategy.calculateDamageReceived(damage); // on appelle la méthode calculateDamageReceived de la stratégie du personnage
        this.health -= d; // on retire les dégâts à la santé du personnage selon la stratégie prise en compte
        if (this.health <= 0){
            this.setState(new DeadState()); // si le personnage n'a plus de vie, on le met en état mort
        }
        else if(this.health <= 15 && this.health != 1){
            this.setState(new ScaredState()); // si le personnage a 15 points de vie, on le met en état peur pour sa vie;
        }
        else if (this.health == 1){
            this.setState(new CheatState()); // si il reste un seul point de vie au personnage, on le passe en cheatstate.
            // Ceci est un esater egg.
        }
        this.state.onUpdate(); // on appelle la méthode onUpdate car un tour est passé.
    }

    public void giveDamage(GameCharacter character){
        this.setExperiencePoints(this.getExperiencePoints() + 20); // le personnage gagne 20 points d'expérience en attaquant
        int damage = Math.round(this.getLevel() * 2.3f + 6); // le personnage peut infliger des dégats égaux à son niveau * 2.3 + 6
        damage = Math.round(damage * this.state.onAttack()); // Selon l'état du joueur, le nombre de dégats infligé est modifié.
        int d = this.strategy.calculateDamageInflicted(damage); // le personnage peut infliger 10 de dégats en neutral, 20 en aggressive et 2 en defensive
        character.receiveDamage(d);
    }

    public void attach(Observer o) {
        observers.add(o);
    }

    public void detach(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() { // pour tout les observateurs, on notifie.
        for (Observer o : observers){
            o.update();
        }
    }

}
