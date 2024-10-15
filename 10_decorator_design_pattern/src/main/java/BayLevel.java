public class BayLevel extends LevelGenerator
{
    public BayLevel() {
    }

    @Override
    public int calculateChallenge() {
       return 10;
    }

    @Override
    public String generateLevel() {
        return "You see a bay around you \n";
    }
}
