public abstract class LevelGenerator
{	
	public abstract String generateLevel();

	public abstract int calculateChallenge();

	public static void main(String[] args)
	{
		LevelGenerator levelGenerator = new BearDecorator(new BayLevel());
		System.out.println(levelGenerator.generateLevel());
	}
}
