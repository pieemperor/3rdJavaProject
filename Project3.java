/**************************************************************************************
 * ------------------------------------------------------------------------------------
 * File name: Project3.java
 * Project name: CSCI 1250 Project 3
 * ------------------------------------------------------------------------------------
 * Author Name: Dakota Cowell
 * Author E-mail: cowelld@goldmail.etsu.edu
 * Course-Section: CSCI-1250-201
 * Creation Date: 10/15/2015
 * Date of Last Modification: 10/21/2015
 * -----------------------------------------------------------------------------
 */
import java.util.Scanner; //to allow input from the keyboard
import java.text.DecimalFormat;//to allow decimal formatting
/*******************************************************************************
 * Class Name: Project3 <br>
 * Class Purpose: Project 3  <br>
 *
 * <hr>
 * Date created: 10/15/2015 <br>
 * Date last modified: 10/21/2015
 * @author Dakota Cowell
 */
public class Project3
{
  /*****************************************************************************
 * Method Name: main <br>
 * Method Purpose:
 * You are to write a program that will ask the user for a grade and give
 * them options for applying a curve to that grade. It should give them the
 * option to curve by 10 points or 10 percent. It should also give them the
 * option to curve the grade by the number of points that they enter or a
 * percentage that they enter. It should use a menu to allow the user to
 * select from the different options for curving the grade.
 * <br>
 *
 * <hr>
 * Date created: 10/15/2015 <br>
 * Date last modified: 10/21/2015 <br>
 *
 * <hr>
 * Notes on specifications, special algorithms, and assumptions:
 * The main method should use a switch to process the user’s selections.
 * Note the messages used in the screen shots when freezing the screens.
 * The output should look similar to what is shown. It must include all of
 * the information shown but formatting is up to you. Make sure that
 * your output is neat, readable and understandable to the user.
 * The screen should be cleared before displaying the menu.
 * If an invalid selection is made, an appropriate error message should
 * be displayed.
 *
 * <hr>
 * @param String[] args - Command Line Arguments
 */
  public static void main(String[] args)
  {
    //create new Scanner
    Scanner kb = new Scanner(System.in);

    //***************************VARIABLE DECLARATIONS*************************
    //-------------------------------constants---------------------------------
    int FIXED_CURVE_POINTS = 10; //points applied in case 1
    double FIXED_CURVE_PERCENTAGE = .10; //percentage applied in case 2
    int MAX_GRADE = 100; //highest that the adjusted grade can be

    //-------------------------------input by user-----------------------------
    double originalGrade = 0; //original grade entered by user
    int menuSelection = 0; //menu selection chosen by user

    //--------------------------------calculated-------------------------------
    double adjustedGrade = 0; //grade after the curve is applied
    double curveApplied = 0; //amount of points added to original grade
    double percentageInPoints = 0;//number of points based on the percentage given

    //*************************INPUT - PROCESSING - OUTPUT*********************

    //Clear the screen
    clearScreen();

    //Prompt user to enter original grade
    originalGrade = inputGrade();

    //loop to return to menu if invalid selection
    do{

    //Clear the screen
    clearScreen();


    //Display Grade Adjuster Menu
    displayMenu();

    //Ask user for selection
    System.out.print("Enter your selection: ");
    menuSelection = kb.nextInt();

      //*****************************Calculations*******************************
      switch(menuSelection)
      {
        //case to add fixed number of points to original grade
        case 1:
                 curveApplied = FIXED_CURVE_POINTS;
                 adjustedGrade = applyCurve(originalGrade, curveApplied);
                 if(adjustedGrade >= MAX_GRADE)
                 {
                   adjustedGrade = MAX_GRADE;
                 }
                 displayAdjustedGrade(curveApplied, adjustedGrade);


                 //Freeze screen until user presses enter, then return to menu
                freezeScreen();

          break;

        //case to add fixed percentage of points to original grade
        case 2:
                curveApplied = originalGrade * FIXED_CURVE_PERCENTAGE;
                adjustedGrade = applyCurve(originalGrade, curveApplied);
                if(adjustedGrade >= MAX_GRADE)
                {
                  adjustedGrade = MAX_GRADE;
                }
                displayAdjustedGrade(curveApplied, adjustedGrade);


                //Freeze screen until user presses enter, then return to menu
               freezeScreen();

          break;

        //case to add number of points specified by the user
        case 3:
                curveApplied = getCurvePoints();
                adjustedGrade = applyCurve(originalGrade, curveApplied);
                if(adjustedGrade >= MAX_GRADE)
                {
                  adjustedGrade = MAX_GRADE;
                }
                displayAdjustedGrade(curveApplied, adjustedGrade);

                //Freeze screen until user presses enter, then return to menu
               freezeScreen();

          break;

        //case to add percentage of points that user entered
        case 4:
                curveApplied = percentageToPoints(percentageInPoints, originalGrade);
                adjustedGrade = applyCurve(originalGrade, curveApplied);
                if(adjustedGrade >= MAX_GRADE)
                {
                  adjustedGrade = MAX_GRADE;
                }
                displayAdjustedGrade(curveApplied, adjustedGrade);

                //Freeze screen until user presses enter, then return to menu
               freezeScreen();
          break;

        case 5:

          break;

        default:
                //display error message
                System.out.println("\nThat is not a valid choice...\n\n\n");

                //Freeze screen until user presses enter, then return to menu
                freezeScreen();

          break;
      }//end switch(menuSelection)
    }
    while(menuSelection != 5);
  }//end main

