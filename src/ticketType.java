public class ticketType {
    public String name;
    public double price;
    public int id;
    public int ticketsSold;

    ticketType(String name, double price, int id){
        name = name;
        price = price;
        id = id;
    }

    //Returns collective sales as a double
    public double getSales() {
        return price * ticketsSold;
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
            System.out.println("##########B##T#########");
            System.out.println("# Borgen Trafikselskab #");
            System.out.println("#\t\t\t\t#");
            System.out.println("#\t"+name+"-Billet\t#");
            System.out.println("#\t" + price + " kr.\t#");
            System.out.println("#\t\t\t\t#");
            System.out.println("##########B##T#########");
            System.out.println("##########B##T#########");
            System.out.println();
        }else{
            System.out.println("Not enough balance");
        }
    }

}




