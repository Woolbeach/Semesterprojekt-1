/*--------------------------------------------------------------------------------
|   Group members:  Christian Ulstrand (s195162), Filip Kristiansen (s195169) & Jonas Gehrke (s195155)
|   Project:        Billetautomat
|   Class purpose:  Main class
 --------------------------------------------------------------------------------*/
import java.util.Scanner;                       //Import scanner
public class Billetautomat {
    public static void main(String[] args) {
        Scanner scanObj = new Scanner(System.in);       //Create scanner object
        int choice = 0;                                 //Menu choice integer
        final int exitProtocol = 4;                           //Menu #, exit menu

        System.out.println("Welcome!");                 //Welcome prompt

        while(choice != exitProtocol){                  //While menu choice is active

            //Prompt menu
            System.out.println("Please choose one of the following options");
            System.out.println(
                    "#1:  Case1\n" +
                    "#2:  Case2\n" +
                    "#3:  Case3\n" +
                    "#4:  Exit\n"
            );

            choice = scanObj.nextInt();                 //Scan for menu choice

            switch(choice){                             //Switch case begin
                case 1:                                 //Case1
                    System.out.println("Case 1");
                    break;
                case 2:                                 //Case2
                    System.out.println("Case 2");
                    break;
                case 3:                                 //Case3
                    System.out.println("Case 3");
                    break;
                case exitProtocol:                      //Exit
                    System.out.println("Goodbye!");
                    break;
                default:                                //Unknown command
                    System.out.println("Unknown command, please try again");
            }
        }
    }
}
