import java.util.Random;

//Class definition
public class Main {
	static Player p1 = new Player();
	char ch = 'a';
	String st = "maya";
	double du = 0.5;
	float fl = (float) 0.5;
	long lo = (long) 0.111111111111111111111;
	byte by = 127;
	short sh = 767;
	int mi = 2147483647;
	static Random random = new Random();

	// main function definition
	public static void main(String args[]) {
		System.out.println(fn());
		System.out.println(p1.givein());
	}

	static int fn() {
		return random.nextInt(200);
	}
}