import java.io.IOException;
import java.util.ArrayList;

public class ticketBoothClass {
    public double balance;
    private double testBalance;

    //variabler en ticketBooth skal have:
    public String code;
    public int ticketSales;
    public double moneyMade;


    //konstruktøren, opretter en ticketbooth med standard kode 1234
    public ticketBoothClass(){
        code = "1234";
        addDefaultTickets();
    }

    //konstruktør med en selvvalgt kode
    public ticketBoothClass(String customcode){
        code = customcode;
        addDefaultTickets();
    }

    //tilføjer et objekt der håndterer transactions
    transactions transactionsHandler = new transactions();

    //laver en kurv hvor brugeren kan putte sin ønskede billeter i
    ArrayList<ticketType> userBasket = new ArrayList<>();


    //billet område*****************************************************************************************************************

    //her er default-billettyperne
    ticketType adult = new ticketType("Adult", 24, 1);
    ticketType child = new ticketType("Child", 12, 2);
    ticketType bicycle = new ticketType("Bike", 18, 3);
    ticketType elderly = new ticketType("Elderly", 12, 4);

    //de bliver tilføjet i et array, så kan man altid tilføje flere typer
    ArrayList<ticketType> ticketList = new ArrayList<ticketType>();

    //det skal gøres i en funktion af en eller anden grund..
    public void addDefaultTickets(){
        ticketList.add(adult);
        ticketList.add(child);
        ticketList.add(bicycle);
        ticketList.add(elderly);
    }


    //metode til at tilføje en ny billettype
    public void addTicket(String name,int price,int id){
        ticketType newtick = new ticketType(name,price,id);
        ticketList.add(newtick);
    }


    //tilføjer billetter til userBasket som er kurven
    public void addTicketToBasket(int id, int amount){
        for (int i = 0; i < amount; i++) {
            userBasket.add(ticketList.get(id-1));
        }
    }


    //funktion som viser de billetyper der er:
    public int printTicketTypes(){
        int amount = 0;
        for (ticketType ticket : ticketList){
            amount++;
            System.out.println(ticket.toString());
        }
        return amount;
    }


    //printer de billetter brugeren har i kruven
    public void itemsInBasket(){
        int ticketNumber = 1;
        for (ticketType currentItem : userBasket){
            System.out.println("#"+ticketNumber +"    1x"+ currentItem.basketString());
            ticketNumber++;
        }
    }


    //returner prisen på de billetter der er i kurven
    public double basketPrice(){
        double totalPrice = 0;
        for (ticketType currentTicket : userBasket){
            totalPrice += currentTicket.price;
        }
        return totalPrice;
    }


    //funktion som betaler, returner penge og fjerner billetterne fra kurven
    public void payingForTickets(){
        double basketP = basketPrice();
        balance -= basketP;
        moneyMade += basketP;
        for (ticketType currentTicket: userBasket) {
            currentTicket.printTicket();
            transactionsHandler.addTrans(0,currentTicket.id);
        }
        userBasket.removeAll(userBasket);
        System.out.println("You get " + balance + " DKK in return!");
        if(balance!=0){
            transactionsHandler.addTrans(-balance,-2);
            balance = 0;
        }
    }
    //*****************************************************************************************************************


    //function for adding money to balance
    public void addBalance(double moneyin){
        if (moneyin > 0) {
            transactionsHandler.addTrans(moneyin,-1);
            balance += moneyin;
        } else {
            System.out.println("Invalid amount!");
        }
    }

    //Returns current balance value
    public double getBalance() {
        return balance;
    }

    //Returns a test balance
    public double setTestBalance(int newBalance){
        return testBalance += newBalance;
    }



    public void writeToLog() throws  IOException{
        transactionsHandler.writeLog();
    }





    //admin funktioner*****************************************************************************************************************

    //Returns true if accessCode is correct
    public boolean accessCode(String code1) {
        return code1.equals(code);
    }


    //function for changing the admin code
    public void changeCode(String newcode){
        code = newcode;
    }


    public void printCurrentLog(){
        transactionsHandler.printLog();
    }

    public void readLogFile() throws IOException {
        transactionsHandler.readLog();
    }


    public void changeTicketPrice(int ticketID, double newPrice){
        for (ticketType currentTicket: ticketList) {
            if(ticketID == currentTicket.id){
                currentTicket.price = newPrice;
            }
        }
    }

    public void printTicketByID(int id){
        for (ticketType currentTicket : ticketList){
            if(id == currentTicket.id){
                currentTicket.printTicket();
            }
        }
    }


    public void searchByID(int newid){
        try{  //every time someone does something, it writes to the log
            transactionsHandler.findPayback();
        }catch(IOException e){
            System.err.println("error cant read log file");
        }
    }

    //*****************************************************************************************************************
}

