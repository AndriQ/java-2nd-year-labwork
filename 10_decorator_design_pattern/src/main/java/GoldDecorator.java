public class GoldDecorator extends LevelDecorator {

    public GoldDecorator(LevelGenerator level)
	{
		this.level=level;
	}

    @Override
    public int calculateChallenge() {
        return level.calculateChallenge() - 10;
    }
	
	public String generateLevel()
	{
		return level.generateLevel() + "Beyond that you see gold \n";
	}

}
