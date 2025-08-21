import java.util.Scanner;  
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main{
	// run code w/ javac Main.java
	// java Main
	public static void main(String[] args) {
		Scanner inputs = new Scanner(System.in);
		String userInput = "0";

		while(!userInput.equals("x")) {
			System.out.println("\nWelcome to the graph algorithm demo, please chose a mode by entering the number:");
			System.out.println("1. Learn about the basics of graph representations");
			System.out.println("2. Use a default graph");
			System.out.println("3. Use a graph of your making");
			// System.out.println("2. Traversing a graph");
			// System.out.println("3. Detecting Cycles");
			// System.out.println("4. Shortest Paths");
			// System.out.println("5. Minimum / Maximum Spanning Trees");
			// System.out.println("6. Connectivity");
			// System.out.println("7. Max Flow in a graph");
			// System.out.println("Enter \'x\' to quit.");

			System.out.print("\nYour Input: ");
			userInput = inputs.nextLine();

			switch(userInput) {

				case "1":{
					try {
						File info = new File("Graph_Info.txt");
						Scanner read = new Scanner(info);
						System.out.print("\n");
						while(read.hasNextLine()){
							System.out.println(read.nextLine());
						}
					}
					catch (FileNotFoundException error) {
						System.out.println("Information on graphs text file can't be located");
					}
					break;
				}
				case "2": {
					// include format guidelines document
					System.out.println("\nPlease provide the file name that contains your graph or enter \'b\' to go back:");
					System.out.print("\nYour Input: ");
					userInput = inputs.nextLine();
					if(userInput != "b") {
						ReadFile.readUserGraph(userInput);
					}
				}
				case "x": {
					System.out.println("Thank you for using the demo! Goodbye!");
					break;
				}
				default:

			}
		}
	}
}