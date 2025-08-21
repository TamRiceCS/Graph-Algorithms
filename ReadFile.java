import java.util.Scanner;  
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ReadFile{

    public static int length;
    public static boolean directed;
    public static boolean weighted;

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
                        System.out.println(parameters);
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
                // place this in a try catch block as well
                if(section != -1){
                    subParam = parameters.substring(0,section);
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
                else {
                    System.out.println(givenFile + " could not partition first line input at directionality");
                    return;
                }



            }
            else {
                System.out.println(givenFile + " file does not meet first line formatting requirements.");
                return;
            }

            while(read.hasNextLine()){
                System.out.println(read.nextLine());
            }
        }
        catch (FileNotFoundException error) {
            System.out.println(givenFile + " could not be found. Please try again.");
        }
    }
}