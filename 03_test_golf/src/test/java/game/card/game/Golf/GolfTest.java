package game.card.game.Golf;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import game.card.entity.Hand;
import game.card.entity.Suit;
import game.card.entity.Card;
import game.card.entity.CardFace;
import game.card.entity.CompetitorType;
import game.Player;


public class GolfTest {

    Golf golf = new Golf();

    Card queenCard = new Card(Suit.SPADES, CardFace.QUEEN);
    Card queenCard2 = new Card(Suit.CLUBS, CardFace.QUEEN);
    Card twoCard = new Card(Suit.SPADES, CardFace.TWO);
    Card kingCard = new Card(Suit.SPADES, CardFace.JACK);
    Card aceCard = new Card(Suit.SPADES, CardFace.ACE);
    Card tenCard = new Card(Suit.SPADES, CardFace.TEN);
    Card fiveCard = new Card(Suit.SPADES, CardFace.FIVE);

    Card s5 = new Card(Suit.SPADES, CardFace.FIVE);
    Card s2 = new Card(Suit.SPADES, CardFace.TWO);
    Card sq = new Card(Suit.SPADES, CardFace.QUEEN);
    Card s3 = new Card(Suit.SPADES, CardFace.THREE);
    Card s6 = new Card(Suit.SPADES, CardFace.SIX);
    Card cq = new Card(Suit.CLUBS, CardFace.QUEEN);
    
    @Test
    void testHasBestScoreWithNegative(){
        int bestScore = -1;
        int currentScore = 5;

        boolean result = golf.hasBestScore(bestScore, currentScore);

        assertTrue(result);
    }

    @Test
    void testHasBestScorePositive(){
        int bestScore = 4;
        int currentScore = 3;

        boolean result = golf.hasBestScore(bestScore, currentScore);

        assertTrue(result);
    }

    @Test
    void testHasBestScoreNegative(){
        int bestScore = 2;
        int currentScore = 3;

        boolean result = golf.hasBestScore(bestScore, currentScore);

        assertFalse(result);
    }

    @Test
    void testScoreHandQueenKing(){
        Hand currentHand = new Hand();

        currentHand.add(queenCard);
        currentHand.add(kingCard);
    
        int result = golf.scoreHand(currentHand);

        assertEquals(result, 20);
    } 

    @Test
    void testScoreHandTenFive(){
        Hand currentHand = new Hand();

        currentHand.add(tenCard);
        currentHand.add(fiveCard);
    
        int result = golf.scoreHand(currentHand);
        int expectedScore = tenCard.getCardFace().getValue() + fiveCard.getCardFace().getValue();

        assertEquals(expectedScore, result);
    } 

    @Test
    void testScoreHandQueenAce(){
        Hand currentHand = new Hand();

        currentHand.add(queenCard);
        currentHand.add(aceCard);
    
        int result = golf.scoreHand(currentHand);

        assertEquals(result, 11);
    } 

    @Test
    void testScoreHandQueenTwo(){
        Hand currentHand = new Hand();

        currentHand.add(queenCard);
        currentHand.add(twoCard);
    
        int result = golf.scoreHand(currentHand);

        assertEquals(result, 8);
    } 

    @Test
    void testScoreHandQueenQueen(){
        Hand currentHand = new Hand();

        currentHand.add(queenCard);
        currentHand.add(queenCard2);
    
        int result = golf.scoreHand(currentHand);

        assertEquals(result, 0);
    }

    @Test
    void testReplaceCardFirst(){
        Hand currentHand = new Hand();
        currentHand.add(s2);
        currentHand.add(sq);

        golf.replaceCard(currentHand, cq, 0);

        assertEquals("CQ, SQ", currentHand.toString());
    }    
    
    @Test
    void testReplaceCardSecond(){
        Hand currentHand = new Hand();
        currentHand.add(sq);
        currentHand.add(s2);

        golf.replaceCard(currentHand, cq, 1);

        assertEquals("SQ, CQ", currentHand.toString());
    }

    @Test
    void testCompareCardWithHand(){
        Hand currentHand = new Hand();
        currentHand.add(sq);
        currentHand.add(s2);

        assertTrue(golf.compareCardWithHand(currentHand, cq));
    }

