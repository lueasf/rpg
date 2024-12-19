package eu.telecomnancy.rpg.characters_factory;

import eu.telecomnancy.rpg.Warrior;

public class WarriorCreator implements CharacterCreator{

    public Warrior createCharacter(){
        return new Warrior("Warrior");
    }
    
}
