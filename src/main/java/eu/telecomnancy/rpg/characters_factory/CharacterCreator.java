package eu.telecomnancy.rpg.characters_factory;

import eu.telecomnancy.rpg.GameCharacter;

public interface CharacterCreator { // design pattern : Factory Method

    public GameCharacter createCharacter();
}