  /*****************************************************************************
 * Method Name: inputGrade <br>
 * Method Purpose: Method to ask the user for the original grade
 *
 * <br>
 *
 * <hr>
 * Date created: 10/15/2015 <br>
 * Date last modified: 10/20/2015 <br>
 *
 * <hr>
 * Notes on specifications, special algorithms, and assumptions:
 * Need to create a scanner and return a double
 *
 * <hr>
 * @return Returns the user's original grade
 */
  public static double inputGrade()
  {
    Scanner kb = new Scanner(System.in);
    System.out.print("What is the original grade? ");
    return kb.nextDouble();
  }//end inputGrade

  /*****************************************************************************
 * Method Name: displayMenu <br>
 * Method Purpose: Method to display the menu
 *
 * <br>
 *
 * <hr>
 * Date created: 10/15/2015 <br>
 * Date last modified: 10/21/2015 <br>
 *
 * <hr>
 * Notes on specifications, special algorithms, and assumptions:
 *
 * <hr>
 */
  public static void displayMenu()
  {
    System.out.println("           Grade Adjuster\n"
                    +  "          by Dakota Cowell\n"
                    +  "***********************************");
    System.out.println("1. Curve by 10 points");
    System.out.println("2. Curve by 10 percent");
    System.out.println("3. Curve by a given number of points");
    System.out.println("4. Curve by a given percentage");
    System.out.println("5. Quit\n");
  }//end displayMenu

  /*****************************************************************************
 * Method Name: freezeScreen <br>
 * Method Purpose: Method to freeze the screen
 *
 * <br>
 *
 * <hr>
 * Date created: 10/15/2015 <br>
 * Date last modified: 10/20/2015 <br>
 *
 * <hr>
 * Notes on specifications, special algorithms, and assumptions:
 *
 * <hr>
 */
  public static void freezeScreen()
  {
    Scanner kb = new Scanner(System.in);
        System.out.print("\n\n Press ENTER to return to the menu...");
        kb.nextLine();
  }//end freezeScreen


  //method to clear the screen
  /*****************************************************************************
 * Method Name: clearScreen <br>
 * Method Purpose: Method to clear the screen
 *
 * <br>
 *
 * <hr>
 * Date created: 10/15/2015 <br>
 * Date last modified: 10/20/2015 <br>
 *
 * <hr>
 * Notes on specifications, special algorithms, and assumptions:
 *
 * <hr>
 */
  public static void clearScreen()
  {
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
  }//end clearScreen


