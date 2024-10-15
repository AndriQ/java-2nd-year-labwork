package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class Task1BayLevelExist{
  final String file_name = "src/main/java/BayLevel.java";
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
  void BayLevelReturnsBaylevel(){
    assertEquals("BayLevel", javaFile.getMethodByName("BayLevel").getReturnType());
  }

}