    @Test
    void testCompareCardWithHandToString() {
        Hand currentHand = new Hand();
        currentHand.add(sq);
        currentHand.add(s2);

        golf.compareCardWithHand(currentHand, cq);
        
        assertEquals("SQ, CQ", currentHand.toString());
    }

    @Test
    void testCompareCardWithHandNegative() {
        Hand currentHand = new Hand();
        currentHand.add(s5);
        currentHand.add(s2);

        assertFalse(golf.compareCardWithHand(currentHand, cq));
    }

    @Test
    void testCompareCardWithHandNegativeToString(){
        Hand currentHand = new Hand();
        currentHand.add(s5);
        currentHand.add(s2);

        golf.compareCardWithHand(currentHand, cq);

        assertEquals("S5, S2", currentHand.toString());
    }

    @Test
    void testCompareCardForPlayerNegative(){
        Hand handOne = new Hand();
        handOne.add(s5);
        handOne.add(s2);

        Hand handTwo = new Hand();
        handTwo.add(s6);
        handTwo.add(s3);

        Player player = new Player(null, null);
        player.addHand(handOne);
        player.addHand(handTwo);

        boolean matched = golf.compareCardForPlayer(player, cq);
        assertFalse(matched);
    }

    @Test
    void testCompareCardForPlayerNegativeToString(){
        Hand handOne = new Hand();
        handOne.add(s5);
        handOne.add(s2);

        Hand handTwo = new Hand();
        handTwo.add(s6);
        handTwo.add(s3);

        Player player = new Player(null, "Derek");
        player.addHand(handOne);
        player.addHand(handTwo);

        golf.compareCardForPlayer(player, cq);
        assertEquals("S5, S2", player.getHand(0).toString());
        assertEquals("S6, S3", player.getHand(1).toString());
    }

    @Test
    void testCompareCardForPlayer(){
        Hand handOne = new Hand();
        handOne.add(s5);
        handOne.add(s2);

        Hand handTwo = new Hand();
        handTwo.add(sq);
        handTwo.add(s3);

        Player player = new Player(null, null);
        player.addHand(handOne);
        player.addHand(handTwo);

        boolean matched = golf.compareCardForPlayer(player, cq);
        assertTrue(matched);
    }

    @Test
    void testCompareCardForPlayerToString(){
        Hand handOne = new Hand();
        handOne.add(s5);
        handOne.add(s2);

        Hand handTwo = new Hand();
        handTwo.add(sq);
        handTwo.add(s3);

        Player player = new Player(null, null);
        player.addHand(handOne);
        player.addHand(handTwo);

        golf.compareCardForPlayer(player, cq);
        assertEquals("S5, S2", player.getHand(0).toString());
        assertEquals("SQ, CQ", player.getHand(1).toString());
    }

    @Test
    void testComputerPlayBasicDiscard() {
        Golf golf = new Golf("S5, S9");

        golf.discardPile.add(cq);

        Player user = new Player(null, null);
        Hand userHand1 = new Hand();
        userHand1.add(s5);
        userHand1.add(s2);
        user.addHand(userHand1);

        Hand userHand2 = new Hand();
        userHand2.add(sq);
        userHand2.add(s3);
        user.addHand(userHand2);

        golf.computerPlayBasic(user);
        assertEquals("S5, S2", user.getHand(0).toString());
        assertEquals("SQ, CQ", user.getHand(1).toString());
    }

    @Test
    void testComputerPlayBasicDeck() {
        Golf golf = new Golf("S5, CQ");

        Card c9 = new Card(Suit.CLUBS, CardFace.NINE);
        golf.discardPile.add(c9);
      
        Player user = new Player(null, null);
        Hand userHand1 = new Hand();
        userHand1.add(s5);
        userHand1.add(s2);
        user.addHand(userHand1);

        Hand userHand2 = new Hand();
        userHand2.add(sq);
        userHand2.add(s3);
        user.addHand(userHand2);

        golf.computerPlayBasic(user);
        assertEquals("S5, S2", user.getHand(0).toString());
        assertEquals("SQ, S3", user.getHand(1).toString());
    }


}
