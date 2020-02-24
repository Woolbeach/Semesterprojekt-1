
public class BilletautomatClass {
    private int price;
    private int balance;
    private int ticketsSold;

    //SetPrice method
    public void setPrice(String accessCode, int newPrice) {
        if (accessCode.equals("1234")) price = newPrice;
        else System.err.println("Access denied - Wrong passcode");
    }
}