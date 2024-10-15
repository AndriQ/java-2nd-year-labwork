import java.util.List;
import java.util.ArrayList;

public class Motorway{

    private String name; 
    private List<Junction> junctions = new ArrayList<Junction>();
    private List<MotorWayMonitor> monitors = new ArrayList<MotorWayMonitor>();

    public Motorway(String name){
        this.name = name;
    }

    public void add(Junction junction, MotorWayMonitor monitor){
        junctions.add(junction);
        monitors.add(monitor);
        if (junctions.size() > 0){
            monitor.registerObserver(junction);
        }
    }

    public String getName() {
        return name;
    }

    public List<Junction> getJunctions() {
        return junctions;
    }

    public List<MotorWayMonitor> getMonitors() {
        return monitors;
    }

    public static void main(String[] args){
        Motorway motorway = new Motorway("M8");
        WeatherData weatherData = new WeatherData();
        WeatherData secondWeatherData = new WeatherData();
        for (int counter = 0; counter < 10; counter++){
            if (counter == 5){
                weatherData = secondWeatherData;
            }
            motorway.add(new Junction(counter, weatherData), new MotorWayMonitor());
        }
        weatherData.setRain(30);
        motorway.getMonitors().get(6).setSpeed(30);
        secondWeatherData.setWindSpeed(40);
        
    }



}