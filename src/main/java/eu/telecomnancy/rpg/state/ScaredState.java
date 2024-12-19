package eu.telecomnancy.rpg.state;
 

public class ScaredState extends State {


    public boolean onEnterState() {
        return true; 
    }

    public boolean onExitState(){
        return true;
    }

    public void onUpdate() {
        character.setExperiencePoints(character.getExperiencePoints() - 2);
    }

    public float onAttack() {
        return 1.2f;
    }
    
}
