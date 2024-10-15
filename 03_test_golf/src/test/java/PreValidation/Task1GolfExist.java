package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class Task1GolfExist{
  final String file_name = "src/main/java/game/card/game/Golf/Golf.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void hasBestScoreReturnsBoolean(){
    assertEquals(javaFile.getMethodByName("hasBestScore").getReturnType(),"boolean");
  }

  @Test
  void hasBestScoreHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("int");
    correctParams.add("int");
    assertEquals(correctParams, javaFile.getMethodByName("hasBestScore").getInputParameterType());
  }

  @Test
  void scoreHandReturnsInt(){
    assertEquals(javaFile.getMethodByName("scoreHand").getReturnType(),"int");
  }

  @Test
  void scoreHandHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("Hand");
    assertEquals(correctParams, javaFile.getMethodByName("scoreHand").getInputParameterType());
  }

  @Test
  void replaceCardReturnsVoid(){
    assertEquals(javaFile.getMethodByName("replaceCard").getReturnType(),"void");
  }

  @Test
  void replaceCardHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("Hand");
    correctParams.add("Card");
    correctParams.add("int");
    assertEquals(correctParams, javaFile.getMethodByName("replaceCard").getInputParameterType());
  }

  @Test
  void compareCardWithHandReturnsBoolean(){
    assertEquals(javaFile.getMethodByName("compareCardWithHand").getReturnType(),"boolean");
  }

  @Test
  void compareCardWithHandHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("Hand");
    correctParams.add("Card");
    assertEquals(correctParams, javaFile.getMethodByName("compareCardWithHand").getInputParameterType());
  }

  @Test
  void compareCardForPlayerReturnsBoolean(){
    assertEquals(javaFile.getMethodByName("compareCardForPlayer").getReturnType(),"boolean");
  }

  @Test
  void compareCardForPlayerHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("Player");
    correctParams.add("Card");
    assertEquals(correctParams, javaFile.getMethodByName("compareCardForPlayer").getInputParameterType());
  }

  @Test
  void computerPlayBasicReturnsVoid(){
    assertEquals(javaFile.getMethodByName("computerPlayBasic").getReturnType(),"void");
  }

  @Test
  void computerPlayBasicHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("Player");
    assertEquals(correctParams, javaFile.getMethodByName("computerPlayBasic").getInputParameterType());
  }

}