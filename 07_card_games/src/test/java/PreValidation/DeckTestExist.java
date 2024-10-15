package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class DeckTestExist{
  final String file_name = "src/test/java/game/card/entity/DeckTest.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void generateDeckExist(){
    assertTrue(javaFile.hasMethodByName("generateDeck"));
  }

  @Test
  void playACardExist(){
    assertTrue(javaFile.hasMethodByName("playACard"));
  }


}