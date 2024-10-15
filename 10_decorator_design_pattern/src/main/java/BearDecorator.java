
public class BearDecorator extends LevelDecorator
{
	public BearDecorator(LevelGenerator level)
	{
		this.level=level;
	}
	
	@Override
    public int calculateChallenge() {
        return level.calculateChallenge() + 20;
    }

	public String generateLevel()
	{
		return level.generateLevel() + "Beyond that you see bears \n";
	}


}
