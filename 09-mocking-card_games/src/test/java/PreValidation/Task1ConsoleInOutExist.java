package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class Task1ConsoleInOutExist{
  final String file_name = "src/main/java/communication/ConsoleInOut.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void setScannerReturnsVoid(){
    assertEquals("void", javaFile.getMethodByName("setScanner").getReturnType());
  }

  @Test
  void setScannerHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("Scanner");
    assertEquals(correctParams, javaFile.getMethodByName("setScanner").getInputParameterType());
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
  void getIntegerReturnsInt(){
    assertEquals("int", javaFile.getMethodByName("getInteger").getReturnType());
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
  void getListIndexReturnsInt(){
    assertEquals("int", javaFile.getMethodByName("getListIndex").getReturnType());
  }

  @Test
  void getListIndexHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("List");
    assertEquals(correctParams, javaFile.getMethodByName("getListIndex").getInputParameterType());
  }

  @Test
  void getPlayersCardReturnsCard(){
    assertEquals("Card", javaFile.getMethodByName("getPlayersCard").getReturnType());
  }

  @Test
  void getPlayersCardHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("Player");
    assertEquals(correctParams, javaFile.getMethodByName("getPlayersCard").getInputParameterType());
  }

  @Test
  void getYesOrNoReturnsYesorno(){
    assertEquals("YesOrNo", javaFile.getMethodByName("getYesOrNo").getReturnType());
  }

  @Test
  void getYesOrNoHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("String");
    assertEquals(correctParams, javaFile.getMethodByName("getYesOrNo").getInputParameterType());
  }

}