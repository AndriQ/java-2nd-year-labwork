package game.card.game.ginrummy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import game.card.entity.Hand;
import game.card.game.ginrummy.GinRummy;
import game.card.entity.Card;
import game.card.entity.CompetitorType;
import game.Player;

public class GinRummyTest {

    GinRummy ginRummy = new GinRummy("D3,D4,D5,S3");

      @Test
    void testSnapOverride(){
        assertEquals(4, ginRummy.getDeck().size());
    }

    @Test
    void testSnapNoOverride(){
        GinRummy ginRummy = new GinRummy();
        assertEquals(52, ginRummy.getDeck().size());
    }

    @Test
    void testMaxSameFaceCardSize(){
        Hand hand = new Hand("D2,D3,S3,D4,D5,D9,SA");
        assertEquals(2, ginRummy.maxSameFaceCardSize(hand));
    }

    @Test
    void testMaxStraightSuitSize(){
        Hand hand = new Hand("D2,D3,S3,D4,D5,D9,SA");
        assertEquals(4, ginRummy.maxStraightSuitSize(hand));
    }

    @Test 
    void testScoreHand(){
        Hand hand = new Hand("D2,D3,S3,D4,D5,D9,SA");
        assertEquals(6, ginRummy.scoreHand(hand));

    }

    @Test
    void testScoreHandWin(){
        Hand hand = new Hand("D7,D2,S2,D4,D5,D6,S2");
        assertEquals(7, ginRummy.scoreHand(hand));
    }

    @Test
    void testRemoveWeakestCard(){
        Hand hand = new Hand("D2,D3,S3,D4,D5,D6,S9,SA");
        assertEquals("SA", ginRummy.removeWeakestCard(hand).toString());
    }

    @Test
    void testScoreWithCard(){
        Hand hand = new Hand("D2,D3,S3,D4,D5,D6,SA");
        Card card = new Card("S9");
        assertEquals(card, ginRummy.scoreWithCard(hand, card));
    }

    @Test
    void testAfterPlayerPlaysNotWon(){
        Hand hand = new Hand("D2,D3,S3,D4,D10,D6,SA");
        Player player = new Player(CompetitorType.USER, "Derek");
        player.addHand(hand);
        ginRummy.afterPlayerPlays(player);
        assertFalse(player.hasWon());
    }

    @Test
    void testAfterPlayerPlaysWon(){
        Hand hand = new Hand("D7,D2,S2,D4,D5,D6,H2");
        Player player = new Player(CompetitorType.USER, "Derek");
        player.addHand(hand);
        ginRummy.afterPlayerPlays(player);
        assertTrue(player.hasWon());
    }


}
