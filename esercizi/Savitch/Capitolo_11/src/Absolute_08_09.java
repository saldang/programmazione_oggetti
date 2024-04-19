/**
* Question 9
*
* Overloading the nextInt method of the Random class to sneak in a loaded die.
*
*/
import java.util.Random;

class LoadedDice extends Random
{
	public LoadedDice()
	{
		super();  // Invoke constructor for Random class
	}

	// Here we override the nextInt method of the parent
	public int nextInt(int num)
	{
		// Get a random number from 0-1
		// by invoking the parent's random
		int r = super.nextInt(2);
		// With a 50% chance return the biggest number
		// possible, otherwise return a number from 0 to num-1
		// with an equal probability
		if (r==0)
			return num-1;
		else
			return super.nextInt(num);
	}



	public static void printDiceRolls(Random randGenerator)
	{
		for (int i = 0; i < 100; i++)
		{
			System.out.println(randGenerator.nextInt(6) + 1);
		}
	}

	public static void main(String[] args)
	{
		// This version will output lots of numbers from 1-6
		Random randGenerator = new Random();
		printDiceRolls(randGenerator);

		// This version will output lots of 6's
		// If there was an actual game of some sort based on rolling dice
		// and we somehow substituted a LoadedDice object
		// in place of a normal Random object then we could influence the outcome
		// by changing the distribution of numbers returned by nextInt().
		LoadedDice loadedRandom = new LoadedDice();
		printDiceRolls(loadedRandom);
	}
} // Question 9
