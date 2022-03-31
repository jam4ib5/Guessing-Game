import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

	public static int[] PromptUser() {
		
		int[] range = new int[2];
		Scanner stdin = new Scanner(System.in);
		System.out.println(" + ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ +"
				+ "\n + Enter the lowest value of the game range:"
				+ "\n + ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ +" );
		range[0] = stdin.nextInt();
		System.out.println(" + ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ +"
				+ "\n + Enter the highest value of the game range: "
				+ "\n + ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ +");
		range[1] = stdin.nextInt();	
		
		
		return range;
		
	}
	
	
	public static int GenerateTargetValue(int [] rangeArray) {
	
		Random randomNumber = new Random();
		int targetValue = randomNumber.nextInt(rangeArray[1]-rangeArray[0])+rangeArray[0];
		
		return targetValue;
	}
	
	public static boolean CheckAttempts( int userGuess, int rightAnswer) {
		
		if(userGuess != rightAnswer) {
			
			if(userGuess < rightAnswer)
				System.out.println("\n + your guess is lower than the number."
						+ " \n   -----------------------------------");
			else
				System.out.println("\n + your guess is higher than the number."
						+ "\n   -----------------------------------");
		
			return false;
		}
	
		
		else
			return true;
	
	}
	
	
	public static void main(String[] args) {
		
		int userInput;
		int totalTrials = 1;
		boolean isGameOver = false;
		Scanner stdin = new Scanner(System.in);
		
		int[] array = PromptUser();
		int choosenNumber = GenerateTargetValue(array);
		do {
			System.out.println(" \n + Enter a guess: "
					+ "\n   -------------");
			userInput = stdin.nextInt();
		isGameOver = CheckAttempts(userInput,choosenNumber);
		if(!isGameOver)
			totalTrials+=1;
		
		}while(!isGameOver);
		
		stdin.close();
		System.out.println(" \n + ~~~~~~~~ +"
				+ "\n + Good Job!"+
				"\n + ~~~~~~~~~~~~~~~~~~~ +"
				+ "\n + Total Trials taken: "+totalTrials
				+"\n + ~~~~~~~~~~~~~~~~~~~ +");
		
	}

}
