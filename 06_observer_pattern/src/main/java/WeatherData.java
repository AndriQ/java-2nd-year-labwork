import java.util.ArrayList;
import java.util.List;

class WeatherData implements Subject {
    private float rain;
    private float windSpeed;
    protected List<Observer> observers = new ArrayList<Observer>();
    
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
            observer.updateWeather(rain, windSpeed);
        }
    }

    public WeatherData(){
  
    }

    public void setRain(float rain){
        this.rain = rain;
        notifyObservers();
    }

    public float getRain(){
        return rain;
    }


    public void setWindSpeed(float windSpeed){
        this.windSpeed = windSpeed;
        notifyObservers();
    }

    public float getWindSpeed(){
        return windSpeed;
    }

    public String toString(){
        return "rain: " + rain;
    }

}
