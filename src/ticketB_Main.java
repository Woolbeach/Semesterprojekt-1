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
        ticketBoothClass booth = new ticketBoothClass("1234");    //Create Booth object
        transactions trans = new transactions();
        booth.addPrevious();                            //Add default tickettypes
        int choice = 0;                                 //Menu choice integer
        final int exitProtocol = 5;                     //Menu #, exit menu
        int adminChoice = 0;                            //Admin menu choice integer
        final int adminExitProtocol = 5;                //Menu #, exit admin menu
        double salesWithCurrentPrice;                   //Save sales with the current price
        double testBalance = 0;                         //initialize variable



        while (choice != exitProtocol) {                //While menu choice is active



            //Prompt menu
            System.out.println("Please choose one of the following options");
            System.out.println(
                            "#1:  Buy ticket\n" +
                            "#2:  Ticket prices\n" +
                            "#3:  Check basket\n" +
                            "#4:  Admin menu\n" +
                            "#" + exitProtocol + ":  Exit\n"
            );

            choice = scanObj.nextInt();                 //Scan for menu choice

            switch (choice) {                           //Switch case begin
                case 1:
                    buyTickets:
                    while(true){
                        System.out.println("What type of ticket do you want?");
                        booth.printTicketTypes();
                        int wantedTicket = scanObj.nextInt();
                        System.out.println("How many?:");
                        int ticketAmount = scanObj.nextInt();
                        booth.addTicketToBasket(ticketAmount,wantedTicket);

                        System.out.println("You have these tickets in your basket:");
                        booth.basketTickets();

                        //keep adding tickets until No is pressed/type
                            System.out.println("Buy more tickets? Y/N");
                        addmore:
                        while (true){
                            switch (scanObj.next()){
                                case "Y":{
                                    break addmore;
                                }
                                case "N":{
                                    choice = 1;
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
                case 2:                                 //Print ticket price
                    try{
                        trans.findPurchase(90);
                    }catch(IOException e){
                        System.out.println(":D");
                    }


                    break;
                case 3:                                 //Print balance
                    try {
                        trans.logToArray();
                    }catch (IOException e){
                        System.out.println("hi");
                    }
                    break;
                case 4:                                 //Admin menu
                    System.out.println("Please enter password");        //Prompt instructions
                    scanObj.nextLine();                                 //Remove newLine from earlier
                    String password = scanObj.nextLine();               //Scan for password

                    if(booth.accessCode(password) == true){             //If password is correct
                        System.out.println("Access granted");


                        while(adminChoice != adminExitProtocol){        //While admin menu is active
                            //Prompt admin menu
                            System.out.println("Please choose one of the following options");
                            System.out.println(
                                    "#1:  Get sales\n" +
                                            "#2:  Set price\n" +
                                            "#3:  Insert test balance\n" +
                                            "#4:  Print test-ticket\n" +
                                            "#" + adminExitProtocol + "  Exit"
                            );

                            adminChoice = scanObj.nextInt();        //Scan for admin menu choice

                            switch(adminChoice){                    //Switch case begin
                                case 1:                             //Get sales
                                    System.out.println("Sales: " + " DKK");
                                    break;
                                case 2:                             //New price
                                    System.out.println("Insert new price in DKK");
                                    break;
                                case 3:                             //Insert test balance
                                    System.out.println("Insert test balance");
                                    testBalance += booth.setTestBalance(scanObj.nextInt());
                                    break;
                                case 4:                             //Print test ticket
                                    booth.printTestTicket();
                                    break;
                                case adminExitProtocol:             //Exit
                                    System.out.println("Goodbye!");
                                    break;
                                default:                            //Unknown command
                                    System.err.println("Unknown command, please try again");
                            }
                        }
                        adminChoice = 0;                            //reset adminChoice
                    }else{                                          //if password is not correct
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

/*
Krav fra opgaveformuleringen:
K1) Når en automat opstilles på en station skal installatøren kunne angive prisen per billet.
K2) Automaten skal kunne fortælle kunden, hvad en billet koster.
K3) Automaten skal kunne udskrive en billet mærket med BT's logo.
K4) Automaten vil til enhver tid kunne vise kunden balancen, dvs hvor mange penge kunden har puttet i automaten.
K5) Ved opstilling kan installatøren angive en startbalance, sådan at installatøren kan udskrive en
eller flere test-billetter uden at skulle putte penge i automaten.
K6) Hver nat skal en medarbejder med en særlig kode kunne aflæse det samlede salg (beløb i kroner)
og justere billetprisen (i tilfælde af prisstigninger).
K7) EGEN KRAV
K8) EGEN KRAV
K9) EGEN KRAV
K10) Automaten skal logge alle handlinger, såsom indkast af penge, udskrivning af billet og udbetaling af returbeløb
K11) Når montøren er logget ind skal automaten kunne udskrive en log med alle de transaktioner der har været siden sidst.
K12) Automatens transaktionslog skal kunne filtreres efter tidspunkt, handling og beløb.
f.eks automat.findTilbagebetalinger(), automat.indkastedeBeløbOverKr(500),
K13) Automaten skal kunne håndtere nogle forskellige billettyper.
K14) EGEN KRAV
 */

