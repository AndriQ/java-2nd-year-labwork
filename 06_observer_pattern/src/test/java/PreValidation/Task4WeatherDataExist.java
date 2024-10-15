package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class Task4WeatherDataExist{
  final String file_name = "src/main/java/WeatherData.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void registerObserverReturnsVoid(){
    assertEquals("void", javaFile.getMethodByName("registerObserver").getReturnType());
  }

  @Test
  void registerObserverHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("Observer");
    assertEquals(correctParams, javaFile.getMethodByName("registerObserver").getInputParameterType());
  }

  @Test
  void removeObserverReturnsVoid(){
    assertEquals("void", javaFile.getMethodByName("removeObserver").getReturnType());
  }

  @Test
  void removeObserverHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("Observer");
    assertEquals(correctParams, javaFile.getMethodByName("removeObserver").getInputParameterType());
  }

  @Test
  void notifyObserversReturnsVoid(){
    assertEquals("void", javaFile.getMethodByName("notifyObservers").getReturnType());
  }

  @Test
  void notifyObserversHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    assertEquals(correctParams, javaFile.getMethodByName("notifyObservers").getInputParameterType());
  }

  @Test
  void WeatherDataHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    assertEquals(correctParams, javaFile.getMethodByName("WeatherData").getInputParameterType());
  }

}