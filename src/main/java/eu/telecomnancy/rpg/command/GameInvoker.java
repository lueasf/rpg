package eu.telecomnancy.rpg.command;

import java.util.ArrayList;

public class GameInvoker {
    
    ArrayList<Command> commands;

    public GameInvoker(){
        this.commands = new ArrayList<Command>();
    }

    public void executeCommands(){ // cette méthode éxécute les commandes de la liste commands
        for (Command command : commands){
            command.execute();
        }
    }

    
}
