package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class CruiseExist{
  final String file_name = "src/main/java//Cruise.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void cruiseExist(){
    assertTrue(javaFile.hasMethodByName("Cruise"));
  }

}