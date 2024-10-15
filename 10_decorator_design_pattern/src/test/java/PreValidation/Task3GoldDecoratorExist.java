package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class Task3GoldDecoratorExist{
  final String file_name = "src/main/java/GoldDecorator.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void GoldDecoratorReturnsGolddecorator(){
    assertEquals("GoldDecorator", javaFile.getMethodByName("GoldDecorator").getReturnType());
  }

  @Test
  void GoldDecoratorHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("LevelGenerator");
    assertEquals(correctParams, javaFile.getMethodByName("GoldDecorator").getInputParameterType());
  }

}