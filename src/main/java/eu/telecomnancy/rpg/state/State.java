package eu.telecomnancy.rpg.state;

import eu.telecomnancy.rpg.GameCharacter;

public abstract class State {

    protected GameCharacter character; 

    // public State(GameCharacter character) { // pour que les classes filles appellelent
    //     this.character = character;
    // }
    
    public void setGameCharacter(GameCharacter character) {
        this.character = character;
    }

    public abstract boolean onEnterState();
    public abstract void onUpdate();
    public abstract float onAttack();
    public abstract boolean onExitState();
}
