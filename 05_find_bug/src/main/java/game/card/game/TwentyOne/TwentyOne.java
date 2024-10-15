package game.card.game.TwentyOne;

import java.util.ArrayList;

import game.Player;
import game.card.CardGame;
import game.card.entity.Card;
import game.card.entity.Hand;
import game.card.entity.FaceCard;

public class TwentyOne extends CardGame {
    private int maxScore = 21;

    protected TwentyOneAction getPlayerAction(Player player){
        if (player.hasHand()) {
            print(player.getHand().toString());
        }
        TwentyOneAction userAction = inOut.getEnumIndex(TwentyOneAction.class);
        print("You chose " + userAction.display());
        return userAction;
    }

    protected void userPlays(Player player){
        TwentyOneAction userAction = TwentyOneAction.TWIST;

        while (getScore(player.getHand()) <= maxScore && userAction != TwentyOneAction.STICK){
            userAction = getPlayerAction(player);
            if (userAction == TwentyOneAction.TWIST){
                player.getHand().add(deck.playACard());
            }
        }
        setFinishGame(true);
    }

    protected void computerPlays(Player player){
        Hand hand = player.getHand();
        while (getScore(hand) <= player.getLevelOfRisk()){
            hand.add(deck.playACard());
        }
    }
    
    public int getScore(Hand hand){
        int score = 0;
        Boolean hasAnAce = false;
        for (Card card: hand.getHandOfCards()){
            if (card.getFaceCard() == FaceCard.ACE){
                hasAnAce = true;
            }
            score += card.getFaceCard().getValue();
        }
        if (score > maxScore && hasAnAce){
            score += 10;
        }
        return score;
    }

    protected Player determineWinner(ArrayList<Player> players){
        Integer winningScore = 0;
        Player winningPlayer = null;
        int currentScore = 0;
        for (Player player : players){
            currentScore = getScore(player.getHand());
            if (currentScore <= maxScore && currentScore > winningScore){
                winningPlayer = player;
                winningScore = currentScore;
            }
        }
        if (winningPlayer != null) {
            winningPlayer.setWinner(true);
        }
        return winningPlayer;
    }

    public static void main(String[ ] args) {
        TwentyOne twentyOne = new TwentyOne();
        twentyOne.play();
    }
}
