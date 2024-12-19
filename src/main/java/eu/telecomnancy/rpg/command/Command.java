package eu.telecomnancy.rpg.command;

import eu.telecomnancy.rpg.facade.Game;

public abstract class Command { // la classe a pour role d'appeler les bonnes méthodes de la facade.

    public final Game game; // On passe Game comme Attribut

    public Command(Game game) {
        this.game = game;
    } // rappel : quand un attribut est final, il doit être init dans le constructeur.

    public abstract void execute(); // abstract donc les classes enfants doivent bien les rédefinir.
    public abstract void undo();
}
