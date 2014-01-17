import java.util.ArrayList;
import java.util.Scanner;

public class guessingGame {
	public static void main(String[] args) {

		int randomNum = (int) (Math.random() * (1000 - 1) + 1);
		int yourNum = 0;
		int numberOfGuesses = 0;

		String yourName;

		String inputString = "";

		ArrayList<Player> managePlayer = new ArrayList<>();

		System.out.println("Hello and Welcome to this guessing game ! -----"
				+ randomNum
				+ "\nStart guessing, it is a number between 1 and 1000...");

		Scanner input = new Scanner(System.in);

		long startingTime = System.currentTimeMillis();

		while (true) {

			inputString = input.next();
			checkNonNumericInput(inputString);
			if (inputString.equalsIgnoreCase("quit")) {
				System.out.println("**** The game was interrupted");
				break;
			}

			try {
				yourNum = Integer.parseInt(inputString);
			} catch (NumberFormatException nfex) {
				continue;

			}
			if ((yourNum < 1) || (yourNum > 1000)) {

				System.out.println("Stupid guess! I won't cont that ...");
			} else {

				numberOfGuesses++;

				if (yourNum < randomNum) {

					System.out.println("Guess is too low!");

				} else {
					if (yourNum > randomNum) {
						System.out.println("Guess is too high!");

					} else {

						if (yourNum == randomNum) {
							System.out.println("****CORRECT!");

							long endingTime = System.currentTimeMillis();

							long totalTimeOfPlaying = (endingTime - startingTime) / 1000;

							System.out
									.println("**** You guessed the correct number in "
											+ numberOfGuesses
											+ " guesses"
											+ "\nPlease enter your name:");

							Player pl = new Player();

							yourName = pl.name = input.next();
							pl.numberOfGuesses = numberOfGuesses;
							pl.timePlaying = totalTimeOfPlaying;

							managePlayer.add(pl);

							System.out
									.println("Do you want to play again? (y/n)");

							String yourAnswer = input.next();

							if (yourAnswer.equalsIgnoreCase("y")) {

								System.out.println("Current hightscore list:"
										+ "\nName" + "\tGuesses" + "\tTime");

								for (int i = 0; i < managePlayer.size(); i++) {
									System.out
											.println(managePlayer.get(i).name
													+ "\t"
													+ managePlayer.get(i).numberOfGuesses
													+ "\t"
													+ managePlayer.get(i).timePlaying);
								}

								System.out.println();

								System.out
										.println("Enter number between 1 and 1000 ...");

								numberOfGuesses = 0;
								startingTime = System.currentTimeMillis();

								continue;

							} else {

								break;
							}

						}
					}

				}

			}
		}

		System.out.println("Current hightsore list:" + "\nName" + "\tGuesses"
				+ "\tTime");
		for (int i = 0; i < managePlayer.size(); i++) {
			System.out.println(managePlayer.get(i).name + "\t"
					+ managePlayer.get(i).numberOfGuesses + "\t"
					+ managePlayer.get(i).timePlaying);
		}
	}

	public static boolean checkNonNumericInput(String yourInput2) {
		// TODO Auto-generated method stub
		if (yourInput2 == null || yourInput2.length() == 0) {
			System.err.println("WRONG INPUT! YOU MUST ENTER NUMBER");

			return false;
		}

		for (int i = 0; i < yourInput2.length(); i++) {
			if (!Character.isDigit(yourInput2.charAt(i))) {
				System.err.println("WRONG INPUT! YOU MUST ENTER NUMBER");

				return false;
			}
		}

		return true;
	}
}