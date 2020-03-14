import java.io.IOException;
import java.util.ArrayList;

public class ticketBoothClass {
    public double balance;

    //variables for ticket booth
    public String code;
    public double moneyMade;

    //constructor with a standard password
    public ticketBoothClass(){
        code = "1234";
        addDefaultTickets();
    }

    //constructor with custom password
    public ticketBoothClass(String customcode){
        code = customcode;
        addDefaultTickets();
    }

    //object for handling transactions
    transactions transactionsHandler = new transactions();

    //creates basket for purchases
    ArrayList<ticketType> userBasket = new ArrayList<>();

    //ticket area*****************************************************************************************************************

    //default ticket types
    ticketType adult = new ticketType("Adult", 24, 1);
    ticketType child = new ticketType("Child", 12, 2);
    ticketType bicycle = new ticketType("Bike", 18, 3);
    ticketType elderly = new ticketType("Elderly", 12, 4);
    //de bliver tilføjet i et array, så kan man altid tilføje flere typer
    ArrayList<ticketType> ticketList = new ArrayList<ticketType>();

    public void addDefaultTickets(){
        ticketList.add(adult);
        ticketList.add(child);
        ticketList.add(bicycle);
        ticketList.add(elderly);
    }

    //method for adding new ticket types
    public void addTicket(String name,double price){
        int ticketListSize = ticketList.size()+1;
        System.out.println("listsize:"+ticketListSize);
        ticketType newtick = new ticketType(name,price,ticketListSize);
        ticketList.add(newtick);
    }

    //adds ticket to basket
    public void addTicketToBasket(int id, int amount){
        for (int i = 0; i < amount; i++) {
            userBasket.add(ticketList.get(id-1));
        }
    }

    //method for printing current ticket types
    public int printTicketTypes(){
        int amount = 0;
        for (ticketType ticket : ticketList){
            amount++;
            System.out.println(ticket.toString());
        }
        return amount;
    }

    //prints the contents of the basket
    public void itemsInBasket(){
        int ticketNumber = 1;
        for (ticketType currentItem : userBasket){
            System.out.println("#"+ticketNumber +"    1x"+ currentItem.basketString());
            ticketNumber++;
        }
    }

    // removes one ticket
    public void removeItemFromBasket(int index){
        if(userBasket.size()>=index && index > 0){
            userBasket.remove(index-1);         // -1 since we start in 0
        }
    }

    public void clearBasket(){
        userBasket.clear();
    }

    //returns the total price of the tickets in the basket
    public double basketPrice(){
        double totalPrice = 0;
        for (ticketType currentTicket : userBasket){
            totalPrice += currentTicket.price;
        }
        return totalPrice;
    }


    //method for checking out
    public void payingForTickets(){
        double basketP = basketPrice();
        balance -= basketP;
        moneyMade += basketP;
        for (ticketType currentTicket: userBasket) {
            currentTicket.printTicket();
            transactionsHandler.addTrans(currentTicket.price,currentTicket.id);
        }
        userBasket.clear();
        System.out.println("You get " + balance + " DKK in return!");
        if(balance!=0){
            transactionsHandler.addTrans(-balance,-2);
            balance = 0;
        }
    }
    //*****************************************************************************************************************


    //method for adding money to balance
    public void addBalance(double moneyin){
        if (moneyin > 0) {
            transactionsHandler.addTrans(moneyin,-1);
            balance += moneyin;
        } else {
            System.out.println("Invalid amount!");
        }
    }

    //returns current balance value
    public double getBalance() {
        return balance;
    }


    public void writeToLog() throws  IOException{
        transactionsHandler.writeLog();
    }

    //admin functionality*****************************************************************************************************************

    //returns true if accessCode is correct
    public boolean accessCode(String code1) {
        return code1.equals(code);
    }


    //method for changing the admin code
    public void changeCode(String newcode){
        code = newcode;
        System.out.println("Password has changed to: "+code);
    }

    //reads logfile and shows it to admin
    public void readLogFile() throws IOException {
        transactionsHandler.readLog();
    }

    //change price of given ticket id
    public void changeTicketPrice(int ticketID, double newPrice){
        for (ticketType currentTicket: ticketList) {
            if(ticketID == currentTicket.id){
                currentTicket.price = newPrice;
            }
        }
    }
    //print ticket of given ticket id
    public void printTicketByID(int id){
        for (ticketType currentTicket : ticketList){
            if(id == currentTicket.id){
                currentTicket.printTicket();
            }
        }
    }

    //prints total money made
    public void seeMoneyMade(){
        System.out.println("This machine has made: "+moneyMade+" DKK");
    }

    //search in log for given id
    public void searchByID(int newid){
        try{  //every time someone does something, it writes to the log
            transactionsHandler.findByID(newid);
        }catch(IOException e){
            System.err.println("error cant read log file");
        }
    }

    public void findMoneyIn_InRange(double min, double max){
        try{  //every time someone does something, it writes to the log
            transactionsHandler.findMoneyIn_InRange(min,max);
        }catch(IOException e){
            System.err.println("error cant read log file");
        }
    }

    public void findPayout_InRange(double min, double max){
        try{  //every time someone does something, it writes to the log
            transactionsHandler.findPayout_InRange(min,max);
        }catch(IOException e){
            System.err.println("error cant read log file");
        }
    }

    //*****************************************************************************************************************
}