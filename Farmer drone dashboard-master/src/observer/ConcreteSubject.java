package observer;

import java.util.ArrayList;

public class ConcreteSubject implements Subject {

    private ArrayList<Observer> observers;

    public ConcreteSubject(){
        observers = new ArrayList<>();
    }


    @Override
    public void Attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void Detach(Observer o) {
        int observerIndex = observers.indexOf(o);
        observers.remove(observerIndex);
    }

    @Override
    public void notifyObservers() {
        for(Observer o : observers){
            o.update();
        }
    }



}
