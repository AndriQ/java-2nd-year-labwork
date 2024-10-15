package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class ClipperValidate{
  final String file_name = "src/main/java//Clipper.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void clippersContainsAll(){
    String[] patterns = {"public","TravelBehaviour","MaintenanceBehaviour","super"};
    assertTrue(javaFile.getMethodByName("Clipper").containsAll(patterns));
  }

}