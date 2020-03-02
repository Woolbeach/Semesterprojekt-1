public class ticketType {
    public String name;
    public double price;
    public int id;

    ticketType(String name, double price, int id){
        name = name;
        price = price;
        id = id;
    }

    // Returns the price of a tickets current price
    public double getPrice() {
        return price;
    }
    //SetPrice method
    public void setPrice(double newPrice) {
        if (newPrice > 0) {            //if price is > 0, the price is updated
            price = newPrice;
        } else System.err.println("Invalid price");
    }
    // Prints out a ticket and the price of the ticket
    public void printTicket(int balance) {
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

}




