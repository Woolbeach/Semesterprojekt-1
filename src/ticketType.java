public class ticketType {
    public String name;
    public double price;
    public int id;
    public int ticketsSold;

    //konstruktøren
    ticketType(String name1, double price1, int id1){
        name = name1;
        price = price1;
        id = id1;
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
    public void printTicket() {
            System.out.println("##########B##T#########");
            System.out.println("# Borgen Trafikselskab #");
            System.out.println("#\t\t\t\t#");
            System.out.println("#\t"+name+"-Billet\t#");
            System.out.println("#\t" + price + " kr.\t#");
            System.out.println("#\t\t\t\t#");
            System.out.println("##########B##T#########");
            System.out.println("##########B##T#########");
            System.out.println();
    }

    public String basketString(){
        return name;
    }

    //printer information om billeten
    public String toString(){
        return "#"+id +"\tType: " + name + "\n#\tPrice: " + price+" DKK\n";
    }

}




