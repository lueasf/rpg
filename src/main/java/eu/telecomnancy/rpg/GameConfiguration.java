package eu.telecomnancy.rpg;

public class GameConfiguration { // design pattern : singleton
    private int niveauDifficulte;
    private int tailleMaxEquipe;
    private static GameConfiguration config;

    private GameConfiguration(int nv, int tm, GameConfiguration c){ // private pour le cons car c'est un singleton, donc pas d'autre instantiation
        this.niveauDifficulte = nv;
        this.tailleMaxEquipe = tm;
        GameConfiguration.config = c;
    }

    public int getNiveauDifficulte() {
        return niveauDifficulte;
    }

    public int getTailleMaxEquipe() {
        return tailleMaxEquipe;
    }

    public static GameConfiguration getConfig() { // la méthode qui permet de récupérer l'instance unique donc on la met en static
        return config;
    }

    public void setNiveauDifficulte(int niveauDifficulte) {
        this.niveauDifficulte = niveauDifficulte;
    }

    public void setTailleMaxEquipe(int tailleMaxEquipe) {
        this.tailleMaxEquipe = tailleMaxEquipe;
    }

    public static void setConfig(GameConfiguration config) {
        GameConfiguration.config = config;
    }

    
}
