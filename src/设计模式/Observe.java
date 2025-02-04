package 设计模式;

import java.util.ArrayList;
import java.util.List;

public class Observe {

    class Subject {
        private List<Observer> observer = new ArrayList<>();

        public void attach(Observer observer) {
            this.observer.add(observer);
        }

        public void detach(Observer observer) {
            this.observer.remove(observer);
        }

        public void notifyObserver() {
            for (Observer observer : observer) {
                observer.update(this);
            }
        }
    }

    interface Observer {
        void update(Observe.Subject subject);
    }

    class ConcreteSubject extends Subject {
        private int state;

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
            notifyObserver();
        }
    }

    class ConcreteObserver extends Subject {
        private String name;

        public ConcreteObserver(String name) {
            this.name = name;
        }
    }

}
