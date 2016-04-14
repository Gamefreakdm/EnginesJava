import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		File file = new File("C:/Users/nanot/Documents/GitHub/EnginesJava/File input output/Resources/Docs/File.txt");
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			out.write("Hello World");
			out.newLine();
			out.write("yay");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Scanner input = new Scanner(file);
			while (input.hasNextLine())
				System.out.println(input.nextLine());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}