
public class ticketBoothClass {
    private double price;
    private double balance;
    private int ticketsSold;

    // Returns the price of a tickets current price
    public double getPrice() {
        return price;
    }

    // Prints out a ticket and the price of the ticket
    public void printTicket() {
        System.out.println("##########B##T#########");  //
        System.out.println("# Borgen Trafikselskab #");
        System.out.println("#                     #");
        System.out.println("#        Billet       #");
        System.out.println("#        " + price + " kr.       #");
        System.out.println("#                     #");
        System.out.println("##########B##T#########");
        System.out.println("##########B##T#########");
        System.out.println();
    }
    //Constructor
    public ticketBoothClass(double ticketPrice, double startBalance) {
        price = ticketPrice;
        balance = startBalance;
        while (ticketPrice < 0 || startBalance < 0){            //Checks for valid price before implementing
            System.err.println("Invalid price and/or startBalance");

        }

    }

    //SetPrice method
    public void setPrice(String accessCode, double newPrice) {
        if (accessCode.equals("1234") && newPrice > 0) {            //if password is correct and price is > 0, the price is updated
            price = newPrice;
        }
        else System.err.println("Access denied - Wrong passcode and/or invalid price");
    }

    //Returns current balance value
    public double getBalance(){
        return balance;
    }

    //Returns collective sales as an integer
    public double getSales(String accessCode){


        if(accessCode.equals("1234")){          //if password is correct, the sales are returned
            return price*ticketsSold;
        }
        return 0;
    }
}