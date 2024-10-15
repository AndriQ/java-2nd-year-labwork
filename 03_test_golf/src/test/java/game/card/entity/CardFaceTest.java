package game.card.entity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardFaceTest {

    @Test
    void getValueAce() { assertEquals(11, CardFace.ACE.getValue());
    }

    @Test
    void getValueKing() { assertEquals(10, CardFace.KING.getValue());
    }

    @Test
    void getValueQueen() { assertEquals(10, CardFace.QUEEN.getValue());
    }

    @Test
    void getValueJack() { assertEquals(10, CardFace.JACK.getValue());
    }

    @Test
    void getValueTen() { assertEquals(10, CardFace.TEN.getValue());
    }

    @Test
    void getValueNine() { assertEquals(9, CardFace.NINE.getValue());
    }

    @Test
    void getRankTen() {
        assertEquals(10, CardFace.TEN.getRank());
    }

    @Test
    void displayCamelCase() {assertEquals("Three", CardFace.THREE.displayCamelCase());
    }

    @Test
    void shortDisplayTen() {
        assertEquals("10", CardFace.TEN.shortDisplay());
    }

    @Test
    void testToStringThree() { assertEquals("3", CardFace.THREE.toString());
    }

    @Test
    void testCardRankTwo(){
        assertEquals(CardFace.TWO, CardFace.getCardRank("2"));
    }
    @Test
    void testCardRankTen(){
        assertEquals(CardFace.TEN, CardFace.getCardRank("10"));
    }
    @Test
    void testCardRankJack(){
        assertEquals(CardFace.JACK, CardFace.getCardRank("J"));
    }
    @Test
    void testCardRankQueen(){
        assertEquals(CardFace.QUEEN, CardFace.getCardRank("Q"));
    }
    @Test
    void testCardRankKing(){
        assertEquals(CardFace.KING, CardFace.getCardRank("K"));
    }
    @Test
    void testCardRankAce(){
        assertEquals(CardFace.ACE, CardFace.getCardRank("A"));
    }
}