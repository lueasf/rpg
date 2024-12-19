package eu.telecomnancy.rpg.command;

import eu.telecomnancy.rpg.GameCharacter;
import eu.telecomnancy.rpg.facade.Game;

public class AttackCommand extends Command { 

    public GameCharacter attacker;
    public GameCharacter target;

    public AttackCommand(Game game, GameCharacter attacker, GameCharacter target) {
        super(game);
        this.attacker = attacker;
        this.target = target;
    }

    public void execute() { // pas d'args pour execute
        game.attack(attacker, target);
    }

    public void undo() {
    }
    
}