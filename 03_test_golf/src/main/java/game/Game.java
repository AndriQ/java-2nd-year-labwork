package game;
import java.util.ArrayList;
import java.util.List;

import communication.ConsoleInOut;
import communication.InOutInterface;
import communication.SelectFromList;
import game.card.entity.CompetitorType;
import game.card.entity.Suit;


public abstract class Game <ExtendedENum extends Enum<ExtendedENum>> {

    protected static int winningScore = 0;
    public static String askName = "What is your name";
    public static String numberOfCompetitors = "How many competitors, minimum of two?";

    protected InOutInterface inOut = new ConsoleInOut();
    private List<Player> players = new ArrayList<Player>();
    protected boolean finishGame = false;
    protected Class<ExtendedENum> helpClass = null;
    
    public void setInOut(InOutInterface inOut){
        this.inOut = inOut;
    }

    protected void setFinishGame(boolean finshGame) {
        this.finishGame = finshGame;
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public List<Player> getPlayers(){
        return players;
    }

    public boolean getFinishGame(){
        return finishGame;
    }

    public int getPlayersSize(){
        return players.size();
    }

    public void clearPlayers(){
        players.clear();
    }

    protected void print(String message) {
        inOut.print(message);
    }

    protected ExtendedENum generateHelp() {
        return inOut.getEnumIndex("", helpClass);
    }

    protected String getInputString(String message) {
        return inOut.getInputString(message);
    }

    protected int getInputInteger(String message) {
        return inOut.getInputInteger(message);
    }

    protected void displayPlayer(Player player){
        inOut.displayPlayer(player);
    }

    protected void displayPlayerWithVisibility(Player player){
        inOut.displayPlayerWithVisibility(player);
    }

    public void resetPlayers() {
        for (Player competitor : players) {
            competitor.setWinner(false);
        }
    }

    protected int getNumberOfPlayers(){
        return getInputInteger(numberOfCompetitors);
    }

    public Player createPlayer(CompetitorType competitorType, String name){
        Player player = new Player(competitorType, name);
        players.add(player);
        return player;
    }

    public void initiatePlayers() {
        players.clear();
        createHumanPlayer();
        createComputerCompetitors(getNumberOfPlayers() - 1);
    }

    protected void addPlayer(Player competitor) {
        players.add(competitor);
    }


    public void createHumanPlayer(){
        String name = getInputString(askName);
        addPlayer(new Player(CompetitorType.USER, name));
    }

    public abstract void createComputerCompetitors(int noOfComputerPlayers);

    protected boolean hasPlayerWon(Player competitor) {
        boolean aPlayerHasWon = false;
        return aPlayerHasWon;
    }

    public abstract int getScore(Player player);

    protected boolean hasBestScore(int bestScore, int currentScore) {
        boolean hasWon = false;
        if (bestScore < 0 || currentScore > bestScore) {
            hasWon = true;
        }
        return hasWon;
    }

    public Player determineWinner(List<Player> competitors){
        winningScore = -1;
        Player winningPlayer = null;
        int currentScore = 0;
        for (Player player : players){
            currentScore = getScore(player);
            if (hasBestScore(winningScore, currentScore) || hasPlayerWon(player)) {
                winningScore = currentScore;
                winningPlayer = player;
            }
            player.setScore(currentScore);
        }
        winningPlayer.setWinner(true);
        return winningPlayer;
    }

    protected abstract void beforePlayOfRound();

    protected abstract void afterPlayOfRound();

    protected abstract void userPlays(Player competitor);

    protected abstract void computerPlays(Player competitor);

    protected void playerPlaysHand(Player competitor) {
        if (competitor.getCompetitorType() == CompetitorType.USER) {
            userPlays(competitor);
        } else {
            computerPlays(competitor);
        }
    }

    protected void playARound() {
        int counter = 0;
        Player player = null;
        do {
            player = players.get(counter);
            playerPlaysHand(player);
            counter ++;
        } while (counter < players.size() && !player.hasWon());
    }

    protected void showPlayers() {
        for (Player player : players) {
            displayPlayerWithVisibility(player);
        }
    }

    protected abstract void initiate();

    protected void playTillFinish(){
        while (!finishGame) {
            beforePlayOfRound();
            playARound();
            afterPlayOfRound();
        }
    }

    protected void play() {
        initiate();
        playTillFinish();
        resetPlayers();
        Player winner = determineWinner(players);
        winner.setWinner(true);
        showPlayers();
    }

}
