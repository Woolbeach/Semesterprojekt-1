/*--------------------------------------------------------------------------------
|   Group:          Team extreme
|   Names:          Christian Ulstrand (s195162), Filip Kristiansen (s195169) & Jonas Gehrke (s195155)
|   Project:        Billetautomat
|   Class purpose:  Main class
 --------------------------------------------------------------------------------*/
public class Billetautomat {
    private int price;
    private int balance;
    private int ticketsSold;

    //SetPrice method
    public void setPrice(String accessCode, int newPrice) {
        if (accessCode.equals("1234")) price = newPrice;
        else System.err.println("Access denied - Wrong passcode");
    }
}
