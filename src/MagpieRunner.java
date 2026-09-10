import java.util.Scanner;

/**
 * A simple class to run the Magpie class.
 *
 * THIS FILE IS GIVEN TO YOU AND YOU DO NOT NEED TO CHANGE IT. It is the driver:
 * it makes a Magpie, prints its greeting, and then loops — read a line, hand it
 * to getResponse, print what comes back — until you type Bye.
 *
 * Read it anyway. It is a short, complete example of the three things Unit 1
 * is about: creating an object, calling instance methods on it, and using the
 * values they return (1.13.C, 1.14.A).
 *
 * @author Laurie White — original lab, April 2012
 */
public class MagpieRunner {

  /**
   * Create a Magpie, give it user input, and print its replies.
   */
  public static void main(String[] args) {
    Magpie maggie = new Magpie();
  
    System.out.println(maggie.getGreeting());

    // try-with-resources closes the Scanner even if something throws.
    try (Scanner in = new Scanner(System.in)) {
      System.out.print("INPUT:");
      String statement = in.nextLine();

      while (!statement.equalsIgnoreCase("Bye")) {
        System.out.println(maggie.getResponse(statement));
        System.out.print("INPUT:");
        statement = in.nextLine();
      }
    }

    System.out.println("Bye!");
  }
}
