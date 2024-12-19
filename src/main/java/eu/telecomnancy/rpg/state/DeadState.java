package eu.telecomnancy.rpg.state;
 

public class DeadState extends State {


    public boolean onEnterState() {
        character.setExperiencePoints(character.getExperiencePoints() - 10 ); // quand le perso meurt, il perd 10 pts d'exp.
        return true;
    }

    public boolean onExitState(){
        character.setHealth(100); // quand le perso revis, il reprends sa vie au niveau 100.
        return true;
    }


    public void onUpdate() {
        character.setExperiencePoints(character.getExperiencePoints() - 1); // quand le perso meurt, il prends 5 pts d'exp.
        }

    public float onAttack() {
        System.out.println("Tu es mort, tu ne peux pas attaquer");
        return 0;
    }
    
}
