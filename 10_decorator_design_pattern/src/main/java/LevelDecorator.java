
public abstract class LevelDecorator extends LevelGenerator
{
	LevelGenerator level;
	public abstract String generateLevel();
    public abstract int calculateChallenge();
	
}
