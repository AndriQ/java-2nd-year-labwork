package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class Task1PlayerExist{
  final String file_name = "src/main/java/game/Player.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void PlayerReturnsPlayer(){
    assertEquals("Player", javaFile.getMethodByName("Player").getReturnType());
  }

  @Test
  void PlayerHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("CompetitorType");
    correctParams.add("String");
    assertEquals(correctParams, javaFile.getMethodByName("Player").getInputParameterType());
  }

  @Test
  void addHandReturnsVoid(){
    assertEquals("void", javaFile.getMethodByName("addHand").getReturnType());
  }

  @Test
  void addHandHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("Hand");
    assertEquals(correctParams, javaFile.getMethodByName("addHand").getInputParameterType());
  }

}