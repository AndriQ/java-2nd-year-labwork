public interface Observer {
    
    public void updateWeather(float rain, float windSpeed);

    public void updateTraffic(int volumePerMinute, int speedAtNextJunction);

    public void display();

}
