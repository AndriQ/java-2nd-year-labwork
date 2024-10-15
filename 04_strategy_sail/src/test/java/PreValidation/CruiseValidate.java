package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class CruiseValidate{
  final String file_name = "src/main/java//Cruise.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void cruiseContainsAll(){
    String[] patterns = {"public","TravelBehaviour","MaintenanceBehaviour"};
    assertTrue(javaFile.getMethodByName("Cruise").containsAll(patterns));
  }

}