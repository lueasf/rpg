package eu.telecomnancy.rpg.characters_factory;

import eu.telecomnancy.rpg.Wizard;

public class WizardCreator implements CharacterCreator{

    @Override
    public Wizard createCharacter(){
        return new Wizard("Wizard");
    }
    
}
