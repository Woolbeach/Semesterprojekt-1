import java.util.ArrayList;

public class ticketBoothClass {
    private double price;
    private double balance;
    private double testBalance;

    //variabler en ticketBooth skal have:
    public String code;
    public int ticketSales;
    public double moneyMade;

    //tilføjer et objekt der håndterer transactions
    transactions transactionsHandler = new transactions();

    ArrayList<basketItem> userBasket = new ArrayList<>();

    public void addTicketToBasket(int id, int amount){
        basketItem ticket = new basketItem(id,amount);
        userBasket.add(ticket);
    }

    public void itemsInBasket(){
        for (basketItem currentItem : userBasket){
            System.out.println(currentItem.toString());
        }
    }

    //her er billettyperne
    ticketType adult = new ticketType("Adult", 24, 1);
    ticketType child = new ticketType("Child", 12, 2);
    ticketType bicycle = new ticketType("Bike", 18, 3);
    ticketType elderly = new ticketType("Elderly", 12, 4);

    //de bliver tilføjet i et array, så kan man altid tilføje flere typer
    ArrayList<ticketType> ticketList = new ArrayList<ticketType>();

    //det skal gøres i en funktion af en eller anden grund..
    public void addPrevious(){
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



    //konstruktøren, opretter en ticketbooth med standard kode 1234
    public ticketBoothClass(){
        code = "1234";
    }

    //konstruktør med en selvvalgt kode
    public ticketBoothClass(String customcode){
        code = customcode;
    }


    //funktion som viser de billetyper der er:
    public void printTicketTypes(){
        for (ticketType ticket : ticketList){
            System.out.println(ticket.toString());
        }
    }


    //Prints out a test ticket
    public void printTestTicket() {
        if(testBalance >= price){
            testBalance+=-price;
            System.out.println("##########B##T#########");
            System.out.println("# Borgen Trafikselskab #");
            System.out.println("#                     #");
            System.out.println("#        Billet       #");
            System.out.println("#        " + price + " kr   .       #");
            System.out.println("#                     #");
            System.out.println("# Du har "+ testBalance + " kr. tilbage.   #");
            System.out.println("##########B##T#########");
            System.out.println("##########B##T#########");
            System.out.println();
        }else{
            System.out.println("Not enough balance");
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


    //Returns true if accessCode is correct
    public boolean accessCode(String code) {
        return code.equals("1234");
    }
}

