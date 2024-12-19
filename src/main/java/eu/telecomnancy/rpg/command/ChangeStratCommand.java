package eu.telecomnancy.rpg.command;

import eu.telecomnancy.rpg.GameCharacter;
import eu.telecomnancy.rpg.facade.Game;
import eu.telecomnancy.rpg.fights_strategy.Strategy;

public class ChangeStratCommand extends Command {

    public GameCharacter character;
    public Strategy strategy;

    public ChangeStratCommand(Game game, GameCharacter character, Strategy strategy) {
        super(game);
        this.character = character;
        this.strategy = strategy;
    }

    public void execute() {
        game.changeStrat(character, strategy); // les actions sont faites sur la facade;
    }

    public void undo() {
    }
    
}


