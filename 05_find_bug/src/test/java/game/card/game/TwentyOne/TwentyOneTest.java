package game.card.game.TwentyOne;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import game.card.entity.Hand;

public class TwentyOneTest {


    TwentyOne twentyOne = new TwentyOne();

    @Test
    void getScoreAceHigh() {
        Hand hand = new Hand("DA,D2");
        assertEquals(13,twentyOne.getScore(hand));
    }

    @Test
    void getScoreAceLow() {
        Hand hand = new Hand("DA,D2,CK");
        assertEquals(13,twentyOne.getScore(hand));
    }
    
}
