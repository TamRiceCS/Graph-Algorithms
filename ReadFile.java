import java.util.Scanner;  
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ReadFile{

    public static int length = 0;
    public static boolean directed;
    public static boolean weighted;
    public static boolean processed = false;

    public static ArrayList<ArrayList<Integer>> adjacencyMatrix = new ArrayList<ArrayList<Integer>>();

    public static void readUserGraph(String givenFile) {
        try {
            File info = new File(givenFile);
            Scanner read = new Scanner(info);
            System.out.print("\n");

            // handle first line with graph info
            if(read.hasNextLine()) {
                String parameters = read.nextLine();
                String subParam = "";
                int section =  parameters.indexOf(' ');

                if(section != -1) {
                    try {
                        length = Integer.parseInt(parameters.substring(0,section));
                        parameters = parameters.substring(section+1);
                    }
                    catch(NumberFormatException nfe){
                        System.out.println(givenFile + " first input is not a number.");
                        return;
                    }
                    catch(StringIndexOutOfBoundsException e) {
                        System.out.println(givenFile + " missing parameters after number of graph nodes");
                        return;

                    }
                }
                else {
                    System.out.println(givenFile + " could not partition first line input at node number");
                    return;
                }

                section =  parameters.indexOf(' ');
                if(section != -1){
                    try {
                        subParam = parameters.substring(0,section);
                        parameters = parameters.substring(section+1);
                        if(subParam.equals("d")) {
                            directed = true;
                        }
                        else if(subParam.equals("d")) {
                            directed = false;
                        }
                        else{
                            System.out.println(givenFile + " does not have directionality properly documented.");
                            return;
                        }
                    }
                    catch(StringIndexOutOfBoundsException e) {
                        System.out.println(givenFile + " missing parameters after number of graph nodes");
                        return;

                    }
            
                }
                else {
                    System.out.println(givenFile + " could not partition first line input at directionality");
                    return;
                }

                parameters.trim();
                if(parameters.equals("w")) {
                    weighted = true;
                }
                else if(parameters.equals("uw")) {
                    weighted = false;
                }
                else {
                    System.out.println(givenFile + " could not partition first line input at weightedness");
                    return;
                }
            }
            else {
                System.out.println(givenFile + " file does not meet first line formatting requirements.");
                return;
            }
            
            // TODO: Write code to store in BOTH a matrix and list
            int rows = 0;
            int cols = 0;
            while(read.hasNextLine()){
                String line = read.nextLine();
                String number = "";
                ArrayList<Integer> basic = new ArrayList<Integer>();

                for(int i = 0; i < line.length(); i++) {
                    if(Character.isDigit(line.charAt(i))) {
                        number = number + line.charAt(i);
                    }
                    if((line.charAt(i) == ',' || line.charAt(i) == ']') && cols < length && !number.isEmpty()) {
                        if(cols < length && rows < length) {
                            basic.add(Integer.parseInt(number));
                            number = "";
                            cols++;
                        }
                    } 
                    else if(cols > length) {
                        System.out.println("Your row of data: " + line + " contains an inaccurate amount of nodes.");
                        return;
                    }

                    if(rows < length && cols == length && !basic.isEmpty()) {
                        rows++;
                        adjacencyMatrix.add(basic);
                        basic.clear();
                        outputMatrix();
                        cols = 0;
                    }
                    else if(rows >= length){
                        System.out.println("Your input file contains to many rows of data.");
                        adjacencyMatrix.clear();
                        return;
                    }
                }
            }
            if(!adjacencyMatrix.isEmpty()) {
                outputMatrix();
            }
        }
        catch (FileNotFoundException error) {
            System.out.println(givenFile + " could not be found. Please try again.");
        }
    }

    public static void outputMatrix() {
        for(int i = 0; i < adjacencyMatrix.size(); i++) {
            System.out.print("[");
            for(int j = 0; j < adjacencyMatrix.get(i).size(); j++) {
                if(j != adjacencyMatrix.get(i).size()-1) {
                    System.out.println(adjacencyMatrix.get(i).get(j) + ",");
                }
                else{
                    System.out.println(adjacencyMatrix.get(i).get(j));
                }
            }
            System.out.println("]");
        }
    }
}