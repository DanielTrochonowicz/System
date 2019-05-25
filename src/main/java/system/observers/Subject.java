package system.observers;

public interface Subject {

    // Zapis do obserwowania
    //Wypisanie z obserwowani
    // powiadomienie wszystkich obserwatorów


    void assingToSubject(Observer o);
    void unassingFromSubject(Observer o);
    void notifyObservers();
}
