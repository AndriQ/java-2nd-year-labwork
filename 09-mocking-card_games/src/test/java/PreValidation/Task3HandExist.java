package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class Task3HandExist{
  final String file_name = "src/main/java/game/card/entity/Hand.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void addReturnsVoid(){
    assertEquals("void", javaFile.getMethodByName("add").getReturnType());
  }

  @Test
  void addHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("Card");
    correctParams.add("Boolean");
    assertEquals(correctParams, javaFile.getMethodByName("add").getInputParameterType());
  }

}