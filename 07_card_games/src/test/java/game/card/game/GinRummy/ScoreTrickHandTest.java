package game.card.game.GinRummy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;

import game.card.entity.Hand;
import game.card.entity.FaceCard;

public class ScoreTrickHandTest {
    
    Hand hand = new Hand("C7,C3,D8,D7,D3");
    ScoreTrickHand scoreTrickHand = new ScoreTrickHand();

    @Test
    void testGetSameFaceCardTwoPairs(){
        HashMap<FaceCard, Hand> result = scoreTrickHand.getSameFaceCards(hand);
        assertEquals(2, result.size());
    }

    @Test
    void testGetSameFaceCardArePairs(){
        HashMap<FaceCard, Hand> result = scoreTrickHand.getSameFaceCards(hand);
        assertEquals(2, result.get(FaceCard.THREE).size());
    }

    @Test
    void testGetSameFaceCardAreFourOfAKind(){
        Hand hand = new Hand("C7,S7,H7,D7,D3");
        HashMap<FaceCard, Hand> result = scoreTrickHand.getSameFaceCards(hand);
        assertEquals(4, result.get(FaceCard.SEVEN).size());
    }

    @Test
    void testGetSameFaceCardAreFourOfAKindString(){
        Hand hand = new Hand("C7,S7,H7,D7,D3");
        HashMap<FaceCard, Hand> result = scoreTrickHand.getSameFaceCards(hand);
        assertEquals("C7, S7, H7, D7", result.get(FaceCard.SEVEN).toString());
    }

    @Test
    void testGetStraightSameSuitFive(){
        Hand hand = new Hand("C7,C6,C4,C5,C8");
        List<Hand> result = scoreTrickHand.getStraightSameSuit(hand);
        assertEquals(1, result.size());
        assertEquals("[C4, C5, C6, C7, C8]", result.toString());
    }
    
    @Test
    void testGetStraightSameSuitTwoHands(){
        hand = new Hand("C7,C6,D4,H5,H6");
        List<Hand> result = scoreTrickHand.getStraightSameSuit(hand);
        assertEquals(2, result.size());
    }

    @Test
    void testGetStraightSameSuitTwoHandsToString(){
        hand = new Hand("C7,C6,D4,H5,H6");
        List<Hand> result = scoreTrickHand.getStraightSameSuit(hand);
        assertEquals("[C6, C7, H5, H6]", result.toString());
    }
    
}
