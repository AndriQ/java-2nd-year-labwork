public class MountainLevel extends LevelGenerator
{
	public MountainLevel()
	{
		
	}

    @Override
    public int calculateChallenge() {
        return 30;
    }

	public String generateLevel()
	{
		return "You see a mountain around you \n";
	}
}
