import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Ryan Scherbarth
 * Description of the class goes here
 * How to use the class goes here
 */

/**
* TODO:
* How to find length of humanArr & comuterArr
*/
public class Main {
  /**
   * Description of the main function
   * @param args
   */
  public static void main(String[] args) throws FileNotFoundException {
    // Initialize things
    File file = new File("documents/Responses.csv");  // Read in CSV File
    Scanner sc = new Scanner(file);   // Open a scanner to read over the file
    Scanner input = new Scanner(System.in);
    // Scanner botComm = new Scanner(System.in);   // use to rescan because I think mayeb this will work
    sc.nextLine();  // Ignore headers
    String humanArr[] = new String[21];
    String computerArr[] = new String[21];
    int index = 0;  // Used for index when setting string array values
    String humanInput;  // Used to store human input
    String temp;  // Used to clear rest of line when invalid input is given for math

    // Loop over the file
    while(sc.hasNext()) {
      // Use string.split to split the line into two columns by comma
      String[] line = sc.nextLine().split(",");
      // The first part of the line is the human input
      String human = line[0];
      // The second part of the line is the computer output
      String computer = line[1];
      // index values together in String arrays
      humanArr[index] = human;
      computerArr[index] = computer;
      index ++;
    }

    // Main loop of function, Will loop forever until an exception occurs
    restart: while(true) {
    humanInput = input.next();

    // Catch all valid inputs
    startLoop: if(humanInput.equals("EXIT")){   // If user enters "EXIT" from bot menu
    break restart;  // End program
    }else if(humanInput.equals("MATH")){ // If user enters "MATH" from bot menu
      // Math loop is the second infinate loop
      while (true){
        mathLoop: try{
          switch (input.next()) {
            case "EXIT":
              break startLoop; // Restart loop, without exiting entire program
            case "ADD":
              System.out.println(input.nextInt() + input.nextInt());  // Adds things
              break;
            case "MUL":
              System.out.println(input.nextInt() * input.nextInt());  // Multiplies things
              break;
            case "SUB":
              System.out.println(input.nextInt() - input.nextInt());  // Subtracts things
              break;
            case "DIV":
              System.out.println(input.nextInt() / input.nextInt());  // Divides things (int division)
              break;
            case "MATH":
              System.out.println("you're already in math.");  // this feels like it makes sense to add
              break;
            default:
              System.out.println("I don't recognize that, please try again."); // anything not recognized above.
              temp = input.nextLine();  // If the first line isn't valid, throw away rest of line
              break;
          }
        }
        catch(InputMismatchException e){
          System.out.println("I do not recognize that, please try again."); // Catches errors of incorrect input given.
          temp = input.nextLine();  // Clear rest of line
          break mathLoop;
        }
      }
    }else {
      boolean foundValue = false;   // Sets bool to false, used to check if we found a value or not
      humanInput += input.nextLine(); // add the rest of the input to the string
      for(int i=0; i<humanArr.length; i++){   // Loop through all possible bot prompts
        if(humanInput.equals(humanArr[i])){
          System.out.println(computerArr[i]);   // Return bot response if match is found
          foundValue = true;  // Make sure we know if we found the vlaue
          break;
        }
      }
      if(foundValue != true){
        System.out.println("I do not recognize that, please try again.");  // If we didn't find a matching value, say that.
      }
    }
  }
}
}

