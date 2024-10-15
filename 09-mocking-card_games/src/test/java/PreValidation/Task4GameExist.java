package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class Task4GameExist{
  final String file_name = "src/main/java/game/Game.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void setInOutReturnsVoid(){
    assertEquals("void", javaFile.getMethodByName("setInOut").getReturnType());
  }

  @Test
  void setInOutHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("InOutInterface");
    assertEquals(correctParams, javaFile.getMethodByName("setInOut").getInputParameterType());
  }

  @Test
  void setLoadScannerReturnsVoid(){
    assertEquals("void", javaFile.getMethodByName("setLoadScanner").getReturnType());
  }

  @Test
  void setLoadScannerHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("Scanner");
    correctParams.add("String");
    assertEquals(correctParams, javaFile.getMethodByName("setLoadScanner").getInputParameterType());
  }

  @Test
  void getCompupterPlayersNamesReturnsHashmap(){
    assertEquals("HashMap", javaFile.getMethodByName("getComputerPlayersNames").getReturnType());
  }

  @Test
  void createComputerCompetitorsReturnsVoid(){
    assertEquals("void", javaFile.getMethodByName("createComputerCompetitors").getReturnType());
  }

  @Test
  void createComputerCompetitorsHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("int");
    assertEquals(correctParams, javaFile.getMethodByName("createComputerCompetitors").getInputParameterType());
  }

  @Test
  void getPlayerReturnsPlayer(){
    assertEquals("Player", javaFile.getMethodByName("getPlayer").getReturnType());
  }

  @Test
  void getPlayerHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("int");
    assertEquals(correctParams, javaFile.getMethodByName("getPlayer").getInputParameterType());
  }

  @Test
  void getInputIntegerReturnsInt(){
    assertEquals("int", javaFile.getMethodByName("getInputInteger").getReturnType());
  }

  @Test
  void getInputIntegerHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("String");
    assertEquals(correctParams, javaFile.getMethodByName("getInputInteger").getInputParameterType());
  }

  @Test
  void getInputStringReturnsString(){
    assertEquals("String", javaFile.getMethodByName("getInputString").getReturnType());
  }

  @Test
  void getInputStringHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("String");
    assertEquals(correctParams, javaFile.getMethodByName("getInputString").getInputParameterType());
  }

  @Test
  void getNumberOfPlayersReturnsInt(){
    assertEquals("int", javaFile.getMethodByName("getNumberOfPlayers").getReturnType());
  }

  @Test
  void initiatePlayersReturnsVoid(){
    assertEquals("void", javaFile.getMethodByName("initiatePlayers").getReturnType());
  }

  @Test
  void getPlayersSizeReturnsInt(){
    assertEquals("int", javaFile.getMethodByName("getPlayersSize").getReturnType());
  }

}