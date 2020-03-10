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
    }

    //konstruktør med en selvvalgt kode
    public ticketBoothClass(String customcode){
        code = customcode;
    }

    //tilføjer et objekt der håndterer transactions
    transactions transactionsHandler = new transactions();

    //laver en kurv hvor brugeren kan putte sin ønskede billeter i
    ArrayList<ticketType> userBasket = new ArrayList<>();


    //billeter
    //*****************************************************************************************************************
    //tilføjer billeter til userBasket som er kurven
    public void addTicketToBasket(int id, int amount){
        for (int i = 0; i < amount; i++) {
            userBasket.add(ticketList.get(id-1));
        }
    }

    //printer de billeter brugeren har i kruven
    public void itemsInBasket(){
        double totalPrice = 0;
        for (ticketType currentItem : userBasket){
            System.out.println(currentItem.toString());
        }
    }

    //returner prisen på de billeter der er i kurven
    public double basketPrice(){
        double totalPrice = 0;
        for (ticketType currentTicket : userBasket){
           totalPrice += currentTicket.price;
        }
        return totalPrice;
    }

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

    //funktion som viser de billetyper der er:
    public int printTicketTypes(){
        int amount = 0;
        for (ticketType ticket : ticketList){
            amount++;
            System.out.println(ticket.toString());
        }
        return amount;
    }


    //funktion som betaler, returner penge og fjerner billerterne fra kurven
    public void payingForTickets(){
        double basketP = basketPrice();
        balance -= basketP;
        moneyMade += basketP;
        for (ticketType currentTicket: userBasket) {
            currentTicket.printTicket();
        }
        userBasket.removeAll(userBasket);
        System.out.println("You get " + balance + " DKK in return!");
        transactionsHandler.addTrans(-balance,-2);
        balance = 0;
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

    //function for changing the admin code
    public void changeCode(String newcode){
        code = newcode;
    }


    //Returns true if accessCode is correct
    public boolean accessCode(String code1) {
        return code1.equals(code);
    }
}

