//Enhancements :- 
// 1. Authentication for Guesser for Guessing the number in levels.
// 2. Adding Levels to the game.


import java.util.Scanner;

class Guesser {

	int guessedNumber;

	int guessNumber() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Number Guessed by Guesser : ");
		guessedNumber = scan.nextInt();
		return guessedNumber;
	}
	
	int guessNumber(int level) {
		Scanner scan = new Scanner(System.in);
		if(level>1) {
			System.out.print("Number Guessed by Guesser for this Level : ");
			guessedNumber = scan.nextInt();
		}	
		return guessedNumber;
	}
	
	boolean authenticate() {
		Scanner sc = new Scanner(System.in);
		String name = "Vaishali";
		String pass = "Nov@123";
		System.out.println("Guesser? Enter your Username and Password.");
		System.out.print("UserName: ");
		String userName = sc.next();
		System.out.print("Password: ");
		String password = sc.next();
		if(userName.equalsIgnoreCase(name) && password.equals(pass)) {
			return true;
		}else {
			return false;
		}
	}
}

class Player {

	int NumberGuessedByPlayer;

	int numberGuessedByPlayer() {
		Scanner scan = new Scanner(System.in);
		NumberGuessedByPlayer = scan.nextInt();
		return NumberGuessedByPlayer;
	}
	
}

class Umpire {

	int NumberByGuesser;
	int NumberFromPlayer1;
	int NumberFromPlayer2;
	int NumberFromPlayer3;
	int coinPlayer1=0;
	int coinPlayer2=0;
	int coinPlayer3=0;

	void collectNumberFromGuesser() {
		Scanner sc = new Scanner(System.in);
		Guesser g = new Guesser();
		if(g.authenticate()) {
			NumberByGuesser = g.guessNumber();
		}
		else {
			System.out.println("Either Username or Password Not Matching. Try Again!");
			collectNumberFromGuesser();
		}
	}
	
	void collectNumberFromGuesser(int level) {
		Guesser g = new Guesser();
		System.out.println("Welcome to the Next Level ");
		NumberByGuesser=g.guessNumber(level);
	}

	void collectNumberFromPlayers(int flag) {
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();
		if(flag == 1) {
			System.out.print("Player 1 : Enter you Number : ");
			NumberFromPlayer1 = p1.numberGuessedByPlayer();
			System.out.print("Player 2 : Enter you Number : ");
			NumberFromPlayer2 = p2.numberGuessedByPlayer();
			System.out.print("Player 3 : Enter you Number : ");
			NumberFromPlayer3 = p3.numberGuessedByPlayer();
		}else if(flag == 2) {
			System.out.print("Player 1 : Enter you Number : ");
			NumberFromPlayer1 = p1.numberGuessedByPlayer();
			System.out.print("Player 2 : Enter you Number : ");
			NumberFromPlayer2 = p2.numberGuessedByPlayer();
		}else if(flag == 3) {
			System.out.print("Player 2 : Enter you Number : ");
			NumberFromPlayer2 = p2.numberGuessedByPlayer();
			System.out.print("Player 3 : Enter you Number : ");
			NumberFromPlayer3 = p3.numberGuessedByPlayer();
		}else {
			System.out.print("Player 1 : Enter you Number : ");
			NumberFromPlayer1 = p1.numberGuessedByPlayer();
			System.out.print("Player 3 : Enter you Number : ");
			NumberFromPlayer3 = p3.numberGuessedByPlayer();
		}
	} 

	void compareNumbers() {
		if (NumberByGuesser == NumberFromPlayer1) {
			if (NumberByGuesser == NumberFromPlayer2 && NumberByGuesser == NumberFromPlayer3) {
				System.out.println("Congratulations!! All of you have Guessed Correct");
				collectNumberFromGuesser(2);
				collectNumberFromPlayers(1);
				compareNumbers();
			} else if (NumberByGuesser == NumberFromPlayer2) {
				System.out.println("Player 3 Lost");
				NumberFromPlayer3=0;
				System.out.println("Congratulations!! Player 1 and Player 2 you are in next Level");
				collectNumberFromGuesser(2);
				collectNumberFromPlayers(2);
				compareNumbers();
			} else if (NumberByGuesser == NumberFromPlayer3) {
				System.out.println("Player 2 Lost");
				NumberFromPlayer2=0;
				System.out.println("Congratulations!! Player 1 and Player 3 you are in next Level");
				collectNumberFromGuesser(2);
				collectNumberFromPlayers(4);
				compareNumbers();
			} else {
				System.out.println("Player 1 won");
				System.out.println("Congratulations!! you have earned one Gold Coin");
				coinPlayer1++;
			}
		} else if (NumberByGuesser == NumberFromPlayer2) {
			if (NumberByGuesser == NumberFromPlayer3) {
				System.out.println("Player 1 Lost");
				NumberFromPlayer1=0;
				System.out.println("Congratulations!! Player 1 and Player 3 you are in next Level");
				collectNumberFromGuesser(2);
				collectNumberFromPlayers(3);
				compareNumbers();
			}else {
					System.out.println("Player 2 won");
					System.out.println("Congratulations!! you have earned one Gold Coin");
				}
		} else if (NumberByGuesser == NumberFromPlayer3) {
			System.out.println("Player 3 won");
			System.out.println("Congratulations!! you have earned one Gold Coin");
		} else {
			System.out.println("All Lost");
		}

	}
}

public class GuesserGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("                              Welcome! to Guesser Game                              ");
		System.out.println("                                   * Level 1 *                                        ");
		Umpire u = new Umpire();
		String ip;
		boolean exit=true;
		do{
			u.collectNumberFromGuesser();
			u.collectNumberFromPlayers(1);
			u.compareNumbers();
			System.out.println("Enter YES if you want to Exit ");
			ip=sc.next();	
			if(ip.equalsIgnoreCase("YES")) {
				exit=false;		
			}
		}while(exit);
		

	}

}
