public class LizardDecorator extends LevelDecorator {

    public LizardDecorator(LevelGenerator level)
	{
		this.level=level;
	}

    @Override
    public int calculateChallenge() {
        int baseChallenge = level.calculateChallenge();
        if (level instanceof BayLevel) {
            return baseChallenge + 20;
        } else if (level instanceof MountainLevel) {
            return baseChallenge + 30;
        } else if (level instanceof WoodlandLevel) {
            return baseChallenge + 40;
        } else {
            return baseChallenge;
        }
    }
	
	public String generateLevel()
	{ 
		return level.generateLevel() + "Beyond that you see a lizard \n";
	}

}