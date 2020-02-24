
public class BilletautomatClass {
    private int price;
    private int balance;
    private int ticketsSold;

    public int getPrice() {
        return price;
    } // Returns the price of a tickets current price

    public void udskrivBillet() {                       // Prints out a ticket and the price of the ticket
        System.out.println("##########B##T#########");  //
        System.out.println("# BlueJ Trafikselskab #");
        System.out.println("#                     #");
        System.out.println("#        Billet       #");
        System.out.println("#        " + pris + " kr.       #");
        System.out.println("#                     #");
        System.out.println("##########B##T#########");
        System.out.println("##########B##T#########");
        System.out.println();
    }
    //SetPrice method
    public void setPrice(String accessCode, int newPrice) {
        if (accessCode.equals("1234")) price = newPrice;
        else System.err.println("Access denied - Wrong passcode");
    }
}