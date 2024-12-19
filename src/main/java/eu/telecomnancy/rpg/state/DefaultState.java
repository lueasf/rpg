package eu.telecomnancy.rpg.state;
 

public class DefaultState extends State {

    public int compt = 0;


    public boolean onEnterState() {
        return true;
    }

    public boolean onExitState(){
        return true;
    }

    public void onUpdate() {
        character.setExperiencePoints(character.getExperiencePoints() + 10);
        if (compt == character.getLevel()*2){ // on veut que le joueur gagane 1 niveau tous les 2*niveau tours.
            character.setLevel(character.getLevel()+ 1);    
            compt = 0;
        } else {
            compt++;
        }
    }

    public float onAttack() {
       return 1;
    }
    
}
