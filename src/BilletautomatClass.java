
public class BilletautomatClass {
    private double price;
    private double balance;
    private int ticketsSold;

    //Constructor
    public BilletautomatClass(double ticketPrice) {
        //Checks for valid price before implementing
        if (ticketPrice > 0) price = ticketPrice;
        else System.err.println("Unable to set price - invalid value");
    }

    //SetPrice method
    public void setPrice(String accessCode, double newPrice) {
        //if password is correct, the price is updated
        if (accessCode.equals("1234")) price = newPrice;
        else System.err.println("Access denied - Wrong passcode");
    }

    //returns current balance value
    public double getBalance(){
        return balance;
    }

    //returns collective sales as an integer
    public double getSales(String accessCode){
        //if password is correct, the sales are returned
        if(accessCode.equals("1234")){
            return price*ticketsSold;
        }
    }
}