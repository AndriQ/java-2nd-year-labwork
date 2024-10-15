package game.card.game.ginrummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import game.card.entity.Hand;
import game.card.entity.Card;
import game.card.entity.FaceCard;

public class ScoreTrickHand {  

    protected List<Hand> getStraightSameSuit(Hand hand) {
        List<Hand> straightHands = new ArrayList<Hand>();
        Hand straightHand = new Hand();
        hand.sortHand();;
        Card previousCard = null;
        for (Card cardNext : hand.getHandOfCards()) {
            if (previousCard != null && previousCard.getSuit() == cardNext.getSuit() &&
            previousCard.getFaceCard().ordinal() == cardNext.getFaceCard().ordinal() -1) {
                if (!straightHand.getHandOfCards().contains(previousCard)){
                    straightHand.add(previousCard);
                }
                straightHand.add(cardNext);
            } else {
                if (straightHand.size() > 0){
                    straightHands.add(straightHand);
                    straightHand = new Hand();
                }
            }
            previousCard = cardNext;
        }
        if (straightHand.size() > 0){
            straightHands.add(straightHand);
        }
        return straightHands;
    }

    protected HashMap<FaceCard, Hand> getSameFaceCards(Hand hand) {
        HashMap<FaceCard, Hand> sameFaceCards = new HashMap<FaceCard, Hand>();
        hand.sortHandByFace();;
        Card previousCard = null;
        for (Card cardNext : hand.getHandOfCards()) {
            if (previousCard != null && previousCard.getFaceCard() == cardNext.getFaceCard()) {
                if (!sameFaceCards.containsKey(previousCard.getFaceCard())) {
                    sameFaceCards.put(previousCard.getFaceCard(), new Hand());
                    sameFaceCards.get(previousCard.getFaceCard()).add(previousCard);
                }
                sameFaceCards.get(cardNext.getFaceCard()).add(cardNext);
            }
            previousCard = cardNext;
        }
        return sameFaceCards;
    }

}
