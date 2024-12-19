package eu.telecomnancy.rpg.observer;

public interface Subject {
    public void attach(Observer o); // pour qu'on puisse suivre les changements de tel perso

    public void detach(Observer o); // pour qu'on puisse arrêter de suivre les changements de tel perso

    public void notifyObservers(); // pour notifier les observateurs
}
