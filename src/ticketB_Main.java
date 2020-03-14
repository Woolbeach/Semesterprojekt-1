/*--------------------------------------------------------------------------------
|   Group members:  Christian Ulstrand (s195162), Filip Kristiansen (s195169), Jonas Gehrke (s195155) & Emil Overgaard (s195172)
|   Project:        TicketBooth
|   Class purpose:  Main class
 --------------------------------------------------------------------------------*/

import java.io.IOException;
import java.util.Scanner;                       //import scanner

public class ticketB_Main {

    public static void main(String[] args) {
        Scanner scanObj = new Scanner(System.in);       //create scanner object
        ticketBoothClass booth = new ticketBoothClass("1234");    //create Booth object with code 1234

        int choice;                                 //menu choice integer
        int adminChoice;

        boolean runprogram = true;
        while (runprogram) {                //while bool is true is active

            //prompt menu
            System.out.println("\n\nPlease choose one of the following options");
            System.out.println(
                            "#1: \tBuy ticket\n" +
                            "#2: \tTicket prices\n" +
                            "#3: \tAdd/View balance\n"+
                            "#4: \tView your basket\n"+
                            "#5: \tRemove item from basket\n"+
                            "#6: \tClear basket\n"+
                            "#7: \tCheckout\n" +

                            "#8: \tAdmin menu\n" +
                            "#10:\tExit\n"
            );

            choice = scanObj.nextInt();                 //scan for menu choice
            scanObj.nextLine();

            switch (choice) {                           //switch case begin
                case 1:{ //buy ticket case
                    buyTickets:
                    while(true){
                        System.out.println("What type of ticket do you want?");     //prompt instructions
                        int tickettypes = booth.printTicketTypes();                 //read ticket type
                        int wantedTicket = scanObj.nextInt();                       //scans
                        if (wantedTicket > tickettypes || wantedTicket < 1){        //if ticket is not valid
                            System.out.println("Not a valid choice!");
                            break buyTickets;
                        }
                        System.out.println("How many?:");                           //prompt instructions
                        int ticketAmount = scanObj.nextInt();                       //scan
                        booth.addTicketToBasket(wantedTicket,ticketAmount);         //adds ticket(s) to basket



                        //keep adding tickets until No is pressed/typed
                        System.out.println("Add more tickets? Y/N");                //prompt instruction
                        addmore:
                        while (true){

                            switch (scanObj.next().toLowerCase()){                  //yes or no
                                case "y":{
                                    break addmore;
                                }
                                case "n":{
                                    break buyTickets;
                                }
                                default:{
                                    System.out.println("Not a valid choice, try again!");
                                    break;
                                }
                            }
                        }
                    }
                    break;
                }
                case 2: {
                    //print ticket price
                    booth.printTicketTypes();               //print
                    break;
                }
                case 3: { //view balance case
                    System.out.println("Your current balance is: "+booth.getBalance() + " DKK");    //prompt balance
                    System.out.println("Insert money: ");
                    double moneyin = scanObj.nextDouble();                                          //scan for inserted money
                    scanObj.nextLine();
                    booth.addBalance(moneyin);                                                      //adds inserted money to balance
                    System.out.println("Your balance is now: "+booth.getBalance()+" DKK");          //print new balance
                    break;
                }
                case 4:{ //view basket
                    System.out.println("You have these tickets in your basket:");
                    booth.itemsInBasket();                                                          //prints current shopping cart
                    System.out.println("Your balance is: " + booth.getBalance() + " DKK");
                    break;
                }
                case 7:{ //checkout case
                    System.out.println("You have these tickets in your basket:");
                    booth.itemsInBasket();                                                          //prints current shopping cart
                    System.out.println("They will cost: " + booth.basketPrice() + " DKK");          //total price
                    System.out.println("Your balance: " + booth.getBalance());                      //balance
                    System.out.println("Are you sure you want to check out? Y/N");
                    boolean checkout = false;
                    outer:
                    while (true){
                        switch (scanObj.nextLine().toLowerCase()){                                  //yes/no checkout
                            case "y":{
                                checkout = true;                                                    //set bool
                                break outer;
                            }
                            case "n":{
                                break outer;
                            }
                            default:{
                                System.out.println("Not a valid choice, try again!");
                                break;
                            }
                        }
                    }
                    if(checkout){                                                                       //if bool is set true
                        if(booth.getBalance() >= booth.basketPrice()){                                  //if balance is larger or equal to basket
                            System.out.println("Printing tickets..");
                            booth.payingForTickets();                                                   //pays for tickets and transaction complete
                        } else {                                                                        //not enough balance
                            System.out.println("You dont have enough money, please add to balance!");
                        }
                    }
                    break;
                }
                //removes ticket from basket
                case 5:{
                    System.out.println("Please write what ticket you want discarded from the basket");
                    booth.itemsInBasket();                                                              //show all items in basket
                    booth.removeItemFromBasket(scanObj.nextInt());                                      //scans for item to remove
                    break;
                }

                case 6:{ //clear basket case
                    booth.clearBasket();                                                                //clean basket
                    System.out.println("Basket has been cleared.");
                    break;
                }

                case 8: {
                    //admin menu
                    System.out.println("Please enter password:");        //prompt instructions
                    String password = scanObj.nextLine();               //scan for password

                    if(booth.accessCode(password)){             //if password is correct
                        System.out.println("Access granted");
                        boolean adminAccess = true;             //set bool true

                        while(adminAccess){        //while admin menu is active
                            //prompt admin menu
                            System.out.println("\n\nPlease choose one of the following options");
                            System.out.println(
                                            "#1: \tRead log\n" +
                                            "#2: \tSet price for ticket\n" +
                                            "#3: \tAdd new ticket\n" +
                                            "#4: \tPrint test-ticket\n" +
                                            "#5: \tSearch in log by ID type\n"+
                                            "#6: \tSearch in log for moneyinputs within range\n"+
                                            "#7: \tSearch in log for paybacks within range\n"+
                                            "#8: \tSee how much the ticketbooth has made\n"+
                                            "#9: \tChange admin password\n"+
                                            "#10:\tExit Admin Menu"
                            );

                            adminChoice = scanObj.nextInt();        //scan for admin menu choice

                            switch(adminChoice){                    //switch case begin
                                case 1: {                            //get sales
                                    try {
                                        booth.readLogFile();        //read all sales
                                    } catch (IOException e) {
                                        System.err.println("error cant write to log file");
                                    }
                                    break;
                                }
                                case 2: {                           //new price
                                    booth.printTicketTypes();                   //print all tickets
                                    System.out.println("What ticket do you want to change the price for?");
                                    int whatticket = scanObj.nextInt();         //scans for ticket type
                                    System.out.println("To what price?");
                                    double newprice = scanObj.nextDouble();     //new price
                                    booth.changeTicketPrice(whatticket, newprice);  //change ticket
                                    System.out.println("Great! Now tickets look like this:");
                                    booth.printTicketTypes();                   //print all tickets (updated)
                                    break;
                                }
                                case 3:{
                                    System.out.println("Creating new ticket:\nPlease enter a name:");
                                    scanObj.nextLine();
                                    String nameForTicket = scanObj.nextLine();          //scan for ticket name
                                    System.out.println("Now enter a price for this ticket:");
                                    double priceForTicket = scanObj.nextDouble();       //scan for ticket price
                                    booth.addTicket(nameForTicket,priceForTicket);      //create ticket
                                    System.out.println("These are now the available tickets:");
                                    booth.printTicketTypes();                           //print all tickets
                                    break;
                                }
                                case 4:{
                                    System.out.println("These are the available tickets:");
                                    booth.printTicketTypes();                           //shows all ticket types
                                    System.out.println("What ticket do you want to print?");
                                    int ticketID = scanObj.nextInt();                   //choose what ticket to print
                                    booth.printTicketByID(ticketID);                    //prints ticket
                                    break;
                                }
                                case 5:{
                                    System.out.println("ID types: \n-2 = payback\n-1 = money input\n>0 = what type of ticket");
                                    System.out.println("Search by id type:");
                                    int newid = scanObj.nextInt();                      //scan for id
                                    booth.searchByID(newid);                            //searches for id
                                    break;
                                }
                                case 6:{
                                    System.out.println("Enter minimum:");
                                    double min = scanObj.nextDouble();                  //scan for minimum
                                    System.out.println("Enter maximum:");
                                    double max = scanObj.nextDouble();                  //scan for maximum
                                    booth.findMoneyIn_InRange(min,max);                 //find between min-max
                                    break;
                                }
                                case 7:{
                                    System.out.println("When entering minimum and maximum, keep in mind the payouts are a negative value.");
                                    System.out.println("Enter minimum:");
                                    double min = scanObj.nextDouble();                  //scan for minimum
                                    System.out.println("Enter maximum:");
                                    double max = scanObj.nextDouble();                  //scan for maximum
                                    booth.findPayout_InRange(min,max);                  //find between min-max
                                    break;
                                }

                                case 8:{
                                    booth.seeMoneyMade();                               //print money made
                                    break;
                                }

                                case 9:{
                                    scanObj.nextLine();
                                    System.out.println("Please type the new password:");
                                    String newcode = scanObj.nextLine();                //scan for new password
                                    booth.changeCode(newcode);                          //change password
                                    break;
                                }

                                case 10:{             //Exit
                                    System.out.println("Goodbye admin!");
                                    adminAccess = false;                                //shut down admin menu
                                    break;
                                }

                                default:  {                          //unknown command
                                    System.err.println("Unknown command, please try again");
                                }
                            }
                        }
                        adminChoice = 0;                            //reset adminChoice
                    }else{                                          //if password is not correct
                        System.out.println("Wrong password");
                    }
                    break;
                }


                case 10:   {
                    //exit
                    System.out.println("Goodbye!");
                    runprogram = false;                             //shut down program
                    break;
                }

                default:                                //unknown command
                    System.err.println("Unknown command, please try again");
                }

            try{  //every time someone does something, it writes to the log
                booth.writeToLog();
            }catch(IOException e){
                System.err.println("error cant write to log file");
            }
        }
    }
}