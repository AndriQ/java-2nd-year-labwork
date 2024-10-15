package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class Task1ObvserverExist{
  final String file_name = "src/main/java/Observer.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
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