import java.util.*;

class RockPaperScissor {

    private Scanner userInput = new Scanner(System.in);
    private List<String> configuration;
    Random rand = new Random();

    RockPaperScissor(){
        configuration = ReadConfig.getConfiguration();
    }

    private void display(String message){
        System.out.println(message);
    }

    private String getString(String message){
        display(message);
        return userInput.nextLine();
    }

    private int getInteger(String message){
        display(message);
        return userInput.nextInt();
    }

    private int getComputerChoice(){
        return rand.nextInt(3);
    }

    public String generateRequest(String[] weapons){
        String display = "Please select";
        for (int counter=0;counter<weapons.length;counter++){
            display += " " + counter + " for " + weapons[counter];
        };
        return display;
    }

    private int requestPlay(String[] weapons)
    {
        return getInteger(generateRequest(weapons));
    }

    public String determineWinner(String[] weaponList, int userWeapon, int computerWeapon, String name)
    {
        String winner;
        if (userWeapon == computerWeapon)
        {
            winner = "Draw both selected " + weaponList[computerWeapon];
        }
        else if ((userWeapon + 1) % 3 == computerWeapon)
        {
            winner = name + " wins and beats the computer's " + weaponList[computerWeapon];
        }
        else if ((computerWeapon + 1) % 3 == userWeapon)
        {
            winner = "Computer wins with " + weaponList[computerWeapon];
        }
        else {
            winner = "Unknown";
        }
        return winner;
    }

    private Map<String, String> getGamesConfiguration(){
        Map<String, String> games = new HashMap<String, String>();
        for (int configCounter = 1; configCounter < this.configuration.size(); configCounter++){
            games.put(this.configuration.get(configCounter).split(":")[0],
                    this.configuration.get(configCounter).split(":")[1]);
        }
        return games;
    }

    public void playGame(String[] weaponList, String name){
        int userWeapon;
        int computerWeapon;
        String winner;
        userWeapon = requestPlay(weaponList);
        do{
            computerWeapon = getComputerChoice();
            winner = determineWinner(weaponList, userWeapon, computerWeapon, name);
            display(winner);
            userWeapon = requestPlay(weaponList);
        } while (userWeapon< weaponList.length);
    }

    private String[] getKeys(Map<String, String> games){
        String[] keys = new String[games.size()];
        int index = 0;
        for (String key : games.keySet()){
            keys[index] = key;
            index++;
        }
        return keys;
    }

    private String[] getWeapons(Map<String, String> games, int game){
        return games.values().toArray()[game].toString().split(",");
    }

    public void run(){
        String name = getString("Enter name");
        Map<String, String> gamesConfiguration = getGamesConfiguration();
        String[] games = getKeys(gamesConfiguration);
        String gamesRequest = generateRequest(games);
        int userGame = getInteger(gamesRequest);
        while (userGame < this.configuration.size())
        {
            String[] weaponlist = getWeapons(gamesConfiguration, userGame);
            playGame(weaponlist, name);
            userGame = getInteger(gamesRequest);
        } ;
    }

    public static void main(String[ ] args){
        RockPaperScissor rockPaperScissor = new RockPaperScissor();
        rockPaperScissor.run();
    }

}
