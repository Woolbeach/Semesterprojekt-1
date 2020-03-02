import java.util.Scanner;

public class ticketBoothClass {
    private double price;
    private double balance;
    private double testBalance;
    private int ticketsSold;
    private double moneyMade;

    ticketType adult = new ticketType("Adult", 24, 1);
    ticketType child = new ticketType("Child", 12, 2);
    ticketType bicycle = new ticketType("Bike", 18, 3);
    ticketType elderly = new ticketType("Elderly", 12, 4);


    //Constructor
    java.util.Scanner scanObj = new java.util.Scanner(System.in);

    public ticketBoothClass(double ticketPrice, double startBalance) {
        price = ticketPrice;
        balance = startBalance;
        while (price < 0 || balance < 0) {            //Checks for valid price before implementing
            System.err.println("Invalid price and/or startBalance");
            price = scanObj.nextDouble();
            balance = scanObj.nextDouble();
        }
    }



    // Prints out a ticket and the price of the ticket
    public void printTicket() {
        if(balance >= price){
            ticketsSold++;
            balance=balance-price;
            System.out.println("##########B##T#########");
            System.out.println("# Borgen Trafikselskab #");
            System.out.println("#                     #");
            System.out.println("#        Billet       #");
            System.out.println("#        " + price + " kr.       #");
            System.out.println("#                     #");
            System.out.println("# Du har "+ balance + " tilbage.   #");
            System.out.println("##########B##T#########");
            System.out.println("##########B##T#########");
            System.out.println();
            moneyMade+=price; //tilføjer prisen på billet til totalt beløb af penge der er tjent
        }else{
            System.out.println("Not enough balance");
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

    //SetPrice method
    public void setPrice(double newPrice) {
        if (newPrice > 0) {            //if password is correct and price is > 0, the price is updated
            price = newPrice;
        } else System.err.println("Access denied - Invalid price");
    }

    //Returns current balance value
    public double getBalance() {
        return balance;
    }

    //Returns a test balance
    public double setTestBalance(int newBalance){
        return testBalance += newBalance;
    }

    //Returns collective sales as a double
    public double getSales() {
        return price * ticketsSold;
        }
    
    public double getMoneymade(){
        return moneyMade;
    }

    //Returns true if accessCode is correct
    public boolean accessCode(String code) {
        if (code.equals("1234")) {
            return true;
        }
        return false;
    }
}

