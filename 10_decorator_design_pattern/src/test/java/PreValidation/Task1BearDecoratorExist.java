package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class Task1BearDecoratorExist{
  final String file_name = "src/main/java/BearDecorator.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void generateLevelReturnsString(){
    assertEquals("String", javaFile.getMethodByName("generateLevel").getReturnType());
  }

  @Test
  void BearDecoratorReturnsBeardecorator(){
    assertEquals("BearDecorator", javaFile.getMethodByName("BearDecorator").getReturnType());
  }

  @Test
  void BearDecoratorHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("LevelGenerator");
    assertEquals(correctParams, javaFile.getMethodByName("BearDecorator").getInputParameterType());
  }

}