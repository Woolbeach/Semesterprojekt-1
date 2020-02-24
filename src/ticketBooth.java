/*--------------------------------------------------------------------------------
|   Group members:  Christian Ulstrand (s195162), Filip Kristiansen (s195169) & Jonas Gehrke (s195155)
|   Project:        ticketBooth
|   Class purpose:  Main class
 --------------------------------------------------------------------------------*/

import java.util.Scanner;                       //Import scanner

public class ticketBooth {
    public static void main(String[] args) {
        Scanner scanObj = new Scanner(System.in);       //Create scanner object
        ticketBoothClass booth = new ticketBoothClass(24, 0);    //Create Booth object
        int choice = 0;                                 //Menu choice integer
        final int exitProtocol = 5;                     //Menu #, exit menu
        int adminChoice = 0;
        final int adminExitProtocol = 4;

        System.out.println("Welcome!");                 //Welcome prompt

        while (choice != exitProtocol) {                  //While menu choice is active

            //Prompt menu
            System.out.println("Please choose one of the following options");
            System.out.println(
                    "#1:  Case1\n" +
                            "#2:  Ticket price\n" +
                            "#3:  Check balance\n" +
                            "#" + exitProtocol + ":  Exit\n"
            );

            choice = scanObj.nextInt();                 //Scan for menu choice

            switch (choice) {                             //Switch case begin
                case 1:                                 //Print ticket
                    System.out.println("Printing ticket");
                    booth.printTicket();
                    break;
                case 2:                                 //Print ticket price
                    System.out.println("Ticket price is: " + booth.getPrice() + " DKK");
                    break;
                case 3:                                 //Print balance
                    System.out.println("Your balance is: " + booth.getBalance() + " DKK");
                    break;
                case 4:
                    System.out.println("Admin menu");
                    System.out.println("Please enter password");
                    scanObj.nextLine();
                    String password = scanObj.nextLine();

                    if(booth.accessCode(password) == true){
                        System.out.println("Access granted");
                        System.out.println("Please choose one of the following options");
                        System.out.println(
                                "#1:  Case1" +
                                        "#2:  Case2" +
                                        "#3:  Case3"
                        );
                        while(adminChoice != adminExitProtocol){
                            switch(adminChoice){
                                case 1:
                                    System.out.println("Case 1");
                                    break;
                                case 2:
                                    System.out.println("Case 2");
                                    break;
                                case 3:
                                    System.out.println("Case 3");
                                    break;
                                case adminExitProtocol:
                                    System.out.println("Goodbye!");
                                    break;
                                default:
                                    System.err.println("Unknown command, please try again");
                            }
                        }
                    }else{
                        System.out.println("Wrong password");
                    }
                    break;
                case exitProtocol:                      //Exit
                    System.out.println("Goodbye!");
                    break;
                default:                                //Unknown command
                    System.err.println("Unknown command, please try again");
            }
        }
    }
}

