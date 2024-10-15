package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class Task3JunctionExist{
  final String file_name = "src/main/java/Junction.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void JunctionHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("int");
    correctParams.add("WeatherData");
    assertEquals(correctParams, javaFile.getMethodByName("Junction").getInputParameterType());
  }

  @Test
  void updateWeatherReturnsVoid(){
    assertEquals("void", javaFile.getMethodByName("updateWeather").getReturnType());
  }

  @Test
  void updateWeatherHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("float");
    correctParams.add("float");
    assertEquals(correctParams, javaFile.getMethodByName("updateWeather").getInputParameterType());
  }

  @Test
  void getWeatherSpeedReturnsInt(){
    assertEquals("int", javaFile.getMethodByName("getWeatherSpeed").getReturnType());
  }

  @Test
  void getWeatherSpeedHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    assertEquals(correctParams, javaFile.getMethodByName("getWeatherSpeed").getInputParameterType());
  }

  @Test
  void setMotorwayDisplaySpeedReturnsVoid(){
    assertEquals("void", javaFile.getMethodByName("setMotorwayDisplaySpeed").getReturnType());
  }

  @Test
  void setMotorwayDisplaySpeedHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    assertEquals(correctParams, javaFile.getMethodByName("setMotorwayDisplaySpeed").getInputParameterType());
  }





  @Test
  void updateTrafficReturnsVoid(){
    assertEquals("void", javaFile.getMethodByName("updateTraffic").getReturnType());
  }

  @Test
  void updateTrafficHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("int");
    correctParams.add("int");
    assertEquals(correctParams, javaFile.getMethodByName("updateTraffic").getInputParameterType());
  }

}