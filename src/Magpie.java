/**
 * A program to carry on conversations with a human user.
 *
 * THIS FILE IS A SKELETON. It compiles and it runs, and every method you have
 * to write returns a PLACEHOLDER on purpose — that is what the TODOs are. Work
 * through the milestones in README.md, in order, and run MagpieRunner after
 * each one.
 *
 * findKeyword below is GIVEN TO YOU, finished. Read it at milestone 3; you do
 * not have to write it, and you should not change it.
 *
 * The class, its method signatures and the idea are Laurie White's Magpie Lab
 * (April 2012), used here for instruction. The bodies are yours.
 *
 * @author Laurie White — original lab, April 2012
 * @author YOUR NAME HERE — this implementation
 */
public class Magpie {

  /**
   * Get a default greeting.
   *
   * MILESTONE 1 — 1.15.A, 3.5.A
   * Return a greeting in your chatbot's own voice. This one method is how you
   * check that the project runs before anything is at stake: change the string,
   * run MagpieRunner, and see your own words come back.
   *
   * @return a greeting
   */
  public String getGreeting() {
    return "Hello, What's up";
  }

  /**
   * Give a response to a user statement.
   *
   * MILESTONES 2-4 — 1.15.B, 2.2.A, 2.3.A, 2.5.A, 2.10.A
   * Look for keywords in `statement` and return something that shows you were
   * listening. You need at least SIX distinct keyword rules that each answer
   * sensibly. Three things worth deciding before you write a single branch:
   *
   *   HOW YOU SEARCH. Milestone 2 is plain String.indexOf, which returns the
   *   position of what you asked for or -1 when it is not there — so
   *   `statement.indexOf("dog") >= 0` is the Boolean expression for "the word
   *   dog is in there somewhere". Pick >= 0 or != -1 and then use the SAME one
   *   every time; mixing them is legal and unreadable. Milestone 3 replaces it
   *   with findKeyword below, which is the version that does not fire on
   *   "grandmother" when you asked about "mother".
   *
   *   CASE. "Dog", "dog" and "DOG" are three different strings to indexOf.
   *   findKeyword already lowercases both sides, which is one more reason to
   *   move to it.
   *
   *   ORDER. The first branch that matches wins, so the order of your if /
   *   else if chain IS a decision about which topic matters most. Put a
   *   specific topic above a general one or the general one eats it.
   *
   * @param statement the user statement
   * @return a response based on the rules you write
   */
  public String getResponse(String statement) {
    String response = ""; // Start a response
    if(statement.equals("")|| statement.length ()== 0) {
      response = "Please type something";

    }
    else if (statement.indexOf("dog")!= -1 || statement.indexOf("cat") != -1 
        || statement.indexOf("fish") != -1) {
        
      response = "Tell me more about your pets.";
    }
    // TODO Milestone 2: detect keywords with indexOf and respond to them.
    // TODO Milestone 2: handle the empty statement — the user just pressed Enter.
    // TODO Milestone 3: move your searches to findKeyword so whole words match.
    // TODO Milestone 4: answer several related words in one branch, with ||.
    // TODO: when nothing matches, fall through to getRandomResponse().


    return response;
  }

  /**
   * Pick a default response to use when nothing else fits.
   *
   * THE FALLBACK — 2.3.A, 3.5.A
   * Every input has to get an answer, so one branch must always match. A
   * chatbot that says the same thing every time it is stumped stops being
   * interesting on the second try, so write several non-committal replies and
   * choose between them at random.
   *
   * `Math.random()` returns a double in [0.0, 1.0). Turning that into a whole
   * number in range is a cast and a multiply, and getting the range right —
   * without an off-by-one at either end — is the actual exercise here.
   *
   * This method is private. Ask yourself why that is right before you change
   * it: nothing outside Magpie has any business calling it.
   *
   * @return a non-committal string
   */
  private String getRandomResponse() {
    // TODO: return one of several replies, chosen at random.
    return "PLACEHOLDER DEFAULT.";
  }

  /**
   * Search for a whole word in a statement, ignoring case.
   *
   * GIVEN TO YOU, FINISHED. Read it at milestone 3, call it, do not change it.
   *
   * indexOf finds SUBSTRINGS, which is why "mother" fires on "grandmother" and
   * why "no" fires on "I know". This walks every hit and only accepts one whose
   * neighbouring characters are not letters — that is the whole difference
   * between a substring and a word.
   *
   * @param statement the user statement
   * @param goal the word to look for
   * @param startPos where in the statement to start looking
   * @return the position of the word, or -1 if it is not there
   */
  private int findKeyword(String statement, String goal, int startPos) {
    String phrase = statement.trim().toLowerCase();
    goal = goal.toLowerCase();

    int psn = phrase.indexOf(goal, startPos);

    while (psn >= 0) {
      // A word at the very start or the very end has nothing on that side, so
      // treat the missing neighbour as a space — i.e. as "not a letter".
      String before = " ";
      String after = " ";
      if (psn > 0) {
        before = phrase.substring(psn - 1, psn);
      }
      if (psn + goal.length() < phrase.length()) {
        after = phrase.substring(psn + goal.length(), psn + goal.length() + 1);
      }

      if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0))
          && ((after.compareTo("a") < 0) || (after.compareTo("z") > 0))) {
        return psn;
      }

      psn = phrase.indexOf(goal, psn + 1);
    }

    return -1;
  }

  /**
   * Search for a whole word from the beginning of the statement.
   *
   * GIVEN TO YOU. An overload: the same name, fewer parameters, handing the
   * work to the three-argument version with a sensible default. This is the
   * one you will actually call.
   *
   * @param statement the user statement
   * @param goal the word to look for
   * @return the position of the word, or -1 if it is not there
   */
  private int findKeyword(String statement, String goal) {
    return findKeyword(statement, goal, 0);
  }

  /*
   * IF YOU FINISH EARLY — 2.4.A, 2.6.B, 1.12.A
   *
   * Right now Magpie has no memory: say "I have a dog" twice and it answers
   * identically both times, which is exactly what a thing with no memory does.
   *
   * Give the class an INSTANCE VARIABLE that remembers what the last statement
   * was about, set it when a topic matches, and read it on the way in so a
   * repeated topic gets a different answer. That is a nested if — a decision
   * inside a decision — and it is one line of state away from everything Unit
   * 3 is about.
   *
   * One trap this will hand you: comparing that variable with == asks whether
   * two references point at the same object, not whether the text matches.
   * For strings you almost always want .equals(). It will appear to work with
   * == for a while, which is what makes it worth knowing now.
   *
   * Declare it above the methods, where an instance variable belongs.
   */
}
