package game.card.game.GinRummy;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import game.Player;
import game.card.CardGame;
import game.card.entity.Card;
import game.card.entity.FaceCard;
import game.card.entity.Hand;


public class GinRummy extends CardGame {

    protected static int noOfCards = 7;

    ScoreTrickHand scoreTrickHand = new ScoreTrickHand();

    public GinRummy() {
        super();
    }

    public GinRummy(String override) {
        super(override);
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
        Card weakestCard = null;
        List<Card> handOfCards = new ArrayList<>();
        handOfCards.addAll(hand.getHandOfCards());
        for (Card card : handOfCards) {
            hand.remove(card);
            int newScore = scoreHand(hand);
            hand.add(card);
            if (newScore == currentScore) {
                weakestCard = card;
                break;
            }
        }
        return weakestCard;
    }

    protected Card scoreWithCard(Hand hand, Card card){
        int currentScore = scoreHand(hand);
        hand.add(card);
        int newScore = scoreHand(hand);
        hand.remove(card);
        return (newScore == currentScore) ? card : removeWeakestCard(hand);
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
        int maxFaceCardSize = maxSameFaceCardSize(hand);
        int maxStraightSuitSize = maxStraightSuitSize(hand);
        return maxFaceCardSize + maxStraightSuitSize;
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
        List<Hand> straightHands = scoreTrickHand.getStraightSameSuit(hand);
        for (Hand straightHand : straightHands) {
            score = Math.max(score, straightHand.size());
        }
        return score;
    }

    protected int maxSameFaceCardSize(Hand hand){
        int score = 0;
        HashMap<FaceCard, Hand> sameFaceCards = scoreTrickHand.getSameFaceCards(hand);
        for (Hand sameFaceHand : sameFaceCards.values()) {
            score = Math.max(score, sameFaceHand.size());
        }
        return score;
    }

    protected void afterPlayerPlays(Player player){
        int handScore = scoreHand(player.getHand());
        if (handScore >= noOfCards) {
            player.setWinner(true);
            System.out.println(player.getName() + " won the game.");
        }
    }

    public static void main(String[] args){
        GinRummy ginRummy = new GinRummy();
        ginRummy.play();
    }
    


}
