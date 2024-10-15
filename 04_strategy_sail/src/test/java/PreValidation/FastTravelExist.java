package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class FastTravelExist{
  final String file_name = "src/main/java//FastTravel.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void travelExist(){
    assertTrue(javaFile.hasMethodByName("travel"));
  }

}