/*--------------------------------------------------------------------------------
|   Group members:  Christian Ulstrand (s195162), Filip Kristiansen (s195169), Jonas Gehrke (s195155) & Emil Overgaard (s195172)
|   Project:        TicketBooth
|   Class purpose:  Main class
 --------------------------------------------------------------------------------*/

import java.io.IOException;
import java.util.Scanner;                       //Import scanner

public class ticketB_Main {

    public static void main(String[] args) {
        Scanner scanObj = new Scanner(System.in);       //Create scanner object
        ticketBoothClass booth = new ticketBoothClass("1234");    //Create Booth object with code 1234

        int choice = 0;                                 //Menu choice integer
        int adminChoice = 0;
        double salesWithCurrentPrice;                   //Save sales with the current price
        double testBalance = 0;                         //initialize variable


        boolean runprogram = true;
        while (runprogram) {                //While menu choice is active

            //Prompt menu
            System.out.println("Please choose one of the following options");
            System.out.println(
                            "#1:\tBuy ticket\n" +
                            "#2:\tTicket prices\n" +
                            "#3:\tAdd balance\n"+
                            "#4:\tCheckout\n" +
                            "#5:\tView you basket\n"+
                            "#6:\tAdmin menu\n" +
                            "#10:\tExit\n"
            );

            choice = scanObj.nextInt();                 //Scan for menu choice
            scanObj.nextLine();

            switch (choice) {                           //Switch case begin
                case 1:{
                    buyTickets:
                    while(true){
                        System.out.println("What type of ticket do you want?");
                        int tickettypes = booth.printTicketTypes();
                        int wantedTicket = scanObj.nextInt();
                        if (wantedTicket > tickettypes || wantedTicket < 1){
                            System.out.println("Not a valid choice!");
                            break buyTickets;
                        }
                        System.out.println("How many?:");
                        int ticketAmount = scanObj.nextInt();
                        booth.addTicketToBasket(wantedTicket,ticketAmount);



                        //keep adding tickets until No is pressed/type
                        System.out.println("Add more tickets? Y/N");
                        addmore:
                        while (true){
                            switch (scanObj.next().toLowerCase()){
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



                    //trans.addTrans(20,1);
                    /*
                    try{
                        trans.writeLog();
                    }catch(IOException e){
                        System.err.println("error cant write to log file");
                    }*/
                    break;
                }

                case 2: {
                    //Print ticket price
                    booth.printTicketTypes();
                    break;
                }

                case 3: {
                    System.out.println("Your current balance is: "+booth.getBalance() + " DKK");
                    System.out.println("Insert money: ");
                    double moneyin = scanObj.nextDouble();
                    scanObj.nextLine();
                    booth.addBalance(moneyin);
                    System.out.println("Your balance is now: "+booth.getBalance()+" DKK");
                    break;
                }

                case 4:{
                    System.out.println("You have these tickets in your basket:");
                    booth.itemsInBasket();
                    System.out.println("They will cost: " + booth.basketPrice() + " DKK");
                    System.out.println("Your balance: " + booth.getBalance());
                    System.out.println("Are you sure you want to check out? Y/N");
                    boolean checkout = false;
                    outer:
                    while (true){
                        switch (scanObj.nextLine().toLowerCase()){
                            case "y":{
                                checkout = true;
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

                    if(checkout){
                        if(booth.getBalance() >= booth.basketPrice()){
                            System.out.println("Printing tickets..");
                            booth.payingForTickets();
                        } else {
                            System.out.println("You dont have enough money, please add to balance!");
                        }
                    }
                    break;
                }

                case 5:{

                }

                case 6: {
                    //Admin menu
                    System.out.println("Please enter password:");        //Prompt instructions
                    String password = scanObj.nextLine();               //Scan for password

                    if(booth.accessCode(password)){             //If password is correct
                        System.out.println("Access granted");
                        boolean adminAccess = true;

                        while(adminAccess){        //While admin menu is active
                            //Prompt admin menu
                            System.out.println("Please choose one of the following options");
                            System.out.println(
                                            "#1:  Read log\n" +
                                            "#2:  Set price for ticket\n" +
                                            "#3:  Add new ticket\n" +
                                            "#4:  Insert test balance\n" +
                                            "#5:  Print test-ticket\n" +
                                            "#10:  Exit Admin Menu"
                            );

                            adminChoice = scanObj.nextInt();        //Scan for admin menu choice

                            switch(adminChoice){                    //Switch case begin
                                case 1: {                            //Get sales
                                    try {
                                        booth.readLogFile();
                                    } catch (IOException e) {
                                        System.err.println("error cant write to log file");
                                    }
                                    break;
                                }
                                case 2: {                           //New price
                                    booth.printTicketTypes();
                                    System.out.println("What ticket do you want to change the price for?");
                                    int whatticket = scanObj.nextInt();
                                    System.out.println("To what price?");
                                    double newprice = scanObj.nextDouble();
                                    booth.changeTicketPrice(whatticket, newprice);
                                    System.out.println("Great! Now tickets look like this:");
                                    booth.printTicketTypes();
                                    break;
                                }
                                case 3: {                         //Insert test balance
                                    System.out.println("Insert test balance");
                                    testBalance += booth.setTestBalance(scanObj.nextInt());
                                    break;
                                }
                                case 4: {                          //Print test ticket
                                    //booth.printTestTicket();
                                    break;
                                }
                                case 5:{
                                    System.out.println("These are the available tickets:");
                                    booth.printTicketTypes();
                                    System.out.println("What ticket do you want to print?");
                                    int ticketID = scanObj.nextInt();
                                    booth.printTicketByID(ticketID);
                                    break;
                                }

                                case 10:{             //Exit
                                    System.out.println("Goodbye admin!");
                                    adminAccess = false;
                                    break;
                                }
                                case 7:{
                                    System.out.println("ID types: \n-2 = payback\n-1 = money input\n>0 = what type of ticket");
                                    System.out.println("Search by id type:");
                                    int newid = scanObj.nextInt();
                                    booth.searchByID(newid);
                                    break;
                                }
                                default:  {                          //Unknown command
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
                    //Exit
                    System.out.println("Goodbye!");
                    runprogram = false;
                    break;
                }

                default:                                //Unknown command
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

/*
Krav fra opgaveformuleringen:
K1) Når en automat opstilles på en station skal installatøren kunne angive prisen per billet. TJEK
K2) Automaten skal kunne fortælle kunden, hvad en billet koster. TJEK
K3) Automaten skal kunne udskrive en billet mærket med BT's logo.
K4) Automaten vil til enhver tid kunne vise kunden balancen, dvs hvor mange penge kunden har puttet i automaten.
K5) Ved opstilling kan installatøren angive en startbalance, sådan at installatøren kan udskrive en
eller flere test-billetter uden at skulle putte penge i automaten. SEMI-TJEK
K6) Hver nat skal en medarbejder med en særlig kode kunne aflæse det samlede salg (beløb i kroner)
og justere billetprisen (i tilfælde af prisstigninger).
K7) EGEN KRAV
K8) EGEN KRAV
K9) EGEN KRAV
K10) Automaten skal logge alle handlinger, såsom indkast af penge, udskrivning af billet og udbetaling af returbeløb TJEK
K11) Når montøren er logget ind skal automaten kunne udskrive en log med alle de transaktioner der har været siden sidst. SEMI-TJEK
K12) Automatens transaktionslog skal kunne filtreres efter tidspunkt, handling og beløb. SEMI-TJEK
f.eks automat.findTilbagebetalinger(), automat.indkastedeBeløbOverKr(500),
K13) Automaten skal kunne håndtere nogle forskellige billettyper. TJEK
K14) EGEN KRAV
 */

