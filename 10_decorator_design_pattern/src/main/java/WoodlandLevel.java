public class WoodlandLevel extends LevelGenerator
{
	public WoodlandLevel()
	{
		
	}

	@Override
    public int calculateChallenge() {
        return 20;
    }

	public String generateLevel()
	{
		return "You see a woodland around you \n";
	}
}
