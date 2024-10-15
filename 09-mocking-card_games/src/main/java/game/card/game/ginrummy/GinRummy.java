package game.card.game.ginrummy;

import java.util.List;
import java.util.HashMap;

import game.Player;
import game.card.CardGame;
import game.card.entity.Card;
import game.card.entity.FaceCard;
import game.card.entity.Hand;


public class GinRummy extends CardGame {

    protected static int noOfCards = 7;

    ScoreTrickHand scoreTrickHand = new ScoreTrickHand();

    public GinRummy(String override){
        super(override);
    }

    public GinRummy(){
        this("");
    }

    protected void discardCard(Player player){
        Card card = getPlayersCard(player);
        addToDiscarded(card);
    }

    protected void userPlays(Player competitor){
        competitor.addCard(playerSelectCard(competitor, deck));
        discardCard(competitor);
    }

    protected Card removeWeakestCard(Hand hand){
        int currentScore = scoreHand(hand);
        boolean found = false;
        Card card = null;
        int counter = 0;
        while (counter < hand.size() && !found){
            card = hand.playACard(counter);
            if (currentScore == scoreHand(hand)){
                found = true;
            } else {
                hand.add(card);
            }
            counter ++;
        }
        return card;
    }

    protected Card scoreWithCard(Hand hand, Card card){
        
        int currentScore = scoreHand(hand);
        hand.add(card);
        if (currentScore == scoreHand(hand)){
            hand.remove(card);
        } else {
            card = removeWeakestCard(hand);
        }
        return card;
    }

    protected void computerPlays(Player player){
        Hand hand = player.getHand();
        
        Card card = discardPile.getLastCard();
        Card removedCard = scoreWithCard(hand, card);
        if (card == removedCard) {
            card = deck.playACard();
            card = scoreWithCard(hand, card);
        }
        discardPile.add(card);
    }

    public int scoreHand(Hand hand){
        int maxFaceCard = maxSameFaceCardSize(hand);
        int maxStraight = maxStraightSuitSize(hand);
        return maxFaceCard + maxStraight;
    }

    protected void beforeInitiate(){
        setNoOfCards(noOfCards);
    }

    protected void afterInitiate(){
        Player leftOfDealer = getPlayer(1);
        leftOfDealer.addCard(deck.playACard());
        discardCard(leftOfDealer);
    }

    protected int maxStraightSuitSize(Hand hand){
        int score = 0;
        List<Hand> straightSuitHands = scoreTrickHand.getStraightSameSuit(hand);
        for (Hand straightHand : straightSuitHands){
            if (straightHand.size() > score){
                score = straightHand.size();
            }
        }
        return score;
    }

    protected int maxSameFaceCardSize(Hand hand){
        int score = 0;
        HashMap<FaceCard, Hand> sameFaceCards = scoreTrickHand.getSameFaceCards(hand);
        for (FaceCard facecard : sameFaceCards.keySet()){
            if (score < sameFaceCards.get(facecard).size()){
                score = sameFaceCards.get(facecard).size();
            }
        }

        return score;
    }

    protected void afterPlayerPlays(Player player){
        if (scoreHand(player.getHand()) >= noOfCards){
            player.setWinner(true);
        }

    }

    
    public static void main(String[] args){
        GinRummy ginRummy = new GinRummy();
        ginRummy.play();
    }


    
}
