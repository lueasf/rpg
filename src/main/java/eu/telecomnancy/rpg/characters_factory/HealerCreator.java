package eu.telecomnancy.rpg.characters_factory;
 
import eu.telecomnancy.rpg.Healer;

public class HealerCreator implements CharacterCreator{

    @Override
    public Healer createCharacter(){
        return new Healer("Healer");
    }
    
}
