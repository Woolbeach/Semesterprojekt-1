import java.util.Scanner;

public class ticketBoothClass {
    private double price;
    private double balance;
    private double testBalance;
    private int ticketsSold;
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

    // Returns the price of a tickets current price
    public double getPrice() {
        return price;
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
        }else{
            System.out.println("Not enough balance");
        }
    }

    public void printTestTicket() {
        if(testBalance >= price){
            testBalance=testBalance-price;
            System.out.println("##########B##T#########");
            System.out.println("# Borgen Trafikselskab #");
            System.out.println("#                     #");
            System.out.println("#        Billet       #");
            System.out.println("#        " + price + " kr.       #");
            System.out.println("#                     #");
            System.out.println("# Du har "+ testBalance + " tilbage.   #");
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

    public double setTestBalance(int newBalance){
        return testBalance = newBalance;
    }

    //Returns collective sales as a double
    public double getSales() {
        return price * ticketsSold;
        }

    //Returns true if accessCode is correct
    public boolean accessCode(String code) {
        if (code.equals("1234")) {
            return true;
        }
        return false;
    }
}

