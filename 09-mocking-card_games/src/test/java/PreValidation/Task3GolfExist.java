package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class Task3GolfExist{
  final String file_name = "src/main/java/game/card/game/golf/Golf.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void GolfReturnsGolf(){
    assertEquals("Golf", javaFile.getMethodByName("Golf").getReturnType());
  }

  @Test
  void GolfHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("String");
    assertEquals(correctParams, javaFile.getMethodByName("Golf").getInputParameterType());
  }

  @Test
  void checkIfKnockReturnsVoid(){
    assertEquals("void", javaFile.getMethodByName("checkIfKnock").getReturnType());
  }

  @Test
  void checkIfKnockHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("Player");
    assertEquals(correctParams, javaFile.getMethodByName("checkIfKnock").getInputParameterType());
  }

  @Test
  void makeUserCardsVisibleReturnsVoid(){
    assertEquals("void", javaFile.getMethodByName("makeUserCardsVisible").getReturnType());
  }

  @Test
  void makeUserCardsVisibleHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("Player");
    assertEquals(correctParams, javaFile.getMethodByName("makeUserCardsVisible").getInputParameterType());
  }

}