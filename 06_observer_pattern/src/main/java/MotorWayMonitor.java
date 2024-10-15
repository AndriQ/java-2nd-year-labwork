import java.util.ArrayList;
import java.util.List;

public class MotorWayMonitor implements Subject {

    private int volumePerMinute = 0;
    private int speed = 0;
    private List<Observer> observers = new ArrayList<Observer>();

    public void setVolumePerMinute(int volumePerMinute) {
        this.volumePerMinute = volumePerMinute;
        notifyObservers();
    }

    public void setSpeed(int speed) {
        this.speed = speed;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.updateTraffic(volumePerMinute, speed);
        }
    }
}
