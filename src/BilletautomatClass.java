
public class BilletautomatClass {
    private double price;
    private double balance;
    private int ticketsSold;
    // constructor
    java.util.Scanner scanObj = new java.util.Scanner(System.in);
    public BilletautomatClass(double ticketPrice, double startBalance) {
        price = ticketPrice;
        balance = startBalance;
        //Checks for valid price before implementing
        while (price < 0 || balance < 0){
            System.err.println("Invalid price and/or startBalance");
            price=scanObj.nextDouble();
            balance=scanObj.nextDouble();
        }
        System.out.println("Price and balance has been created properly");
    }
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

    //SetPrice method
    public void setPrice(String accessCode, double newPrice) {
        //if password is correct and price is > 0, the price is updated
        if (accessCode.equals("1234") && newPrice > 0) {
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
        //if password is correct, the sales are returned
        if(accessCode.equals("1234")){
            return price*ticketsSold;
        }
        return 0;
    }
}