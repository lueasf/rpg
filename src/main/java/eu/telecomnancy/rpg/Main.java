package eu.telecomnancy.rpg;

import java.util.Scanner; // Scanner c'est une classe qui permet de lire des entrées de l'utilisateur

import eu.telecomnancy.rpg.state.DeadState;



/*
*  Cette classe permettrait de lancer une partie pour voir l'état du jeu en ligne de commande,
*  toutefois cette partie n'est pas obligatoire, je m'en dispense donc.
*
*  Il y a un exemple actuellement, mais ce n'est pas très fonctionnel.
* */
public class Main {

public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameCharacter player1 = createCharacter(scanner, 1);
        GameCharacter player2 = createCharacter(scanner, 2);

        while (!(player1.getState() instanceof DeadState) && !(player2.getState() instanceof DeadState)) {
            player1.giveDamage(player2);
            if (!(player2.getState() instanceof DeadState)) {
                player2.giveDamage(player1);
            }
        }

        if (!(player1.getState() instanceof DeadState)) {
            System.out.println(player1.getName() + " a gagné!");
        } else {
            System.out.println(player2.getName() + " a gagné!");
        }

        scanner.close();
    }

    private static GameCharacter createCharacter(Scanner scanner, int playerNumber) {
        System.out.println("Joueur " + playerNumber + ", choisis ton personnage (1: Wizard, 2: Warrior, 3: Healer): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Entre le nom de ton perso ");
        String name = scanner.nextLine();

        if (choice == 1) {
            return new Wizard(name);
        } else if (choice == 2) {
            return new Warrior(name);
        } else {
            return new Healer(name);
        }
    }
}
