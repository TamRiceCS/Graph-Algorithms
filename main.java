import java.util.Scanner;  

public class Main{
	// run code w/ javac Main.java
	// java Main
	public static void main(String[] args) {
		Scanner inputs = new Scanner(System.in);
		String userInput = "0";

		while(!userInput.equals("x")) {
			System.out.println("\nWelcome to the graph algorithm demo, please chose a mode by entering the number:");
			System.out.println("1. Learn about the basics of graph representations");
			System.out.println("2. Traversing a graph");
			System.out.println("3. Detecting Cycles");
			System.out.println("4. Shortest Paths");
			System.out.println("5. Minimum / Maximum Spanning Trees");
			System.out.println("6. Connectivity");
			System.out.println("7. Max Flow in a graph");
			System.out.println("Enter \'x\' to quit.");
			System.out.print("\nYour Input: ");

			userInput = inputs.nextLine();

			switch(userInput) {
				case "1": {
					System.out.println("\nGraphs consist of a bunch of points (nodes) that are connected (via edges). They have two main representations: adjacency lists and adjacency matrixes.");
					System.out.println("Graphs have 2 main representations: adjacency lists and adjacency matrixes. Graphs have 2 main characteristics: weighted (or not) and directional (or not).");
					System.out.println("\nAdjacency List Example: \n\n1 -> 2,3,4\n2 -> 3,4\n3 -> 4\n4 -> 1");
					System.out.println("\nAn Adjacency List is a list of linkedlists. It minimizes space usage as parent nodes connection lists only contain nodes it is connected to. Space complexity is O(Nodes + Edges) or O(N+E) for short. Where space is optimized time complexity for edge connection lookups are not. You will have to run through the whole parent node's list to see if a child node is connected.");
					System.out.println("\nAdjacency Matrix Example: \n\n[[0, 1, 1, 1] \n[0, 0, 1, 1] \n[0, 0, 0, 1] \n[1, 0, 0, 0]]");
					System.out.println("\nAn Adjacency Matrix however is a 2D List. It will confirm or deny rather every other node, including itself, is connected or not. Space usage is not optimized and is O(Nodes x Nodes). What is optomized is lookup as nodes are quickly accessed matrix[parentNode][childNode] = ?. Usually these matrixes are truth \"tables\" returning 1 if connected and 0 if not connected.");
					System.out.println("\nThe prior characteristics mentioned (Weight and direction), can change how data is stored in these representations. Weight in an adjacency list will report the cost of the connection between a parent child instead of true and false. You will need a valid \"disqualifier\" value to show that a connection does not exist. (i.e. no weights of 0 are allowed so 0s are interpreted as not connected.) An adjacency List will instead contain objects that both have the child node's value and the cost of the connection. Directionality tells the graph if each edge is bidirectional (You can travel from 1 to 2 and back) or unidirectional (You can only travel from 1 to 2.) This does not change graph representations but instead adds data making the inverse of every edge stored.");
					break;
				}

				case "x": {
					System.out.println("Thank you for using the demo.");
					break;
				}
				default:
					System.out.println("Sorry invalid case..." + userInput);
					break;

			}
		}
	}
}