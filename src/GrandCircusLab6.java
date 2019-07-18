import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class GrandCircusLab6 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter the number of sides on your pair of dice.");
		int sides = 6;
		try {
			sides = s.nextInt();
		} catch (InputMismatchException e) {
			System.out.printf("Invalid number! defaulting to %d%n", sides);
		}
		s.nextLine(); // discard the garbage line
		int iters = 0;
		String cont = "y";
		do {
			if (cont.equals("y") || cont.equals("yes")) {
				System.out.printf("Roll #%d:%n%d%n%d%n", 
					++iters,
					generateRandomDieRoll(sides),
					generateRandomDieRoll(sides));
				System.out.println("Roll again? (y/n)");
			} else {
				System.out.println("Invalid option, please use y/n.");
			}
			cont = s.nextLine().trim().toLowerCase();
		} while (!cont.equals("n") && !cont.equals("no"));
		s.close();
		System.out.println("Goodbye.");
	}
	
	private static int generateRandomDieRoll(int sides) {
		return (new Random()).nextInt(sides)+1;
	}
}
