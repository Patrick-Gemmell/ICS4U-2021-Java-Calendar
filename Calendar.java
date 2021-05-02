/*
* The program finds the day
* of the week of a chosen date
*
* @author  Patrick Gemmell
* @version 1.0
* @since   2021-04-30
*/

import java.util.Scanner;  // Import the Scanner class

public final class Calendar {
    private Calendar() {

  }
  /**
  * the number three.
  */
  public static final int THREE = 3;
  /**
  * the number four.
  */
  public static final int FOUR = 4;
  /**
  * the number five.
  */
  public static final int FIVE = 5;
   /**
  * the number six.
  */
  public static final int SIX = 6;
  /**
  * the number seven.
  */
  public static final int SEVEN = 7;
   /**
  * the number eight.
  */
  public static final int EIGHT = 8;
  /**
  * the number nine.
  */
  public static final int NINE = 9;
  /**
  * the number ten.
  */
  public static final int TEN = 10;
  /**
  * the number eleven.
  */
  public static final int ELEVEN = 11;
  /**
  * the number twelve.
  */
  public static final int TWELVE = 12;
  /**
  * the number fourteen.
  */
  public static final int FOURTEEN = 14;
  /**
  * the number twenty eight.
  */
  public static final int TWENTYEIGHT = 28;
  /**
  * the number twenty nine.
  */
  public static final int TWENTYNINE = 29;
  /**
   * This function calculates the day of the week
   * based on a date the user inputs.
   * @return
   * returns weekday
   * @param indate
   * @param month
   * @param year
   * @param centuryCode
   * @param addingNumber
   */
  static String findWeekday(final int indate, final int month, final int year,
                            final int centuryCode, final int addingNumber) {
    // This function calculates the day of the week
    //   given a date from the user

    // Calculating the number for the century code (first variable)
    int date = indate;
    int firstVariable = 0;
    if (centuryCode % FOUR == 0) {
      firstVariable = 2;
    } else if (centuryCode % FOUR == 1) {
      firstVariable = 0;
    } else if (centuryCode % FOUR == 2) {
      firstVariable = FIVE;
    } else if (centuryCode % FOUR == THREE) {
      firstVariable = THREE;
    } else {
      System.out.println("ERROR");
    }

    // Calculating the second variable
    int secondVariable = addingNumber / TWELVE;

    // Calculating the third variable
    int thirdVariable = addingNumber % TWELVE;

    // Calculating the fourth variable
    int fourthVariable = thirdVariable / FOUR;

    // Calculating final variable and reducing it to find the doomsday
    int fifthVariable = firstVariable + secondVariable
                        + thirdVariable + fourthVariable;

    while (fifthVariable > SIX) {
      fifthVariable = fifthVariable - SEVEN;
    }

    // Finding the doomsday based on the month
    int doomsdayDate = 0;
    switch (month) {
      case 1:
        if (year % FOUR == 0) {
          doomsdayDate = FOUR;
        } else {
          doomsdayDate = THREE;
        }
        break;
      case 2:
        if (year % FOUR == 0) {
          doomsdayDate = TWENTYNINE;
        } else {
          doomsdayDate = TWENTYEIGHT;
        }
        break;
      case THREE:
        doomsdayDate = FOURTEEN;
        break;
      case FOUR:
        doomsdayDate = FOUR;
        break;
      case FIVE:
        doomsdayDate = NINE;
        break;
      case SIX:
        doomsdayDate = SIX;
        break;
      case SEVEN:
        doomsdayDate = ELEVEN;
        break;
      case EIGHT:
        doomsdayDate = EIGHT;
        break;
      case NINE:
        doomsdayDate = FIVE;
        break;
      case TEN:
        doomsdayDate = TEN;
        break;
      case ELEVEN:
        doomsdayDate = SEVEN;
        break;
      case TWELVE:
        doomsdayDate = TWELVE;
        break;
      default:
        doomsdayDate = 0;
    }

    // This block finds a numeric value for the day of the week
    if (date < doomsdayDate) {
      while (date < doomsdayDate) {
        if (fifthVariable <= 0) {
          fifthVariable = SIX;
          date = date + 1;
        } else {
          fifthVariable = fifthVariable - 1;
          date = date + 1;
        }
      }
    } else if (date > doomsdayDate) {
      while (date > doomsdayDate) {
        if (fifthVariable >= SIX) {
          fifthVariable = 0;
          date = date - 1;
        } else {
          fifthVariable = fifthVariable + 1;
          date = date - 1;
        }
      }
    } else {
      System.out.println("ERROR");
    }

    // This block finds the day of the week and returns its value
    String weekDayReturn = null;
    switch (fifthVariable) {
      case 0:
        weekDayReturn = "Sunday";
        break;
      case 1:
        weekDayReturn = "Monday";
        break;
      case 2:
        weekDayReturn = "Tuesday";
        break;
      case THREE:
        weekDayReturn = "Wednesday";
        break;
      case FOUR:
        weekDayReturn = "Thursday";
        break;
      case FIVE:
        weekDayReturn = "Friday";
        break;
      case SIX:
        weekDayReturn = "Saturday";
        break;
      default:
        weekDayReturn = null;
    }
    return weekDayReturn;
  }

  /**
   * This function allows the user to enter the date and will tell the user
   * the day of the week based on a date the user inputs.
   * @param args
   */
  public static void main(final String[] args) {
    // Main function
    try {
      // Input for the date
      Scanner dateInput = new Scanner(System.in);
      System.out.println("Enter the date number:");
      int userDate = dateInput.nextInt();
      System.out.println();

      // Input for the month
      Scanner monthInput = new Scanner(System.in);
      System.out.println("Enter the month (number):");
      int userMonth = monthInput.nextInt();
      System.out.println();

      // Input for the year
      Scanner yearInput = new Scanner(System.in);
      System.out.println("Enter the year (four numbers):");
      String userYear = yearInput.nextLine();
      System.out.println();

      // Process
      // Splitting the year string in half to make for easier calculations
      String firstHalfYearStr = userYear.substring(0, (userYear.length() / 2));
      String secondHalfYearStr = userYear.substring((userYear.length() / 2));

      // Turning all year strings into integers
      int yearInteger = Integer.parseInt(userYear);
      int firstHalfYear = Integer.parseInt(firstHalfYearStr);
      int secondHalfYear = Integer.parseInt(secondHalfYearStr);

      // Calling the function that will calculate the day of the week
      String dayOfTheWeek = findWeekday(userDate, userMonth, yearInteger,
                                        firstHalfYear, secondHalfYear);

      // Output
      System.out.println();
      System.out.println("The day of the week is " + dayOfTheWeek);

      // Catches and tells the user that an improper input was entered
    } catch (Exception e) {
      System.out.println();
      System.out.println("ERROR: Invalid Input");
    }
  }
}
