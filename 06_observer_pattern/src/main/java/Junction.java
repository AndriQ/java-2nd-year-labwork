public class Junction implements Observer {

    public final static int MAXSPEED = 70;
    
    protected int volumePerMinute = 0;
    protected float rain = 0;
    protected float windSpeed = 0;
    protected int number = 0;
    
    protected int windSpeedLimit = 30;
    protected int windSpeedReduction = 10;
    protected int rainLimit = 20;
    protected int rainReduction = 5;
    
    protected int weatherSpeed = MAXSPEED;
    protected int motorwayDisplaySpeed = MAXSPEED;
    protected int speedAtNextJunction = MAXSPEED;

    public Junction(int number, WeatherData weatherData){
        this.number = number;
        weatherData.registerObserver(this);
        rain = weatherData.getRain();
        windSpeed = weatherData.getWindSpeed();
    }

    public void updateTraffic(int volumePerMinute, int speed) {
        this.volumePerMinute = volumePerMinute;
        this.speedAtNextJunction = speed;
        setMotorwayDisplaySpeed();
        display();
    }

    public void updateWeather(float rain, float windSpeed) {
        this.rain = rain;
        this.windSpeed = windSpeed;
        setMotorwayDisplaySpeed();
        display();
    }

    protected int getWeatherSpeed() {
        if (windSpeed > windSpeedLimit) {
            weatherSpeed -= windSpeedReduction;
        } 
        
        if (rain > rainLimit) {
            weatherSpeed -= rainReduction;
        }

        return weatherSpeed;
    }

    protected void setMotorwayDisplaySpeed() {
        if (speedAtNextJunction < motorwayDisplaySpeed) {
            motorwayDisplaySpeed = speedAtNextJunction;
        }

        if (weatherSpeed < motorwayDisplaySpeed) {
            motorwayDisplaySpeed = weatherSpeed;
        }
    }

    public void display() {
        System.out.println(toString());
    }

    public String toString(){
        return number + " at speed " + motorwayDisplaySpeed;
    }

    
}
