package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class Task3PlayerExist{
  final String file_name = "src/main/java/game/Player.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void hasWonReturnsBoolean(){
    assertEquals("boolean", javaFile.getMethodByName("hasWon").getReturnType());
  }

  @Test
  void displayHandWithVisibilityReturnsString(){
    assertEquals("String", javaFile.getMethodByName("displayHandWithVisibility").getReturnType());
  }

}