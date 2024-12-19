package eu.telecomnancy.rpg.state;
 

public class CheatState extends State {

    public int compt = 0;

    public boolean onEnterState() {
        character.setHealth(character.getHealth() + 100);
        return true;
    }

    public boolean onExitState(){
        character.setLevel(character.getLevel()+ 1);
        return true;
    }

    public void onUpdate() { // pour pas que le joueur reste en cheatState indéfiniment.
        if (compt == 5){
            character.setState(new DefaultState());
        } else {
            compt++;
        }
    }

    public float onAttack() {
        return 3; // LOL, cheatstate
    }
    
}
