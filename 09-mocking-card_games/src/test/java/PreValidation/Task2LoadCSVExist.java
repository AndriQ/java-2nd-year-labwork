package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class Task2LoadCSVExist{
  final String file_name = "src/main/java/game/LoadCSV.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void setCSVReaderReturnsVoid(){
    assertEquals("void", javaFile.getMethodByName("setCSVReader").getReturnType());
  }

  @Test
  void setCSVReaderHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("Scanner");
    correctParams.add("String");
    assertEquals(correctParams, javaFile.getMethodByName("setCSVReader").getInputParameterType());
  }

  @Test
  void getCSVRowsReturnsList(){
    assertEquals("List", javaFile.getMethodByName("getCSVRows").getReturnType());
  }

  @Test
  void getCSVRowsHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("String");
    assertEquals(correctParams, javaFile.getMethodByName("getCSVRows").getInputParameterType());
  }

}