  /*****************************************************************************
 * Method Name: getCurvePoints <br>
 * Method Purpose: Method to get the number of points for the
 * curve to be applied
 * <br>
 *
 * <hr>
 * Date created: 10/15/2015 <br>
 * Date last modified: 10/21/2015 <br>
 *
 * <hr>
 * Notes on specifications, special algorithms, and assumptions:
 *
 * <hr>
 * @return Returns the number of points the user wants to curve by
 */
  public static double getCurvePoints()
  {
    Scanner kb = new Scanner(System.in);
    System.out.print("How many points should be applied to curve the grade? ");
    return kb.nextDouble();
  }//end getCurvePoints

  /*****************************************************************************
 * Method Name: getCurvePercentage <br>
 * Method Purpose: Method to get the percentage for the curve to be applied
 * <br>
 *
 * <hr>
 * Date created: 10/15/2015 <br>
 * Date last modified: 10/20/2015 <br>
 *
 * <hr>
 * Notes on specifications, special algorithms, and assumptions:
 *
 * <hr>
 * @return Returns the percentage the user wants to curve by
 */
  public static double getCurvePercentage()
  {
      Scanner kb = new Scanner(System.in);
      System.out.print("Enter the percentage of the curve:   (ex.  10% )"
                      +  "would be entered as .10)  ");

    return kb.nextDouble();
  }//end getCurvePercentage

  /*****************************************************************************
 * Method Name: getCurvePercentage <br>
 * Method Purpose: Method to calculate the number of points for the curve based
 * upon the percentage that has been selected
 * <br>
 *
 * <hr>
 * Date created: 10/15/2015 <br>
 * Date last modified: 10/20/2015 <br>
 *
 * <hr>
 * Notes on specifications, special algorithms, and assumptions:
 *
 * <hr>
 * @param percentageInPoints The number of points that the percentage is
 * @param originalGrade The original grade entered by the user
 * @return Returns the original grade * percentage entered by the user
 */
  public static double percentageToPoints(double percentageInPoints, double originalGrade)
  {
    percentageInPoints = getCurvePercentage() * originalGrade;
    return percentageInPoints;
  }//end percentageToPoints


  //method to apply the curve to the original grade

  /*****************************************************************************
 * Method Name: applyCurve <br>
 * Method Purpose: Method to apply the curve to the original grade
 * <br>
 *
 * <hr>
 * Date created: 10/15/2015 <br>
 * Date last modified: 10/21/2015 <br>
 *
 * <hr>
 * Notes on specifications, special algorithms, and assumptions:
 *
 * <hr>
 * @param originalGrade The original grade that the user entered
 * @param curveApplied The number of points added to the original grade
 * @return Returns the adjusted grade
 */

  public static double applyCurve(double originalGrade, double curveApplied)
  {
    return originalGrade + curveApplied;
  }

  /*****************************************************************************
 * Method Name: displayAdjustedGrade <br>
 * Method Purpose: Method to display the amount of points applied as the curve
 * and the new grade
 * <br>
 *
 * <hr>
 * Date created: 10/15/2015 <br>
 * Date last modified: 10/21/2015 <br>
 *
 * <hr>
 * Notes on specifications, special algorithms, and assumptions:
 * Make sure doubles display 2 decimal places
 *
 * <hr>
 * @param curveApplied How many points were added to the original grade
 * @param adjustedGrade Final grade after adding curve
 */
  public static void displayAdjustedGrade(double curveApplied, double adjustedGrade)
  {
    //create 2 decimal place format
    DecimalFormat twoDecimal = new DecimalFormat("#, ##0.00");//2 decimal places

    System.out.println("\n\n   Curve applied: " + twoDecimal.format(curveApplied)
                  +    " points\n");
    System.out.println("  Adjusted grade: " + twoDecimal.format(adjustedGrade));
  }


}//end Project3
