import java.util.Random;

public class Main {
	static int A;
	static Random random = new Random();

	public static void main(String[] args) {
		A = random.nextInt(3);
		System.out.println("" + A);
	}
}