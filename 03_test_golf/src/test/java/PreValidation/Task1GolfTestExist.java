package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class Task1GolfTestExist{
  final String file_name = "src/test/java/game/card/game/Golf/GolfTest.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void testHasBestScoreWithNegativeExist(){
    assertTrue(javaFile.hasMethodByName("testHasBestScoreWithNegative"));
  }

  @Test
  void testHasBestScorePositiveExist(){
    assertTrue(javaFile.hasMethodByName("testHasBestScorePositive"));
  }

  @Test
  void testHasBestScoreNegativeExist(){
    assertTrue(javaFile.hasMethodByName("testHasBestScoreNegative"));
  }

  @Test
  void testScoreHandQueenKingExist(){
    assertTrue(javaFile.hasMethodByName("testScoreHandQueenKing"));
  }

  @Test
  void testScoreHandTenFiveExist(){
    assertTrue(javaFile.hasMethodByName("testScoreHandTenFive"));
  }

  @Test
  void testScoreHandQueenAceExist(){
    assertTrue(javaFile.hasMethodByName("testScoreHandQueenAce"));
  }

  @Test
  void testScoreHandQueenTwoExist(){
    assertTrue(javaFile.hasMethodByName("testScoreHandQueenTwo"));
  }

  @Test
  void testScoreHandQueenQueenExist(){
    assertTrue(javaFile.hasMethodByName("testScoreHandQueenQueen"));
  }

  @Test
  void testReplaceCardFirstExist(){
    assertTrue(javaFile.hasMethodByName("testReplaceCardFirst"));
  }

  @Test
  void testReplaceCardSecondExist(){
    assertTrue(javaFile.hasMethodByName("testReplaceCardSecond"));
  }

  @Test
  void testCompareCardWithHandExist(){
    assertTrue(javaFile.hasMethodByName("testCompareCardWithHand"));
  }

  @Test
  void testCompareCardWithHandToStringExist(){
    assertTrue(javaFile.hasMethodByName("testCompareCardWithHandToString"));
  }

  @Test
  void testCompareCardWithHandNegativeExist(){
    assertTrue(javaFile.hasMethodByName("testCompareCardWithHandNegative"));
  }

  @Test
  void testCompareCardWithHandNegativeToStringExist(){
    assertTrue(javaFile.hasMethodByName("testCompareCardWithHandNegativeToString"));
  }

  @Test
  void testCompareCardForPlayerNegativeExist(){
    assertTrue(javaFile.hasMethodByName("testCompareCardForPlayerNegative"));
  }

  @Test
  void testCompareCardForPlayerNegativeToStringExist(){
    assertTrue(javaFile.hasMethodByName("testCompareCardForPlayerNegativeToString"));
  }

  @Test
  void testCompareCardForPlayerExist(){
    assertTrue(javaFile.hasMethodByName("testCompareCardForPlayer"));
  }

  @Test
  void testCompareCardForPlayerToStringExist(){
    assertTrue(javaFile.hasMethodByName("testCompareCardForPlayerToString"));
  }

  @Test
  void testComputerPlayBasicDiscardExist(){
    assertTrue(javaFile.hasMethodByName("testComputerPlayBasicDiscard"));
  }

  @Test
  void testComputerPlayBasicDeckExist(){
    assertTrue(javaFile.hasMethodByName("testComputerPlayBasicDeck"));
  }

}